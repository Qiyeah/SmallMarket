package com.huayu.A11_3.View;

import com.huayu.A11_3.DAO.GoodsDAO;
import com.huayu.A11_3.Model.Goods;
import com.huayu.A11_3.Model.GoodsType;
import com.huayu.A11_3.Model.Seller;
import com.huayu.A11_3.Util.*;

import java.util.ArrayList;

/**
 * Created by Qiyeah on 2015/10/21.
 */
public class UnshelvesPage {
    GetData gd = new GetData();
    GoodsDAO gdDAO = new GoodsDAO();
    public void unshelvesGoods(Seller seller){
        ArrayList<GoodsType> gtList = gdDAO.querySuperType();
        ArrayList<Goods> spCart = new ArrayList<Goods>();
        for (int i = 0; i < 1;) {
            new ListGoods().printType(gtList);
            System.out.println("选择你要下架商品的大类型：");
            String bigType = gd.getData();
            if (bigType.matches("[0-9]+")&&(Integer.parseInt(bigType) - 1)<gtList.size()) {
                String gt_RID = gtList.get(Integer.parseInt(bigType) - 1).getGt_ID();
                ArrayList<GoodsType> slList = gdDAO.querySmallType(gt_RID);
                if (slList.size()!=0) {
                    new ListGoods().printType(slList);
                    System.out.println("选择要下架的商品小类型：");
                    String smallType = gd.getData();
                    if (smallType.matches("[0-9]+")&&(Integer.parseInt(smallType) - 1)<slList.size()) {
                        String gt_ID = slList.get(Integer.parseInt(smallType) - 1).getGt_ID();
                        ArrayList<Goods> gdList = gdDAO.queryGoods(gt_ID, 1);
                        if (gdList.size() != 0) {
                            new ListGoods().printGoods(gdList);
                            System.out.println("选择要下架的商品：");
                            String chose = gd.getData();
                            if (chose.matches("[0-9]+")&&(Integer.parseInt(chose) - 1)<gdList.size()) {
                                int index = Integer.parseInt(chose) - 1;
                                Goods goods = gdList.get(index);
                                //spCart.add(goods);
                                boolean uf = gdDAO.unsehelvesGoods(goods.getGd_ID());
                                if (uf){
                                    i = new Next().nextStep(gd, i);
                                }else{
                                    System.out.println("下架不成功！");
                                }
                            } else {
                                System.out.println("请输入数字，并且确定输入是否存在");
                            }
                        } else {
                            System.out.println("该类商品未上架，请购买其他商品");
                        }
                    } else {
                        System.out.println("请输入数字，并且确定输入是否存在");
                    }
                }else {
                    System.out.println("该类商品未上架，请购买其他商品");
                }
            }else {
                System.out.println("请输入数字，并且确定输入是否存在");
            }
        }
        new SellerPage().sellerCenter(seller);
    }
}
