package com.huayu.A11_3.View;

import com.huayu.A11_3.Model.Buyer;

/**
 * Created by Qiyeah on 2015/10/16.
 */
public class BuyGoodsPage {
    public void buyGoods(Buyer buyer){
        System.out.println("-------------------欢迎 【 " + buyer.getBuyer_Name() + " 】使用图书管理系统-------------------");
        System.out.println("|-1.个人信息\n|-2.修改密码\n|-3.购物车\n|-4.支付" + "\n|-5.帐户充值\n|-6.退出登陆");
        System.out.println("-------------------------------------------------------------------------");
    }
}
