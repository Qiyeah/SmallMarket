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
        System.out.println("-------------------欢迎 【 " + buyer.getBuyer_Name() + " 】使用牛xx系统-------------------");
        System.out.println("|-1.个人信息\n|-2.修改资料\n|-3.购物车\n|-4.支付" + "\n|-5.帐户充值\n|-6.退出登陆");
        System.out.println("-------------------------------------------------------------------------");

        boolean flag = true;
        for(int i = 0; i < 1;) {
            ArrayList<Goods> gdList = new ArrayList<Goods>();
            String cmd1 = gd.getData();
            if ("1".equals(cmd1)) {//个人信息
                i++;
                new QueryBuyerInfoPage().queryBuyerInfo(buyer);
            } else if ("2".equals(cmd1)) {//修改资料
                i++;
                new AlterBuyerInfo().alterInfo(buyer);
            } else if ("3".equals(cmd1)) {//购物车
                i++;
                new ShoppingCart().shoppingList(buyer);
            } else if ("4".equals(cmd1)) {//支付
                i++;
                new Pay().pay(buyer);
            } else if ("5".equals(cmd1)) {//帐户充值
                i++;
                new AddBuyerMoneyPage().addBuyerMoney(buyer);
            } else if ("6".equals(cmd1)) {//退出登陆
                i++;
                System.out.println("页面提示：系统即将退出... ...");
                System.exit(0);
            } else {
                System.out.println("页面提示：please enter again");
            }
        }
    }
}
