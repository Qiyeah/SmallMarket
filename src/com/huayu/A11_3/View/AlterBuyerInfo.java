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
        System.out.println("------------------------------�޸ĸ�������-------------------------------");
        for (int i = 0; i < 1;) {
            System.out.println("1.�޸�����\n2.�޸�����");
            String alter = gd.getData();
            if (alter.equals("1")){
                for (int j = 0; j < 1;) {
                    System.out.println("����������룺");
                    String oldPass = gd.getData();
                    if (oldPass.equals(buyer.getBuyer_Pass())){
                        System.out.println("�����������룺");
                        String newPass1 = gd.getData();
                        System.out.println("��������һ�Σ�");
                        String newPass2 = gd.getData();
                        if (newPass1.equals(newPass2)) {
                            boolean cg = byDAO.doUpdate("update Buyer set buyer_Pass = ? where buyer_ID = ?",newPass1,buyer.getBuyer_ID());
                            if (cg){
                                System.out.println("�����޸ĳɹ��������µ�½");
                                try {
                                    Thread.sleep(1000);
                                    new Login().login();
                                    i++;
                                    j = i;
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }else {
                                System.out.println("�޸������������");
                            }
                        }
                    }else {
                        System.out.println("���벻��ȷ");
                    }
                }
            }else if (alter.equals("2")){
                String phone = null;
                String Email =null;
                for (int j = 0; j < 1; ) {
                    System.out.println("������绰��");
                    phone = gd.getData();
                    if (phone.matches("1[3-8][0-9]{9}")) {
                        j++;
                    }else {
                        System.out.println("��������ȷ���ֻ���");
                    }
                }
                for (int j = 0; j <1 ;) {
                    System.out.println("������Email:");
                    Email = gd.getData();
                    String regex = "^[\\w\\d_]+@((163)|(139)|(126)|(21cn)|(qq)|(sohu)|(yeah)|(gmail)|(hotmail)|(tom))(\\.((com)|(net)|(cn)))+";
                    if (Email.matches(regex)) {
                        j++;
                    }else {
                        System.out.println("��������ȷ��Email");
                    }
                }
                System.out.println(buyer.getBuyer_ID());
                boolean cg = byDAO.doUpdate("update Buyer set buyer_Phone = ?,buyer_Email = ? where buyer_ID = ?",phone,Email,buyer.getBuyer_ID());
                if (cg) {
                    System.out.println("�û������޸ĳɹ���");
                    i++;
                    new BuyerPage().buyerCenter(buyer);
                }
            }else{
                System.out.println("���������Ⱑ��ͬ־��");
            }
        }
    }
}
