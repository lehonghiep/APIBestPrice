package com.honghiep.apibestprice.controller;

import com.google.gson.Gson;
import com.honghiep.apibestprice.model.goods.Goods;
import com.honghiep.apibestprice.model.goods.ResultGoods;
import com.honghiep.apibestprice.model.menuitem.MenuItemChild;
import com.honghiep.apibestprice.model.menuitem.MenuItemParent;
import com.honghiep.apibestprice.model.menuitem.ResultMenuItem;
import com.honghiep.apibestprice.model.news.News;
import com.honghiep.apibestprice.model.news.ResultNews;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by honghiep on 26/08/2017.
 */
@RestController
@RequestMapping("/user")
public class Controller {
    @GetMapping(value = "getMenuItem")
    public String getMenuItem(){
        List<MenuItemParent>menuItems=new ArrayList<>();
            String linkRoot = "https://websosanh.vn";
            try {
                Document document = Jsoup.connect(linkRoot).get();
                Elements element = document.select("ul.dropdown-menu")
                        .first().select("ul.dropdown-menu > li");
                        int i=0;
                for (Element e : element) {
                    int j=0;
                    List<MenuItemChild>menuItemChildren=new ArrayList<>();
                    for (Element el : e.select("ul.hidden > li")) {
                        String linkChild=
                                el.select("a").first()
                                .attr("href");
                        String titleChild=
                                el.select("a").first()
                                .attr("title");
                        menuItemChildren.add(new MenuItemChild(j,titleChild,linkChild));
                        j++;
                    }
                    String link = e.select("a").first()
                            .attr("href");
                    String title=e.select("a").first()
                            .attr("title");
                    menuItems.add(new MenuItemParent(i,title,link,menuItemChildren));
                    i++;
                }


            } catch (IOException e) {
                e.printStackTrace();
            }


        return new Gson().toJson(new ResultMenuItem(menuItems));
    }
    @GetMapping(value = "getGoods")
    public String getGoods(@RequestParam(value = "keysearch", required = true)String keysearch,
                                @RequestParam(value = "pi", required = true)String pi){
            String key = keysearch.toString().
                    trim().
                    replaceAll(" ","+");

            String linkRoot = "https://websosanh.vn/s/"
                    + key.replaceAll(" ", "+")+"?pi="+pi+".htm";
        return getJsoupGoods(linkRoot);
    }

    private String getJsoupGoods(String linkRoot) {
        List<Goods> goodsList=new ArrayList<>();
        try {
            Document document = Jsoup.connect(linkRoot).get();
            Elements elements = document.select("li.item");
            Elements elements1=document.select("ul.pagination");
            if(elements1.get(0).select("li").size()<=2){
                return null;
            }

            for (Element element : elements) {
                String linkwebsite = element.select("a").first()
                        .attr("href");
                String linkImg=element.select("img").first()
                        .attr("src");
                String name=element.select("h3.title").text();
                String money=element.select("div.price").text();
                String place=element.select("div.quantity").text();
                goodsList.add(new Goods(name,money,place,linkImg,linkwebsite));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Gson().toJson(new ResultGoods(goodsList));
    }


    @GetMapping(value = "getNewsThongTinThiTruong")
    public String getNewsThongTinThiTruong(){

        String linkRoot = "https://websosanh.vn/review/thong-tin-thi-truong-c2.htm";
        return getJsoupNews(linkRoot);
    }



    @GetMapping(value = "getNewsXuTheTieuDung")
    public String getNewsXuTheTieuDung(){
        String linkRoot = "https://websosanh.vn/review/thong-tin-thi-truong-c2.htm";
        return getJsoupNews(linkRoot);
    }

    @GetMapping(value = "getNewsReviews")
    public String getNewsReviews(){
        String linkRoot = "https://websosanh.vn/review/reviews-c1.htm";
        return getJsoupNews(linkRoot);
    }

    @GetMapping(value = "getNewsTuVanMuaSam")
    public String getNewsTuVanMuaSanPham(){
        String linkRoot = "https://websosanh.vn/review/tu-van-mua-sam-c20.htm";
        return getJsoupNews(linkRoot);
    }

    @GetMapping(value = "getNewsDienLanh")
    public String getNewsDienLanh(){
        String linkRoot = "https://websosanh.vn/review/dien-lanh-c26.htm";
        return getJsoupNews(linkRoot);
    }
    @GetMapping(value = "getNewsOtoXeMayXeDap")
    public String getNewsOtoXeMayXeDap(){
        String linkRoot = "https://websosanh.vn/review/o-to-xe-may-xe-dap-c33.htm";
        return getJsoupNews(linkRoot);
    }

    @GetMapping(value = "getNewsMeoVat")
    public String getNewsMeoVat(){
        String linkRoot = "https://websosanh.vn/review/meo-vat-c67.htm";
        return getJsoupNews(linkRoot);
    }

    @GetMapping(value = "getNewsSanPhamChoMe")
    public String getNewsSanPhamChoMe(){
        String linkRoot = "https://websosanh.vn/review/san-pham-cho-me-c31.htm";
        return getJsoupNews(linkRoot);
    }

    private String getJsoupNews(String linkRoot) {
        List<News> news=new ArrayList<>();
        try {
            Document document = Jsoup.connect(linkRoot).get();
            Element el1 = document.select("div.focus-large")
                    .first();
            String linkImg1=el1.select("img").attr("src");
            String linkWebsite1=el1.select("div.img-wrap > a").attr("href");
            String title1=el1.select("h1").text();
            news.add(new News(title1, linkImg1, linkWebsite1));

            Elements els2 = document.select("div.focus-small").select("li");
            for (Element el2 : els2) {
                String linkImg2=el2.select("img").attr("src");
                String linkWebsite2=el2.select("div.img-wrap > a").attr("href");
                String title2=el2.select("h3").text();
                news.add(new News(title2, linkImg2, linkWebsite2));
            }

            Elements els3 = document.select("li.media");
            for (Element el3 : els3) {
                String linkImg3=el3.select("img").attr("src");
                String linkWebsite3=el3.select("div.img-wrap > a").attr("href");
                String title3=el3.select("h3").text();
                news.add(new News(title3, linkImg3, linkWebsite3));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return new Gson().toJson(new ResultNews(news));
    }
}
