package com.example.recyclerpractice;

public class nederalndsCities {

    private String personName, cityName;

    private int cityImage;

    public nederalndsCities(String personName, String cityName, int cityImage) {
        this.personName = personName;
        this.cityName = cityName;
        this.cityImage = cityImage;
    }


    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityImage() {
        return cityImage;
    }

    public void setCityImage(int cityImage) {
        this.cityImage = cityImage;
    }
}
