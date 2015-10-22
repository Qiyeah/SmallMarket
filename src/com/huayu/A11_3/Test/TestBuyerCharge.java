package com.huayu.A11_3.Test;

import com.huayu.A11_3.DAO.BuyerDAO;
import com.huayu.A11_3.DTO.ChargeDTO;
import com.huayu.A11_3.Model.Buyer;
import com.huayu.A11_3.Util.GetData;
import com.huayu.A11_3.View.AddBuyerMoneyPage;

import java.time.chrono.ThaiBuddhistEra;

/**
 * Created by Qiyeah on 2015/10/21.
 */
public class TestBuyerCharge {
    public static void main(String[] args) {
        Buyer buyer = new Buyer();
        buyer.setBuyer_ID("brid2015101611032157884121884352");
        //new BuyerDAO().addCharge(buyer.getBuyer_ID(),Double.parseDouble(new GetData().getData()));
        new AddBuyerMoneyPage().addBuyerMoney(buyer);
    }
}
