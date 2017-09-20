package com.honghiep.apibestprice.model.goods;

/**
 * Created by honghiep on 06/09/2017.
 */
public class Goods {
    private String name;
    private String money;
    private String place;
    private String linkImg;
    private String linkwebsite;

    public Goods(String name, String money, String place, String linkImg, String linkwebsite) {
        this.name = name;
        this.money = money;
        this.place = place;
        this.linkImg = linkImg;
        this.linkwebsite = linkwebsite;
    }

    public String getName() {
        return name;
    }

    public String getMoney() {
        return money;
    }

    public String getPlace() {
        return place;
    }

    public String getLinkImg() {
        return linkImg;
    }

    public String getLinkwebsite() {
        return linkwebsite;
    }
}
