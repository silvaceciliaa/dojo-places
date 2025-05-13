package br.com.alura.dojoplaces;

import br.com.alura.dojoplaces.Place.CreatePlaceValidator;
import br.com.alura.dojoplaces.Place.PlaceCreateForm;
import br.com.alura.dojoplaces.Place.PlaceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class CreatePlaceValidatorTests {

    private PlaceRepository placeRepository;
    private CreatePlaceValidator validator;

    @BeforeEach
    void setUp(){

        placeRepository = mock(PlaceRepository.class);

    }

    @Test
    void shouldHaveErrosWhenCodeExists(){
        PlaceCreateForm placeCreateForm = new PlaceCreateForm();
        placeCreateForm.setCode("code");

        when(placeRepository.existsByCode("code")).thenReturn(true);

        validator = new CreatePlaceValidator(placeRepository);

        Errors errors = new BeanPropertyBindingResult(placeCreateForm, "placeCreateForm");
        validator.validate(placeCreateForm, errors);

        assertTrue(errors.hasErrors());
        verify(placeRepository, times(1)).existsByCode("code");
        assertTrue(errors.hasFieldErrors("code"), "O erro deveria estar no campo 'code'.");


    }

    @Test
    void shouldNotHaveErrosWhenCodeDoesntExists(){
        PlaceCreateForm placeCreateForm = new PlaceCreateForm();
        placeCreateForm.setCode("code");

        when(placeRepository.existsByCode("code")).thenReturn(false);

        validator = new CreatePlaceValidator(placeRepository);

        Errors errors = new BeanPropertyBindingResult(placeCreateForm, "placeCreateForm");
        validator.validate(placeCreateForm, errors);

        assertFalse(errors.hasErrors());

    }
}
