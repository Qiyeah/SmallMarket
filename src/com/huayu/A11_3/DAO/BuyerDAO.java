package com.huayu.A11_3.DAO;

import com.huayu.A11_3.Model.*;
import com.huayu.A11_3.Util.RandID;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Qiyeah on 2015/10/16.
 */
public class BuyerDAO extends BaseDAO {
    private Connection conn = null;
    private PreparedStatement prestat = null;
    private ResultSet rs = null;


    public ArrayList<Goods> queryShoppingList(String buy_ID){
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
    public Buyer queryBuyer(String buyer_ID){
        rs = doQuery("select * from Buyer where buyer_ID = ?",buyer_ID);
        try {
            Buyer buyer = new Buyer();
            while (rs.next()) {
                buyer.setBuyer_ID(rs.getString("buyer_ID"));
                buyer.setBuyer_Name(rs.getString("buyer_Name"));
                buyer.setBuyer_Phone(rs.getString("buyer_Phone"));
                buyer.setBuyer_Money(rs.getDouble("buyer_Money"));
                buyer.setBuyer_Email(rs.getString("buyer_Email"));
            }
            return buyer;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<BuyInfo> getBuyerInfo(String buy_ID){
        rs = doQuery("select * from BuyInfo where buy_ID = ?" ,buy_ID);
        ArrayList<BuyInfo> orderList = new ArrayList<>();
        BuyInfo buyInfo = null;
        try {
            while (rs.next()){
                buyInfo = new BuyInfo();
                buyInfo.setBuy_ID(rs.getString("buy_ID"));
                buyInfo.setBuyi_Count(rs.getInt("buyi_Count"));
                buyInfo.setGd_ID(rs.getString("gd_ID"));
                buyInfo.setBuyi_ID(rs.getString("buyi_ID"));
                orderList.add(buyInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }
    public ArrayList<Buy> queryShopping(String buyer_ID){
        ArrayList<Buy> gtList = new ArrayList<Buy>();
        rs = doQuery("select * from Buy where buyer_ID = ? and buy_State = 0",buyer_ID);
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
    public Buyer checkBuyerLogin(String buyer, String pass) {
        conn = getConn();
        rs = doQuery("select * from Buyer where buyer_Name = ? and buyer_Pass = ?", buyer, pass);
        try {
            if (rs.next()){
                return new Buyer(rs.getString("buyer_ID"),rs.getString("buyer_Name"),rs.getString("buyer_Pass"),
                        rs.getDouble("buyer_Money"),rs.getInt("buyer_State"),rs.getString("buyer_Phone"),
                        rs.getString("buyer_Email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
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
    public boolean isExist(String buyerName){
        rs = doQuery("select * from Buyer where buyer_Name = ?",buyerName);
        try {
            if (rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean registerBuyer(String ID,String name,String pass){
        return doUpdate("insert into Buyer(buyer_ID,buyer_Name,buyer_Pass) values(?,?,?)",ID,name,pass);
    }
    public boolean addCharge(String buyer_ID,double money){
        return doUpdate("insert into ChargeLog(cl_ID,cl_Money,buyer_ID) values(?,?,?)",new RandID().getID(RandID.ChargeLogID),money,buyer_ID);
    }
    public boolean minusBuyerMoney(String buyer_ID,double money){
        return doUpdate("update Buyer set buyer_Money = buyer_Money - ? where buyer_ID = ?",money,buyer_ID);
    }
    public boolean plusBuyerMoney(String buyer_ID,double money){
        return doUpdate("update Buyer set buyer_Money = buyer_Money + ? where buyer_ID = ?",money,buyer_ID);
    }
    public boolean changeChargeState(int cl_State,String buyer_ID){
        return doUpdate("update ChargeLog set cl_State = ? where buyer_ID = ?",cl_State,buyer_ID);
    }
    public boolean changeBuyState(String buy_ID){
        return doUpdate("update Buy set buy_State = 1 where buy_ID = ?",buy_ID);
    }
    public boolean payGoods(String buy_ID,String buyer_ID,double money){
        String seller_ID = "srid2015101611032157884121884352";
        boolean order = doUpdate("update Buy set buy_State = 1 where buy_ID = ? and buyer_ID = ?",buy_ID,buyer_ID);
        boolean pay = doUpdate("update Buyer set buyer_Money = buyer_Money - ? where buyer_ID = ?",money,buyer_ID);
        boolean plus = doUpdate("update Seller set seller_Money = seller_Money + ? where seller_ID = ?",money,seller_ID);
        if (order&&pay&&plus){
            return true;
        }
        return false;
    }

}








/*public Buyer getBuyer(String buyerName){
        rs = doQuery("select * from Buyer where buyer_Name = ?",buyerName);
        try {
            if (rs.next()){
                return new Buyer(rs.getString("buyer_ID"),rs.getString("buyer_Name"),rs.getString("buyer_Pass"),
                        rs.getDouble("buyer_Money"),rs.getInt("buyer_State"),rs.getString("buyer_Phone"),
                        rs.getString("buyer_Email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }*/
