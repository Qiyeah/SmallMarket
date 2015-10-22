package com.huayu.A11_3.View;

import com.huayu.A11_3.DAO.BuyerDAO;
import com.huayu.A11_3.DAO.GoodsDAO;
import com.huayu.A11_3.DAO.SellerDAO;
import com.huayu.A11_3.Model.Buy;
import com.huayu.A11_3.Model.ChargeLog;
import com.huayu.A11_3.Model.Goods;
import com.huayu.A11_3.Model.Seller;
import com.huayu.A11_3.Util.GetData;
import com.huayu.A11_3.Util.GetGoodsCount;
import com.huayu.A11_3.Util.Next;

import java.util.*;

/**
 * Created by Qiyeah on 2015/10/21.
 */
public class QuerySellerMoney {
    public void querySellerMoney(Seller seller){
        for (int j = 0; j < 1; ) {
            SellerDAO slDAO = new SellerDAO();
            GoodsDAO gdDAO = new GoodsDAO();
            GetData gd = new GetData();
            ArrayList<Buy> sellOrderList = slDAO.querySellOrder();
            if (sellOrderList.size()!=0) {
                ArrayList<Goods> sellGoodsList = new ArrayList<>();
                for (int i = 0; i < sellOrderList.size(); i++) {
                    String buy_ID = sellOrderList.get(i).getBuy_ID();
                    ArrayList<Goods> subList = slDAO.querySellList(buy_ID);
                    for (Goods goods : subList) {
                        sellGoodsList.add(goods);
                    }
                }
                System.out.println("-----------------------------销售记录------------------------------------");
                HashMap<String, Integer> list = new GetGoodsCount().getCount(sellGoodsList);
                Set<Map.Entry<String, Integer>> entrySet = list.entrySet();
                Iterator<Map.Entry<String, Integer>> it = entrySet.iterator();
                double money = 0.0;
                double sum = 0.0;
                int index = 0;
                while (it.hasNext()) {
                    index++;
                    Map.Entry<String, Integer> entry = it.next();
                    String gd_ID = entry.getKey();
                    Goods g = gdDAO.queryGoods(gd_ID);
                    Integer buyi_Count = entry.getValue();
                    money = g.getGd_Price() * buyi_Count;
                    sum += money;
                    System.out.println("第 " + index + " 个销售记录: " + g.getGd_Name() + "\t" + g.getGd_Price() + "\t" + buyi_Count + "\t" + money);
                }
                System.out.println("-----------------------------充值记录------------------------------------");
                ArrayList<ChargeLog> chargeList = slDAO.listChargeLog(1);
                BuyerDAO brDAO = new BuyerDAO();
                for (int i = 0; i < chargeList.size(); i++) {
                    ChargeLog cl = chargeList.get(i);
                    String buyer_Name = brDAO.queryBuyer(cl.getBuyer_ID()).getBuyer_Name();
                    sum += cl.getCl_Money();
                    System.out.println("第 " + (i+1) + " 个充值记录: " +buyer_Name+"\t"+cl.getCl_Money());
                }
                System.out.println("商家 "+seller.getSeller_Name()+"共盈利："+sum+" 元");
            }else {
                System.out.println("没有销售记录");
            }
            j = new Next().nextStep(gd,j);
        }
        new SellerPage().sellerCenter(seller);
    }
}
