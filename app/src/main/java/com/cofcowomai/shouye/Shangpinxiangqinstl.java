package com.cofcowomai.shouye;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/12/17.
 */

public class Shangpinxiangqinstl implements Serializable{

    private String goodId;//商品ID
    private String goodPhoto;//商品图片
    private String goodName;//商品名
    private String goodDescribe;//商品描述
    private String goodPrice;//商品价格
    private String goodType;//商品类型
    private String goodNum;//商品数量
    private String goodWeight;//商品重量
    private String goodIntegral;//商品积分
    private String goodPlateType;//商品属于哪块板块类型

    public String getGoodPlateType() {
        return goodPlateType;
    }

    public void setGoodPlateType(String goodPlateType) {
        this.goodPlateType = goodPlateType;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public Shangpinxiangqinstl(String goodPhoto, String goodName, String goodDescribe, String goodPrice, String goodType) {
        this.goodPhoto = goodPhoto;
        this.goodName = goodName;
        this.goodDescribe = goodDescribe;
        this.goodPrice = goodPrice;
        this.goodType = goodType;
    }

    public Shangpinxiangqinstl(String goodPhoto, String goodName, String goodPrice) {
        this.goodPhoto = goodPhoto;
        this.goodName = goodName;
        this.goodPrice = goodPrice;
    }

    public String getGoodType() {
        return goodType;
    }

    public void setGoodType(String goodType) {
        this.goodType = goodType;
    }

    public String getGoodDescribe() {
        return goodDescribe;
    }

    public void setGoodDescribe(String goodDescribe) {
        this.goodDescribe = goodDescribe;
    }

    public String getGoodPhoto() {
        return goodPhoto;
    }

    public void setGoodPhoto(String goodPhoto) {
        this.goodPhoto = goodPhoto;
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

    public String getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(String goodNum) {
        this.goodNum = goodNum;
    }

    public String getGoodWeight() {
        return goodWeight;
    }

    public void setGoodWeight(String goodWeight) {
        this.goodWeight = goodWeight;
    }

    public String getGoodIntegral() {
        return goodIntegral;
    }

    public void setGoodIntegral(String goodIntegral) {
        this.goodIntegral = goodIntegral;
    }

    public Shangpinxiangqinstl() {
    }

    public Shangpinxiangqinstl(String goodPhoto, String goodName, String goodPrice, String goodNum, String goodWeight, String goodIntegral) {
        this.goodPhoto = goodPhoto;
        this.goodName = goodName;
        this.goodPrice = goodPrice;
        this.goodNum = goodNum;
        this.goodWeight = goodWeight;
        this.goodIntegral = goodIntegral;
    }
}
