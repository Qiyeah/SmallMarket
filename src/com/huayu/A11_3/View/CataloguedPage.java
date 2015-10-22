package com.huayu.A11_3.View;

import com.huayu.A11_3.DAO.GoodsDAO;
import com.huayu.A11_3.Model.GoodsType;
import com.huayu.A11_3.Model.Seller;
import com.huayu.A11_3.Util.GetData;
import com.huayu.A11_3.Util.ListGoods;
import com.huayu.A11_3.Util.Next;
import com.huayu.A11_3.Util.RandID;

import java.util.ArrayList;

/**
 * Created by Qiyeah on 2015/10/17.
 */
public class CataloguedPage {
    GoodsDAO gdDAO = new GoodsDAO();
    GetData gd = new GetData();
    public void classfiedGoods(Seller seller){
        ArrayList<GoodsType> gtList = gdDAO.querySuperType();
        System.out.println("-------------------------------��Ʒ�ϼ�----------------------------------");
        System.out.println("-------------------------------------------------------------------------");
        for (int i = 0; i < 1;) {
            System.out.println("1.������Ʒ����� \n2.������ƷС���");
            String dec = gd.getData();
            if ("1".equals(dec)){
                i++;
                for (int j = 0; j < 1;) {
                    System.out.println("��������Ҫ��ӵ���Ʒ��������ƣ�");
                    String gt_Name = gd.getData();
                    if (!gdDAO.isExist(gt_Name)){
                        String gt_ID = new RandID().getID(RandID.GoodsTypeID);
                        boolean flag = gdDAO.addGoodsType(gt_ID,gt_Name,null);
                        if (flag) {
                            System.out.println("������Ʒ���ͳɹ�");
                            j = new Next().nextStep(gd,j);
                        }
                    }else {
                        System.out.println("����Ʒ�������ƻ����Ѿ�����");
                    }
                    new SellerPage().sellerCenter(seller);
                }
            }else if ("2".equals(dec)){
                i++;
                for (int j = 0; j < 1;) {
                    new ListGoods().printType(gtList);
                    System.out.println("��ѡ����Ҫ��ӵ���ƷС���");
                    String gt_RID = gtList.get(Integer.parseInt(gd.getData())-1).getGt_ID();
                    System.out.println("��������Ҫ��ӵ���ƷС������ƣ�");
                    String gt_Name = gd.getData();
                    if (null != gt_RID) {
                        if (!gdDAO.isExist(gt_Name,gt_RID)) {

                            String gt_ID = new RandID().getID(RandID.GoodsTypeID);
                            boolean flag = gdDAO.addGoodsType(gt_ID, gt_Name, gt_RID);
                            if (flag) {
                                System.out.println("������Ʒ���ͳɹ�");
                                j = new Next().nextStep(gd, j);
                            }
                        } else {
                            System.out.println("����Ʒ�����Ѿ�����");
                            j = new Next().nextStep(gd,j);
                        }
                    }else{
                        System.out.println("����Ʒ���ͱ�Ų�����");
                        j = new Next().nextStep(gd, j);
                    }
                }
                new SellerPage().sellerCenter(seller);
            }
        }
    }
}
