package com.huayu.A11_3.View;

import com.huayu.A11_3.Model.Buyer;

/**
 * Created by Qiyeah on 2015/10/16.
 */
public class BuyGoodsPage {
    public void buyGoods(Buyer buyer){
        System.out.println("-------------------��ӭ �� " + buyer.getBuyer_Name() + " ��ʹ��ͼ�����ϵͳ-------------------");
        System.out.println("|-1.������Ϣ\n|-2.�޸�����\n|-3.���ﳵ\n|-4.֧��" + "\n|-5.�ʻ���ֵ\n|-6.�˳���½");
        System.out.println("-------------------------------------------------------------------------");
    }
}
