package br.com.alura.dojoplaces;

import br.com.alura.dojoplaces.Place.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class UpdatePlaceValidatorTests {

    private PlaceRepository placeRepository;
    private UpdatePlaceValidator validator;

    @BeforeEach
    void setUp(){

        placeRepository = mock(PlaceRepository.class);

    }

    @Test
    void shouldHaveErrosWhenCodeExists(){
        PlaceUpdateForm placeUpdateForm = new PlaceUpdateForm();
        placeUpdateForm.setCode("code");

        Place place = new Place();
        place.setId(1L);
        place.setCode("codeDiferente");

        when(placeRepository.existsByCode("code")).thenReturn(true);
        when(placeRepository.findById(placeUpdateForm.getId())).thenReturn(Optional.of(place));

        validator = new UpdatePlaceValidator(placeRepository);

        Errors errors = new BeanPropertyBindingResult(placeUpdateForm, "placeUpdateForm");
        validator.validate(placeUpdateForm, errors);

        assertTrue(errors.hasErrors());
        verify(placeRepository, times(1)).existsByCode("code");
        assertTrue(errors.hasFieldErrors("code"), "O erro deveria estar no campo 'code'.");


    }

    @Test
    void shouldNotHaveErrosWhenCodeDoesntExists(){
        PlaceUpdateForm placeUpdateForm = new PlaceUpdateForm();
        placeUpdateForm.setCode("code");

        Place place = new Place();
        place.setId(1L);
        place.setCode("codeDiferente");

        when(placeRepository.existsByCode("code")).thenReturn(false);
        when(placeRepository.findById(placeUpdateForm.getId())).thenReturn(Optional.of(place));

        validator = new UpdatePlaceValidator(placeRepository);

        Errors errors = new BeanPropertyBindingResult(placeUpdateForm, "placeUpdateForm");
        validator.validate(placeUpdateForm, errors);

        assertFalse(errors.hasErrors());

    }
}
