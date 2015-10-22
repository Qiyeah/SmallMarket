package com.huayu.A11_3.View;

import com.huayu.A11_3.DAO.BuyerDAO;
import com.huayu.A11_3.DAO.GoodsDAO;
import com.huayu.A11_3.DAO.SellerDAO;
import com.huayu.A11_3.Model.Buy;
import com.huayu.A11_3.Model.BuyInfo;
import com.huayu.A11_3.Model.Buyer;
import com.huayu.A11_3.Model.Goods;
import com.huayu.A11_3.Util.GetData;
import com.huayu.A11_3.Util.ListGoods;
import com.huayu.A11_3.Util.Next;

import java.util.ArrayList;

/**
 * Created by Qiyeah on 2015/10/17.
 */
public class Pay {
    GetData gd = new GetData();
    GoodsDAO gdDAO = new GoodsDAO();
    BuyerDAO brDAO = new BuyerDAO();
    SellerDAO srDAO = new SellerDAO();

    public void pay(Buyer buyer) {
        System.out.println("-------------------------------支付帐单----------------------------------");
        System.out.println("购物车商品列表：");
        //System.out.println("-------------------------------------------------------------------------");
        /*
        1.获取订单
        2.获取订单下的商品

         */
        for (int i = 0; i < 1; ) {

            ArrayList<Buy> order = brDAO.queryShopping(buyer.getBuyer_ID());

            if (order.size() != 0) {
                for (int j = 0; j < order.size(); j++) {
                    System.out.println("第 " + (i + 1) + " 个订单：");
                    ArrayList<Goods> subList = brDAO.queryShoppingList(order.get(i).getBuy_ID());
                    new ListGoods().printGoods(subList);
                    i++;
                }
                System.out.println("你要支付哪一个订单：");
                String sel = gd.getData();
                int index = Integer.parseInt(sel) - 1;
                System.out.println(index);
                if (sel.matches("[0-9]+") && index <= order.size()) {
                    Buy buy = order.get(index);
                    System.out.println("支付订单商品列表：");
                    //ArrayList<Goods> payList = brDAO.queryShoppingList(buy.getBuy_ID());
                    ArrayList<BuyInfo> spList = brDAO.getBuyerInfo(buy.getBuy_ID());
                    double money = 0.0;

                    for (int j = 0; j < spList.size(); j++) {
                        Goods g = gdDAO.queryGoods(spList.get(j).getGd_ID());
                        double price = g.getGd_Price();
                        int count = spList.get(j).getBuyi_Count();
                        price = count * price;
                        money += price;
                        System.out.println("第 " + (j + 1) + " 个商品: " + g.getGd_Name() + "\t" + g.getGd_Price()
                                + "\t" + count + "\t" + price);
                    }
                    if (buyer.getBuyer_Money() >= money) {
                        System.out.println(buy.getBuy_ID() + ":::" + buyer.getBuyer_ID() + ":::" + money);
                        boolean cg = brDAO.payGoods(buy.getBuy_ID(), buyer.getBuyer_ID(), money);
                        boolean bcg = brDAO.changeBuyState(buy.getBuy_ID());
                        if (cg && bcg) {
                            System.out.println("支付成功");
                            i = new Next().nextStep(gd, i);
                        }
                    } else {
                        System.out.println("支付不成功，帐户余额不足");
                    }
                /*for (int j = 0; j < payList.size(); j++) {
                    Goods g = payList.get(j );
                    money += g.getGd_Count()*g.getGd_Price();
                    System.out.println((i + 1) + "." + g.getGd_Name() + "\t" + g.getGd_Price() + "\t" + bifo.getBuyi_Count() + "\t" + g.getGd_Count() * g.getGd_Price());
                }*/
                    //boolean flag = brDAO.payGoods(buy.getBuy_ID(),buyer.getBuyer_ID(),money);
               /* if (flag){
                    System.out.println("支付成功");
                    i = new Next().nextStep(gd,i);
                }*/
                }
            }else {
                System.out.println("此帐户下没有订单，即将返回个人中心");
                i++;
            }
        }
        new BuyerPage().buyerCenter(buyer);
    }
}








        /*ArrayList<Buy> shoppingList = brDAO.queryShopping(buyer.getBuyer_ID());
        ArrayList<Goods> spCart = null;
        double momey = 0.0;







        for (int i = 0; i < shoppingList.size(); i++) {
            spCart = brDAO.queryShoppingList(shoppingList.get(i).getBuy_ID());
        }
        new ListGoods().printGoods(spCart);
        if (0!=spCart.size()) {
            System.out.println("全部支付：Y / N");
            for (int i = 0; i < 1; ) {
                String dec = gd.getData();
                if (dec.matches("[Yy]")) {
                *//*
                开始支付购物车的所有商品
                1.扣除买家帐户里的钱
                2.把购物详情里面的相关记录的状态改为已支付
                3.把商品的总金额加到卖家帐户
                 *//*
                    for (int j = 0; j < spCart.size(); j++) {
                        momey += spCart.get(j).getGd_Price();
                    }
                    for (int k = 0; k < shoppingList.size(); k++) {
                        brDAO.changeBuyerInfoState(shoppingList.get(k).getBuy_ID(), buyer.getBuyer_ID());
                    }
                    boolean pay = brDAO.minusMoney(buyer.getBuyer_ID(), momey);
                    boolean rec = srDAO.plusMoney(momey);
                    if (pay && rec) {
                        i++;
                        System.out.println("付款成功,返回买家个人中心");
                        new BuyerPage().buyerCenter(buyer);
                    }
                } else if (dec.matches("[Nn]")) {
                *//*
                开始支付购物车的商品
                1.选择要支付的商品
                2.统计金额
                3.扣除买家帐户里的钱
                4.把购物详情里面的相关记录的状态改为已支付
                5.把商品的总金额加到卖家帐户
                 *//*

                    ArrayList<Buy> subList = new ArrayList<Buy>();
                    for (int j = 0; j < 1; ) {
                        System.out.println("选择要支付的订单:");
                        int gdNum = Integer.parseInt(gd.getData()) - 1;
                        if (gdNum <= spCart.size()) {
                            Buy order = shoppingList.get(gdNum);
                            if (brDAO.changeBuyerInfoState(order.getBuy_ID(), buyer.getBuyer_ID())) {
                                subList.add(order);
                                j = new Next().nextStep(gd, j);
                            }
                        } else {
                            System.out.println("输入超出范围，请重新输入");
                        }
                    }
                    for (int k = 0; k < subList.size(); k++) {
                        spCart = brDAO.queryShoppingList(subList.get(k).getBuy_ID());
                        for (int j = 0; j < spCart.size(); j++) {
                            momey += spCart.get(j).getGd_Price();
                        }
                    }
                    boolean pay = brDAO.minusMoney(buyer.getBuyer_ID(), momey);
                    boolean rec = srDAO.plusMoney(momey);
                    if (pay && rec) {
                        i++;
                        System.out.println("付款成功,返回买家个人中心");
                        new BuyerPage().buyerCenter(buyer);
                    }
                }
            }
        }else {
            System.out.println("未查找到购买记录，即将返回个人中心");
            new BuyerPage().buyerCenter(buyer);
        }*/
