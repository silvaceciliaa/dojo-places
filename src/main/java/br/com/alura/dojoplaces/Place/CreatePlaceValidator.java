package br.com.alura.dojoplaces.Place;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CreatePlaceValidator implements Validator {

    private final PlaceRepository placeRepository;

    public CreatePlaceValidator(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return PlaceCreateForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PlaceCreateForm place = (PlaceCreateForm) target;

        if (placeRepository.existsByCode(place.getCode())) {
            errors.rejectValue("code", "", "Este código já está em uso.");
        }
    }
}

