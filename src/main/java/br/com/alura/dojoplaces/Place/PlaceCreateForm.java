package br.com.alura.dojoplaces.Place;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PlaceCreateForm {

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    private String code;

    private String cep;

    @NotBlank
    @Size(max = 100)
    private String neighbourhood;

    @NotBlank
    @Size(max = 100)
    private String city;

    public PlaceCreateForm() {
    }

    public PlaceCreateForm(String name, String code, String cep, String neighbourhood, String city) {
        this.name = name;
        this.code = code;
        this.cep = cep;
        this.neighbourhood = neighbourhood;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getCep(){
        return cep;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public String getCity() {
        return city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCep(String cep){
        this.cep = cep;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Place toPlace(){
        return new Place(this.name, this.code, this.cep, this.neighbourhood, this.city);
    }


    @Override
    public String toString() {
        return "PlaceCreateForm{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", cep='" + cep + '\'' +
                ", neighbourhood='" + neighbourhood + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
