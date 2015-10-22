package com.huayu.A11_3.Test;

import com.huayu.A11_3.DAO.BuyerDAO;
import com.huayu.A11_3.DAO.SellerDAO;
import com.huayu.A11_3.Util.GetData;
import com.huayu.A11_3.Util.RandID;

/**
 * Created by Qiyeah on 2015/10/19.
 */
public class TestZZ {
    public static void main(String[] args) {
        /*String str = new RandID().getID(RandID.BuyerID);
        System.out.println(str);*/

        BuyerDAO brDAO = new BuyerDAO();
        brDAO.addCharge("brid2015101611032157884121884352",1000.0);
        /*GetData gd = new GetData();
        String regx = "([0-9a-zA-Z_]+)@([0-9]{1,3}\\.[a-z]{2,4})";
        String regx1 = "^([a-zA-Z0-9_]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        String regex2 = "^[\\w\\d_]+@((163)|(139)|(126)|(21cn)|(qq)|(sohu)|(yeah)|(gmail)|(hotmail)|(tom))(\\.((com)|(net)|(cn)))+";
        for (int i = 0; i <1 ; ) {
            System.out.println("请输入邮箱：");
            if (gd.getData().matches(regx1)){
                System.out.println("验证成功");
                i++;
            }

        }*/
    }
}
