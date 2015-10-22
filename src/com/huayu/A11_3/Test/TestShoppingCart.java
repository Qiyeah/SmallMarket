package com.huayu.A11_3.Test;

import com.huayu.A11_3.Model.Buyer;
import com.huayu.A11_3.Model.Goods;
import com.huayu.A11_3.Util.ListGoods;
import com.huayu.A11_3.View.ShoppingCart;

import java.util.ArrayList;

/**
 * Created by Qiyeah on 2015/10/17.
 */
public class TestShoppingCart {
    public static void main(String[] args) {
        Buyer buyer = null;
        new ShoppingCart().shoppingList(buyer);
        //new ListGoods().printGoods(spCart);
    }
}
