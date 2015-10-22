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
public class Shelves {
    GetData gd = new GetData();
    GoodsDAO gdDAO = new GoodsDAO();
    public void goodsShelves(Seller seller){
        System.out.println("-------------------------------��Ʒ�ϼ�----------------------------------");
        System.out.println("-------------------------------------------------------------------------");
        ArrayList<GoodsType> bigType = gdDAO.querySuperType();
        for (int i = 0; i < 1; ) {
            new ListGoods().printType(bigType);
            System.out.println("ѡ����Ҫ�ϼ���Ʒ�Ĵ����ͣ�");
            String gt_RID = bigType.get(Integer.parseInt(gd.getData())-1).getGt_ID();

            ArrayList<GoodsType> typeList = gdDAO.querySmallType(gt_RID);
            new ListGoods().printType(typeList);
            System.out.println("ѡ��Ҫ�ϼܵ���ƷС���ͣ�");
            String gt_ID = typeList.get(Integer.parseInt(gd.getData())-1).getGt_ID();

            System.out.println("������Ʒ���ƣ�");
            String gd_Name = gd.getData();
            System.out.println("������Ʒ�۸�");
            double gd_Price = Double.parseDouble(gd.getData());
            System.out.println("������Ʒ������");
            int gd_Count = Integer.parseInt(gd.getData());
            //------------------------------------------------
            String gd_ID = new RandID().getID(RandID.GoodsID);
            boolean flag = gdDAO.addGoods(gd_ID,gd_Name,gd_Price,gd_Count,gt_ID);
            if (flag){
                System.out.println("��Ʒ��ӳɹ�");
                i = new Next().nextStep(gd,i);
            }
        }
        new SellerPage().sellerCenter(seller);
    }
}
