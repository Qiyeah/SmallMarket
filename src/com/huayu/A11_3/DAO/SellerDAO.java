package com.huayu.A11_3.DAO;

import com.huayu.A11_3.Model.Buy;
import com.huayu.A11_3.Model.ChargeLog;
import com.huayu.A11_3.Model.Goods;
import com.huayu.A11_3.Model.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Qiyeah on 2015/10/16.
 */
public class SellerDAO extends BaseDAO {
    private Connection conn = null;
    private PreparedStatement prestat = null;
    private ResultSet rs = null;
    public Seller checkSellerLogin(String seller, String pass) {
        conn = getConn();
        rs = doQuery("select * from Seller where seller_Name = ? and seller_Pass = ?", seller, pass);
        try {
            if (rs.next()){
                return new Seller(rs.getString("seller_ID"),rs.getString("seller_Name"),rs.getString("seller_Pass"),
                        rs.getDouble("seller_Money"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Goods> querySellList(String buy_ID){
        ArrayList<Goods> spList = new ArrayList<>();
        rs = doQuery("select * from Goods where gd_ID in(select gd_ID from BuyInfo where buy_ID = ?)",buy_ID);
        try {
            while (rs.next()){
                Goods goods = new Goods();
                goods.setGt_ID(rs.getString("gt_ID"));
                goods.setGd_Name(rs.getString("gd_Name"));
                goods.setGd_Price(rs.getDouble("gd_Price"));
                goods.setGd_Count(rs.getInt("gd_Count"));
                goods.setGd_State(rs.getInt("gd_State"));
                goods.setGd_ID(rs.getString("gd_ID"));
                spList.add(goods);
            }
            return spList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Buy> querySellOrder(){
        ArrayList<Buy> gtList = new ArrayList<Buy>();
        rs = doQuery("select * from Buy where buy_State = 1");
        try {
            while (rs.next()){
                Buy buy = new Buy();
                buy.setBuy_ID(rs.getString("buy_ID"));
                buy.setBuyer_ID(rs.getString("buyer_ID"));
                buy.setBuy_Date(rs.getDate("buy_Date"));
                buy.setBuy_State(rs.getInt("buy_State"));
                gtList.add(buy);
            }
            return gtList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean plusMoney(double money){
        String seller_ID = "srid2015101611032157884121884352";
        return doUpdate("update Seller set seller_Money = seller_Money + ? where seller_ID = ?",money,seller_ID);
    }
    public ArrayList<ChargeLog> listChargeLog(int cl_State){
        rs = doQuery("select * from ChargeLog where cl_State = ?",cl_State);
        ArrayList<ChargeLog> list =new ArrayList<>();
        try {
            while(rs.next()){
                ChargeLog cl = new ChargeLog(rs.getString("cl_ID"),rs.getDouble("cl_Money"),rs.getInt("cl_State"),rs.getString("buyer_ID"),rs.getDate("cl_Date"));
                list.add(cl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
