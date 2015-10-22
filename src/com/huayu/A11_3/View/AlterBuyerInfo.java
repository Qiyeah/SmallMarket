package com.huayu.A11_3.View;

import com.huayu.A11_3.Controller.Login;
import com.huayu.A11_3.DAO.BuyerDAO;
import com.huayu.A11_3.Model.Buyer;
import com.huayu.A11_3.Util.GetData;

/**
 * Created by Qiyeah on 2015/10/19.
 */
public class AlterBuyerInfo {
    public void alterInfo(Buyer buyer){
        BuyerDAO byDAO = new BuyerDAO();
        GetData gd = new GetData();
        System.out.println("------------------------------修改个人资料-------------------------------");
        for (int i = 0; i < 1;) {
            System.out.println("1.修改密码\n2.修改其他");
            String alter = gd.getData();
            if (alter.equals("1")){
                for (int j = 0; j < 1;) {
                    System.out.println("请输入旧密码：");
                    String oldPass = gd.getData();
                    if (oldPass.equals(buyer.getBuyer_Pass())){
                        System.out.println("请输入新密码：");
                        String newPass1 = gd.getData();
                        System.out.println("请再输入一次：");
                        String newPass2 = gd.getData();
                        if (newPass1.equals(newPass2)) {
                            boolean cg = byDAO.doUpdate("update Buyer set buyer_Pass = ? where buyer_ID = ?",newPass1,buyer.getBuyer_ID());
                            if (cg){
                                System.out.println("密码修改成功，请重新登陆");
                                try {
                                    Thread.sleep(1000);
                                    new Login().login();
                                    i++;
                                    j = i;
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }else {
                                System.out.println("修改密码出问题了");
                            }
                        }
                    }else {
                        System.out.println("密码不正确");
                    }
                }
            }else if (alter.equals("2")){
                String phone = null;
                String Email =null;
                for (int j = 0; j < 1; ) {
                    System.out.println("请输入电话：");
                    phone = gd.getData();
                    if (phone.matches("1[3-8][0-9]{9}")) {
                        j++;
                    }else {
                        System.out.println("请输入正确的手机号");
                    }
                }
                for (int j = 0; j <1 ;) {
                    System.out.println("请输入Email:");
                    Email = gd.getData();
                    String regex = "^[\\w\\d_]+@((163)|(139)|(126)|(21cn)|(qq)|(sohu)|(yeah)|(gmail)|(hotmail)|(tom))(\\.((com)|(net)|(cn)))+";
                    if (Email.matches(regex)) {
                        j++;
                    }else {
                        System.out.println("请输入正确的Email");
                    }
                }
                System.out.println(buyer.getBuyer_ID());
                boolean cg = byDAO.doUpdate("update Buyer set buyer_Phone = ?,buyer_Email = ? where buyer_ID = ?",phone,Email,buyer.getBuyer_ID());
                if (cg) {
                    System.out.println("用户资料修改成功！");
                    i++;
                    new BuyerPage().buyerCenter(buyer);
                }
            }else{
                System.out.println("输入有问题啊，同志！");
            }
        }
    }
}
