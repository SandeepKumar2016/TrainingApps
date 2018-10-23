package com.example.fragmentwithrecyclerview;

public class UserData {

    private String userName, userCity;
    private int cityImage;

    public UserData(String userName, String userCity, int cityImage) {
        this.userName = userName;
        this.userCity = userCity;
        this.cityImage = cityImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public int getCityImage() {
        return cityImage;
    }

    public void setCityImage(int cityImage) {
        this.cityImage = cityImage;
    }
}
