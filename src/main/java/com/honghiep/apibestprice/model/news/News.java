package com.honghiep.apibestprice.model.news;

/**
 * Created by honghiep on 11/09/2017.
 */
public class News {
    private String title;
    private String linkImg;
    private String linkWebsite;

    public News(String title, String linkImg, String linkWebsite) {
        this.title = title;
        this.linkImg = linkImg;
        this.linkWebsite = linkWebsite;
    }

    public String getTitle() {
        return title;
    }

    public String getLinkImg() {
        return linkImg;
    }

    public String getLinkWebsite() {
        return linkWebsite;
    }
}
