package br.com.alura.dojoplaces.Place;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UpdatePlaceValidator implements Validator {

    private final PlaceRepository placeRepository;

    public UpdatePlaceValidator(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return PlaceUpdateForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PlaceUpdateForm placeDto = (PlaceUpdateForm) target;

        Place place = placeRepository.findById(placeDto.getId()).orElse(null);

        if (!place.getCode().equals(placeDto.getCode()) && placeRepository.existsByCode(placeDto.getCode())) {
            errors.rejectValue("code", "", "Este código já está em uso.");
        }
    }
}
