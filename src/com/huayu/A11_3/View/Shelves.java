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
        System.out.println("-------------------------------商品上架----------------------------------");
        System.out.println("-------------------------------------------------------------------------");
        ArrayList<GoodsType> bigType = gdDAO.querySuperType();
        for (int i = 0; i < 1; ) {
            new ListGoods().printType(bigType);
            System.out.println("选择你要上架商品的大类型：");
            String gt_RID = bigType.get(Integer.parseInt(gd.getData())-1).getGt_ID();

            ArrayList<GoodsType> typeList = gdDAO.querySmallType(gt_RID);
            new ListGoods().printType(typeList);
            System.out.println("选择要上架的商品小类型：");
            String gt_ID = typeList.get(Integer.parseInt(gd.getData())-1).getGt_ID();

            System.out.println("输入商品名称：");
            String gd_Name = gd.getData();
            System.out.println("输入商品价格：");
            double gd_Price = Double.parseDouble(gd.getData());
            System.out.println("输入商品数量：");
            int gd_Count = Integer.parseInt(gd.getData());
            //------------------------------------------------
            String gd_ID = new RandID().getID(RandID.GoodsID);
            boolean flag = gdDAO.addGoods(gd_ID,gd_Name,gd_Price,gd_Count,gt_ID);
            if (flag){
                System.out.println("商品添加成功");
                i = new Next().nextStep(gd,i);
            }
        }
        new SellerPage().sellerCenter(seller);
    }
}
