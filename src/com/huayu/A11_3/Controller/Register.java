package com.huayu.A11_3.Controller;

import com.huayu.A11_3.DAO.BuyerDAO;
import com.huayu.A11_3.Util.GetData;
import com.huayu.A11_3.Util.RandID;

/**
 * Created by Qiyeah on 2015/10/16.
 */
public class Register {
    GetData gd = new GetData();
    BuyerDAO byDAO = new BuyerDAO();
    public boolean regBuyer(){
        for (int i = 0; i < 1;) {
            System.out.println("please enter user name:");
            String userName = gd.getData();
            if (!byDAO.isExist(userName)) {
                System.out.println("please enter password:");
                String userPass1 = gd.getData();
                System.out.println("please enter password:");
                String userPass2 = gd.getData();
                boolean flag = false;
                if (userPass1.equals(userPass2)){
                    flag = byDAO.registerBuyer(new RandID().getID(RandID.BuyerID),userName,userPass1);
                }
                if (flag) {
                    i++;
                    System.out.println("register successful! please logina later");
                    new Login().login();
                }else{
                    System.out.println("注册失败");
                }
            }else{
                System.out.println("该用户已存在，请重新注册");
            }
        }
        return false;
    }
}
