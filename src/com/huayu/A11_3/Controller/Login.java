package com.huayu.A11_3.Controller;

import com.huayu.A11_3.DAO.BuyerDAO;
import com.huayu.A11_3.Model.Buyer;
import com.huayu.A11_3.Model.Seller;
import com.huayu.A11_3.Util.GetData;
import com.huayu.A11_3.View.BuyerPage;
import com.huayu.A11_3.View.SellerPage;

/**
 * Created by Qiyeah on 2015/10/16.
 */
public class Login {
    GetData gd = new GetData();
    BuyerDAO byDAO = new BuyerDAO();
    public void login(){
        for (int i = 0; i < 1;) {
            System.out.println("请选择登陆方式：\n1 . 买家\n2 . 卖家");
            String dec = gd.getData();
            if ("1".equals(dec)){
                System.out.println("输入用户名：");
                String name = gd.getData();
                System.out.println("输入密码：");
                String pass = gd.getData();
                Buyer buyer = byDAO.checkBuyerLogin(name, pass);
                if (buyer!=null){
                    i++;
                    System.out.println("登陆成功，即将跳转到个人中心...");
                    new BuyerPage().buyerCenter(buyer);
                }else {
                    System.out.println("Error:用户名或密码错误");
                }
            }else if("2".equals(dec)){
                System.out.println("输入用户名：");
                String name = gd.getData();
                System.out.println("输入密码：");
                String pass = gd.getData();
                Seller seller = byDAO.checkSellerLogin(name, pass);
                if (seller!=null){
                    i++;
                    System.out.println("登陆成功，即将跳转到个人中心...");
                    new SellerPage().sellerCenter(seller);
                }else {
                    System.out.println("Error:用户名或密码错误");
                }
            }else {
                System.out.println("Error:没有此登陆方式，请根据提示选择");
            }
        }
    }
}
