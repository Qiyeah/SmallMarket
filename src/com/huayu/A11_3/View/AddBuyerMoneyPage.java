package com.huayu.A11_3.View;

import com.huayu.A11_3.DAO.BuyerDAO;
import com.huayu.A11_3.DAO.SellerDAO;
import com.huayu.A11_3.Model.Buyer;
import com.huayu.A11_3.Util.GetData;

/**
 * Created by Qiyeah on 2015/10/21.
 */
public class AddBuyerMoneyPage {
    public void addBuyerMoney(Buyer buyer){
        //ChargeDTO cgDTO = new ChargeDTO();
        SellerDAO slDAO = new SellerDAO();
        BuyerDAO brDAO = new BuyerDAO();
        GetData gd = new GetData();
        System.out.println("你要充值的金额：");
        double money = Double.parseDouble(gd.getData());
        boolean cl = brDAO.addCharge(buyer.getBuyer_ID(),money);
        boolean pl =slDAO.plusMoney(money);
        if (cl&&pl){
            System.out.println("充值金额已提交，等待商家充值");
            new BuyerPage().buyerCenter(buyer);
        }
    }
}
