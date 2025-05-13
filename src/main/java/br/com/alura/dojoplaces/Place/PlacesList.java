package br.com.alura.dojoplaces.Place;

import br.com.alura.dojoplaces.Utils.Formatter;

public class PlacesList {

    private Long id;
    private String name;
    private String code;
    private String city;
    private String createdAt;
    private String updatedAt;

    Formatter formatter = new Formatter();


    public PlacesList(Place place) {
        this.id = place.getId();
        this.name = place.getName();
        this.code = place.getCode();
        this.city = place.getCity();
        this.createdAt = formatter.formatterDate(place.getCreatedAt());
        this.updatedAt = formatter.formatterDaysSince(place.getUpdatedAt());
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }


}
