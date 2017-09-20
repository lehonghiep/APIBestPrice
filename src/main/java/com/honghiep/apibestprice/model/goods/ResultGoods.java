package com.honghiep.apibestprice.model.goods;

import java.util.List;

/**
 * Created by honghiep on 11/09/2017.
 */
public class ResultGoods {
    List<Goods> goodsList;
    public ResultGoods(List<Goods>goodsList){
        this.goodsList=goodsList;
    }
}
