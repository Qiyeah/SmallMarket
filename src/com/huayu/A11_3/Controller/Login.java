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
            System.out.println("��ѡ���½��ʽ��\n1 . ���\n2 . ����");
            String dec = gd.getData();
            if ("1".equals(dec)){
                System.out.println("�����û�����");
                String name = gd.getData();
                System.out.println("�������룺");
                String pass = gd.getData();
                Buyer buyer = byDAO.checkBuyerLogin(name, pass);
                if (buyer!=null){
                    i++;
                    System.out.println("��½�ɹ���������ת����������...");
                    new BuyerPage().buyerCenter(buyer);
                }else {
                    System.out.println("Error:�û������������");
                }
            }else if("2".equals(dec)){
                System.out.println("�����û�����");
                String name = gd.getData();
                System.out.println("�������룺");
                String pass = gd.getData();
                Seller seller = byDAO.checkSellerLogin(name, pass);
                if (seller!=null){
                    i++;
                    System.out.println("��½�ɹ���������ת����������...");
                    new SellerPage().sellerCenter(seller);
                }else {
                    System.out.println("Error:�û������������");
                }
            }else {
                System.out.println("Error:û�д˵�½��ʽ���������ʾѡ��");
            }
        }
    }
}
