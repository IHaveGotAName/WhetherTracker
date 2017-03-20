package com.podd.WeatherTracker.dto;


/**
 * Created by ivegotaname on 21.02.17.
 */
public class CityDTO {
    private Integer id;
    private String city;

    public CityDTO(){}
    public CityDTO(Integer id, String city){
        this.id = id;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
