package com.huayu.A11_3.Test;

import com.huayu.A11_3.DAO.BuyerDAO;
import com.huayu.A11_3.Model.Buyer;
import com.huayu.A11_3.View.BuyerPage;

/**
 * Created by Qiyeah on 2015/10/16.
 */
public class TestBuyerPage {
    public static void main(String[] args) {
        BuyerDAO byDAO = new BuyerDAO();
        Buyer buyer = new Buyer();
        buyer.setBuyer_ID("brid2015101611032157884121884352");
        new BuyerPage().buyerCenter(buyer);
    }
}
