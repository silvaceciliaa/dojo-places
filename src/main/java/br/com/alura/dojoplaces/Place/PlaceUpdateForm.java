package br.com.alura.dojoplaces.Place;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PlaceUpdateForm {

    private Long id;

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    private String code;

    @NotBlank
    @Size(max = 100)
    private String neighbourhood;

    @NotBlank
    @Size(max = 100)
    private String city;

    public PlaceUpdateForm() {
    }

    public PlaceUpdateForm(String name, String code, String neighbourhood, String city) {
        this.name = name;
        this.code = code;
        this.neighbourhood = neighbourhood;
        this.city = city;
    }

//    public Place update(Place place){
//        place.setName(this.name);
//        place.setCode(this.code);
//        place.setNeighbourhood(this.neighbourhood);
//        place.setCity(this.city);
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
