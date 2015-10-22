package com.huayu.A11_3.Test;

import com.huayu.A11_3.Model.Seller;
import com.huayu.A11_3.View.SellerPage;

/**
 * Created by Qiyeah on 2015/10/17.
 */
public class TestSellerPage {
    public static void main(String[] args) {
        Seller seller = new Seller("srid2015101611032157884121884352","admin","admin",0.00);
        new SellerPage().sellerCenter(seller);
    }
}
