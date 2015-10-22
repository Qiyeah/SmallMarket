package com.huayu.A11_3.View;

import com.huayu.A11_3.DAO.BuyerDAO;
import com.huayu.A11_3.DAO.SellerDAO;
import com.huayu.A11_3.DTO.ChargeDTO;
import com.huayu.A11_3.Model.ChargeLog;
import com.huayu.A11_3.Model.Seller;
import com.huayu.A11_3.Util.GetData;
import com.huayu.A11_3.Util.Next;

import java.util.ArrayList;

/**
 * Created by Qiyeah on 2015/10/21.
 */
public class ChargeCenter {
    public void charge(Seller seller){
        ChargeDTO cgDTO = new ChargeDTO();
        SellerDAO slDAO = new SellerDAO();
        GetData gd = new GetData();
        ArrayList<ChargeLog> chargeList = slDAO.listChargeLog(0);
        if (chargeList.size()!=0) {
            for (int i = 0; i < 1; ) {
                System.out.println("---------------------------δ��ֵ��¼��----------------------------------");
                for (int j = 0; j< chargeList.size(); j++) {
                    ChargeLog cl = chargeList.get(i);
                    System.out.println("�� " + (j + 1) + " ����ֵ��¼��" + cl.getCl_ID() + "\t" + cl.getBuyer_ID() + "\t" + cl.getCl_Money() + "\t" + cl.getCl_State() + "\t" + cl.getCl_Date());
                }
                System.out.println("-------------------------------------------------------------------------");
                System.out.println("����Ҫ��ֵ���û���");
                int index = Integer.parseInt(gd.getData()) - 1;
                ChargeLog cl = chargeList.get(index);
                BuyerDAO brDAO = new BuyerDAO();
                boolean cg = brDAO.changeChargeState(1, cl.getBuyer_ID());
                boolean cg1 = brDAO.plusBuyerMoney(cl.getBuyer_ID(), cl.getCl_Money());
                if (cg && cg1) {
                    System.out.println("��ֵ�ɹ���");
                    i = new Next().nextStep(gd, i);
                }
            }
        }else {
            System.out.println("δ�ҵ���Ҫ��ֵ���û��������̼ҹ�������");
            new SellerPage().sellerCenter(seller);
        }
    }
}
