package br.com.alura.dojoplaces.Place;


import br.com.alura.dojoplaces.excpetions.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.Map;


@Controller
public class PlaceController {

    private final PlaceRepository placeRepository;
    private final CreatePlaceValidator createPlaceValidator;
    private final UpdatePlaceValidator updatePlaceValidator;


    public PlaceController(PlaceRepository placeRepository, CreatePlaceValidator createPlaceValidator, UpdatePlaceValidator updatePlaceValidator){
        this.placeRepository = placeRepository;
        this.createPlaceValidator = createPlaceValidator;
        this.updatePlaceValidator = updatePlaceValidator;
    }

    @InitBinder("placeCreateForm")
    protected void initCreateBinder(WebDataBinder binder) {
        binder.addValidators(createPlaceValidator);
    }

    @InitBinder("placeUpdateForm")
    protected void initUpdateBinder(WebDataBinder binder) {
        binder.addValidators(updatePlaceValidator);
    }


    @GetMapping("/add-place")
    public String form(PlaceCreateForm form, Model model){
        model.addAttribute("placeCreateForm", form);
        return "form";
    }

    @GetMapping("/update-place")
    public String formEditar(PlaceUpdateForm form, Model model){

        model.addAttribute("placeUpdateForm", form);
        return "update-form";
    }

    @GetMapping("/list-places")
    public String listPlaces(Model model){
        List<PlacesList> placesList = placeRepository.findAll().stream().map(PlacesList::new).toList();
        model.addAttribute("places", placesList);

        return "list";
    }

    @PostMapping("/add-new-place")
    public String newPlace(@Valid PlaceCreateForm form, BindingResult result, Model model) {

        if(result.hasErrors()){
            return form(form, model);
        }
            placeRepository.save(form.toPlace());


        return "redirect:/list-places";
    }

    @PostMapping("/update-a-place")
    public String updatePlace(@Valid PlaceUpdateForm form, BindingResult result, Model model) {

        Place place = placeRepository.findById(form.getId()).orElseThrow(() -> new NotFoundException("falta de id"));

        if(result.hasErrors()){
            return formEditar(form, model);
        }

        place.update(form);
        placeRepository.save(place);

        return "redirect:/list-places";
    }

    @GetMapping("/delete-place/{id}")
    public String deletePlace(@PathVariable Long id) {
        Place place = placeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Lugar não encontrado para o ID: " + id));

        placeRepository.delete(place);

        return "redirect:/list-places";
    }

    @GetMapping("/cep/{cep}")
    @ResponseBody
    public ResponseEntity<?> buscarCep(@PathVariable String cep) {
        if (!cep.matches("\\d{8}")) {
            return ResponseEntity.badRequest().body("CEP inválido.");
        }

        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        RestTemplate restTemplate = new RestTemplate();

        try {
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);
            if (Boolean.TRUE.equals(response.get("erro"))) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CEP não encontrado.");
            }
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao consultar CEP.");
        }
    }




}
