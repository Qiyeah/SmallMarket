package com.huayu.A11_3.View;

import com.huayu.A11_3.Model.Buyer;
import com.huayu.A11_3.Model.Goods;
import com.huayu.A11_3.Util.GetData;
import java.util.ArrayList;

/**
 * Created by Qiyeah on 2015/10/16.
 */
public class BuyerPage {

    GetData gd = new GetData();
    public void buyerCenter(Buyer buyer) {
        ArrayList<Goods> spCart = null;
        System.out.println("-------------------��ӭ �� " + buyer.getBuyer_Name() + " ��ʹ��ţxxϵͳ-------------------");
        System.out.println("|-1.������Ϣ\n|-2.�޸�����\n|-3.���ﳵ\n|-4.֧��" + "\n|-5.�ʻ���ֵ\n|-6.�˳���½");
        System.out.println("-------------------------------------------------------------------------");

        boolean flag = true;
        for(int i = 0; i < 1;) {
            ArrayList<Goods> gdList = new ArrayList<Goods>();
            String cmd1 = gd.getData();
            if ("1".equals(cmd1)) {//������Ϣ
                i++;
                new QueryBuyerInfoPage().queryBuyerInfo(buyer);
            } else if ("2".equals(cmd1)) {//�޸�����
                i++;
                new AlterBuyerInfo().alterInfo(buyer);
            } else if ("3".equals(cmd1)) {//���ﳵ
                i++;
                new ShoppingCart().shoppingList(buyer);
            } else if ("4".equals(cmd1)) {//֧��
                i++;
                new Pay().pay(buyer);
            } else if ("5".equals(cmd1)) {//�ʻ���ֵ
                i++;
                new AddBuyerMoneyPage().addBuyerMoney(buyer);
            } else if ("6".equals(cmd1)) {//�˳���½
                i++;
                System.out.println("ҳ����ʾ��ϵͳ�����˳�... ...");
                System.exit(0);
            } else {
                System.out.println("ҳ����ʾ��please enter again");
            }
        }
    }
}
