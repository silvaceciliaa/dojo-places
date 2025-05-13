package br.com.alura.dojoplaces.Place;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private String cep;
    private String neighbourhood;
    private String city;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;

    public Place(String name, String code, String cep, String neighbourhood, String city) {
        this.name = name;
        this.code = code;
        this.cep = cep;
        this.neighbourhood = neighbourhood;
        this.city = city;
    }

    public Place() {
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getCep() {
        return cep;
    }

    public String getCity() {
        return city;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setCep(String cep) {
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

    public void setName(String name) {
        this.name = name;
    }

    public void update(PlaceUpdateForm form){
        this.setName(form.getName());
        this.code = form.getCode();
        this.neighbourhood = form.getNeighbourhood();
        this.city = form.getCity();
        this.setUpdatedAt(LocalDateTime.now());
    }
}
