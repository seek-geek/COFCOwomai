package com.cofcowomai.shouye;


public class Xiansd2 {
    private  String goodName;
    private  String goodPrice;
    private  String goodPhoto;
    public Xiansd2(){


    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(String goodPrice) {
        this.goodPrice = goodPrice;
    }

    public String getGoodPhoto() {
        return goodPhoto;
    }

    public void setGoodPhoto(String goodPhoto) {
        this.goodPhoto = goodPhoto;
    }

    public Xiansd2(String goodName, String goodPrice, String goodPhoto) {
        this.goodName = goodName;
        this.goodPrice = goodPrice;
        this.goodPhoto = goodPhoto;
    }
}
