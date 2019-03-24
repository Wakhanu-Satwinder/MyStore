package com.gadaffi.mystore.api;

import com.google.gson.annotations.SerializedName;

public class Bookings {

    @SerializedName("buildingname")
    private String buildingname;
    @SerializedName("roomnumber")
    private String roomnumber;
    @SerializedName("image")
    private String image;
    @SerializedName("price")
    private String price;
    @SerializedName("datebooked")
    private String datebooked;

    public Bookings(String buildingname, String roomnumber, String image, String price, String datebooked) {

        this.image = image;
        this.buildingname = buildingname;
        this.roomnumber = roomnumber;
        this.price = price;
        this.datebooked = datebooked;

    }

    /*
     *GETTERS AND SETTERS
     */

    public String getBuildingname() {
        return buildingname;
    }
    public String getRoomnumber() {
        return roomnumber;
    }

    public String getPrice() {
        return price;
    }

    public String getDatebooked() {
        return datebooked;
    }

    public String getImage() {
        return image;
    }

}