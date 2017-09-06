package com.honghiep.apibestprice;

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
    @GetMapping(value = "hahaha")
    public String getData(@RequestParam(value = "keysearch", required = true)String keysearch){
        String link="";
        int i=1;
        while (i<2){

            String key = keysearch.toString().
                    trim().
                    replaceAll(" ","+");

            String linkRoot = "https://websosanh.vn/s/"
                    + key.replaceAll(" ", "+")+"?pi="+i+".htm";
            try {
                Document document = Jsoup.connect(linkRoot).get();
                Elements elements = document.select("li.item");
                Elements elements1=document.select("ul.pagination");
                if(elements1.get(0).select("li").size()<=2){
                    break;
                }
                i++;
                for (Element element : elements) {
                    String l = element.select("a").first()
                            .attr("href");
                    link=link+l+"\t\n";


                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return link;
    }
    @GetMapping(value = "getGoods")
    public List<Goods> getGoods(@RequestParam(value = "keysearch", required = true)String keysearch){
        List<Goods>goodsList=new ArrayList<>();
        int i=1;
        while (i<2){

            String key = keysearch.toString().
                    trim().
                    replaceAll(" ","+");

            String linkRoot = "https://websosanh.vn/s/"
                    + key.replaceAll(" ", "+")+"?pi="+i+".htm";
            try {
                Document document = Jsoup.connect(linkRoot).get();
                Elements elements = document.select("li.item");
                Elements elements1=document.select("ul.pagination");
                if(elements1.get(0).select("li").size()<=2){
                    break;
                }
                i++;
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
        }

        return goodsList;
    }
}
