package com.huayu.A11_3.View;

import com.huayu.A11_3.DAO.GoodsDAO;
import com.huayu.A11_3.Model.Buyer;
import com.huayu.A11_3.Model.Goods;
import com.huayu.A11_3.Model.GoodsType;
import com.huayu.A11_3.Util.GetData;
import com.huayu.A11_3.Util.GetGoodsCount;
import com.huayu.A11_3.Util.ListGoods;
import com.huayu.A11_3.Util.Next;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Qiyeah on 2015/10/17.
 */
public class ShoppingCart {//购物车
    GetData gd = new GetData();
    GoodsDAO gdDAO = new GoodsDAO();
    public void shoppingList(Buyer buyer){
        System.out.println("------------------------------- 购物车 ----------------------------------");
        System.out.println("-------------------------------------------------------------------------");
        ArrayList<GoodsType> gtList = gdDAO.querySuperType();
        ArrayList<Goods> spCart = new ArrayList<Goods>();
        for (int i = 0; i < 1;) {
            new ListGoods().printType(gtList);
            System.out.println("选择你要预览商品的大类型：");
            String bigType = gd.getData();
            if (bigType.matches("[0-9]+")&&(Integer.parseInt(bigType) - 1)<gtList.size()) {
                String gt_RID = gtList.get(Integer.parseInt(bigType) - 1).getGt_ID();
                ArrayList<GoodsType> slList = gdDAO.querySmallType(gt_RID);
                if (slList.size()!=0) {
                    new ListGoods().printType(slList);
                    System.out.println("选择要预览的商品小类型：");
                    String smallType = gd.getData();
                    if (smallType.matches("[0-9]+")&&(Integer.parseInt(smallType) - 1)<slList.size()) {
                        String gt_ID = slList.get(Integer.parseInt(smallType) - 1).getGt_ID();
                        ArrayList<Goods> gdList = gdDAO.queryGoods(gt_ID, 1);
                        if (gdList.size() != 0) {
                            new ListGoods().printGoods(gdList);
                            System.out.println("选择要预购买的商品：");
                            String chose = gd.getData();
                            if (chose.matches("[0-9]+")&&(Integer.parseInt(chose) - 1)<gdList.size()) {
                                int index = Integer.parseInt(chose) - 1;
                                Goods goods = gdList.get(index);
                                gdDAO.alterGoodsCount(goods.getGd_ID(),1);
                                spCart.add(goods);
                                i = new Next().nextStep(gd, i);
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
        String buy_ID = gdDAO.addBuy(buyer.getBuyer_ID(), 0);//增加订单，默认未支付状态，返回订单号
        HashMap<String,Integer> list = new GetGoodsCount().getCount(spCart);
        Set<String> keySet = list.keySet();
        Iterator<String> it = keySet.iterator();
        while (it.hasNext()){
            String gd_ID = it.next();
            int count = list.get(gd_ID);
            gdDAO.addShoppingList(buy_ID, gd_ID, count);
        }
        System.out.println("购物清单添加成功,返回用户中心");
        new BuyerPage().buyerCenter(buyer);

    }
}
