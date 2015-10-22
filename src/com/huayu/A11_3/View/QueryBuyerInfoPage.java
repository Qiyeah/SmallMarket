package com.huayu.A11_3.View;

import com.huayu.A11_3.DAO.BuyerDAO;
import com.huayu.A11_3.Model.Buyer;
import com.huayu.A11_3.Util.GetData;
import com.huayu.A11_3.Util.Next;

/**
 * Created by Qiyeah on 2015/10/19.
 */
public class QueryBuyerInfoPage {
    public void queryBuyerInfo(Buyer buyer){
        GetData gd = new GetData();
        buyer =  new BuyerDAO().queryBuyer(buyer.getBuyer_ID());
        System.out.println("----------------------- 【 " + buyer.getBuyer_Name() + " 】个人资料-----------------------");
        System.out.println("|-用户ID："+buyer.getBuyer_ID()+"\n|-用户电话："+buyer.getBuyer_Phone()
                +"\n|-用户余额："+buyer.getBuyer_Money()+"\n|-用户邮箱："+buyer.getBuyer_Email());
        int next = new Next().nextStep(gd,0);
        if (1 == next){
            new BuyerPage().buyerCenter(buyer);
        }
    }
}
