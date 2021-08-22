package com.example.pizzaon.Models;

public class UsersOrderModel {

    int eachOrderImage;
    String eachOrderName, eachOrderPrice, eachOrderQuantity, eachOrderID;


    public UsersOrderModel() {
    }


    public UsersOrderModel(int eachOrderImage, String eachOrderName, String eachOrderPrice, String eachOrderQuantity, String eachOrderID) {
        this.eachOrderImage = eachOrderImage;
        this.eachOrderName = eachOrderName;
        this.eachOrderPrice = eachOrderPrice;
        this.eachOrderQuantity = eachOrderQuantity;
        this.eachOrderID = eachOrderID;
    }


    public int getEachOrderImage() {
        return eachOrderImage;
    }

    public void setEachOrderImage(int eachOrderImage) {
        this.eachOrderImage = eachOrderImage;
    }

    public String getEachOrderName() {
        return eachOrderName;
    }

    public void setEachOrderName(String eachOrderName) {
        this.eachOrderName = eachOrderName;
    }

    public String getEachOrderPrice() {
        return eachOrderPrice;
    }

    public void setEachOrderPrice(String eachOrderPrice) {
        this.eachOrderPrice = eachOrderPrice;
    }

    public String getEachOrderQuantity() {
        return eachOrderQuantity;
    }

    public void setEachOrderQuantity(String eachOrderQuantity) {
        this.eachOrderQuantity = eachOrderQuantity;
    }

    public String getEachOrderID() {
        return eachOrderID;
    }

    public void setEachOrderID(String eachOrderID) {
        this.eachOrderID = eachOrderID;
    }

}
