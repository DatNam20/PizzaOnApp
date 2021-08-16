package com.example.pizzaon.Models;

public class MainModel {

    int eachItemImage;
    String eachItemName, eachItemPrice, eachItemDescription;


    public MainModel(int eachItemImage, String eachItemName, String eachItemPrice, String eachItemDescription) {
        this.eachItemImage = eachItemImage;
        this.eachItemName = eachItemName;
        this.eachItemPrice = eachItemPrice;
        this.eachItemDescription = eachItemDescription;
    }


    public int getEachItemImage() {
        return eachItemImage;
    }

    public void setEachItemImage(int eachItemImage) {
        this.eachItemImage = eachItemImage;
    }

    public String getEachItemName() {
        return eachItemName;
    }

    public void setEachItemName(String eachItemName) {
        this.eachItemName = eachItemName;
    }

    public String getEachItemPrice() {
        return eachItemPrice;
    }

    public void setEachItemPrice(String eachItemPrice) {
        this.eachItemPrice = eachItemPrice;
    }

    public String getEachItemDescription() {
        return eachItemDescription;
    }

    public void setEachItemDescription(String eachItemDescription) {
        this.eachItemDescription = eachItemDescription;
    }

}
