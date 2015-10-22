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
        System.out.println("----------------------- �� " + buyer.getBuyer_Name() + " ����������-----------------------");
        System.out.println("|-�û�ID��"+buyer.getBuyer_ID()+"\n|-�û��绰��"+buyer.getBuyer_Phone()
                +"\n|-�û���"+buyer.getBuyer_Money()+"\n|-�û����䣺"+buyer.getBuyer_Email());
        int next = new Next().nextStep(gd,0);
        if (1 == next){
            new BuyerPage().buyerCenter(buyer);
        }
    }
}
