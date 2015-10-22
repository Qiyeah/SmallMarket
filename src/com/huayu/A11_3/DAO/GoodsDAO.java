package com.huayu.A11_3.DAO;

import com.huayu.A11_3.Model.Goods;
import com.huayu.A11_3.Model.GoodsType;
import com.huayu.A11_3.Util.RandID;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Qiyeah on 2015/10/17.
 */
public class GoodsDAO extends BaseDAO{
    private Connection conn = null;
    private PreparedStatement prestat = null;
    private ResultSet rs = null;
    public boolean alterGoodsCount(String gd_ID,int count){
        return doUpdate("update Goods set gd_Count = gd_Count - ? where gd_ID = ?",count,gd_ID);
    }
    public boolean unsehelvesGoods(String gd_ID){
        return doUpdate("update Goods set gd_State = 0 where gd_ID = ?",gd_ID);
    }
    public Goods queryGoods(String gd_ID){
        rs = doQuery("select * from Goods where gd_ID = ?",gd_ID);
        try {
            while (rs.next()){
                Goods goods = new Goods();
                goods.setGt_ID(rs.getString("gt_ID"));
                goods.setGd_Name(rs.getString("gd_Name"));
                goods.setGd_Price(rs.getDouble("gd_Price"));
                goods.setGd_Count(rs.getInt("gd_Count"));
                goods.setGd_State(rs.getInt("gd_State"));
                goods.setGd_ID(rs.getString("gd_ID"));
                return goods;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Goods> queryGoods(String gt_ID,int gd_State){
        ArrayList<Goods> gtList = new ArrayList<Goods>();
        rs = doQuery("select * from Goods where gt_ID = ? and gd_State = ? and gd_Count > 0",gt_ID,gd_State);
        try {
            while (rs.next()){
                Goods goods = new Goods();
                goods.setGt_ID(rs.getString("gt_ID"));
                goods.setGd_Name(rs.getString("gd_Name"));
                goods.setGd_Price(rs.getDouble("gd_Price"));
                goods.setGd_Count(rs.getInt("gd_Count"));
                goods.setGd_State(rs.getInt("gd_State"));
                goods.setGd_ID(rs.getString("gd_ID"));
                gtList.add(goods);
            }
            return gtList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<GoodsType> querySuperType(){
        ArrayList<GoodsType> gtList = new ArrayList<GoodsType>();
        rs = doQuery("select * from GoodsType where gt_RID = '1000'");
        try {
            while (rs.next()){
                GoodsType goodsType = new GoodsType();
                goodsType.setGt_ID(rs.getString("gt_ID"));
                goodsType.setGt_Name(rs.getString("gt_Name"));
                goodsType.setGt_RID(rs.getString("gt_RID"));
                gtList.add(goodsType);
            }
            return gtList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<GoodsType> querySmallType(String gt_RID){
        ArrayList<GoodsType> gtList = new ArrayList<GoodsType>();
        rs = doQuery("select * from GoodsType where gt_RID = ?",gt_RID);
        try {
            while (rs.next()){
                if (rs.getString("gt_RID").matches("gtid.+")) {
                    GoodsType goodsType = new GoodsType();
                    goodsType.setGt_ID(rs.getString("gt_ID"));
                    goodsType.setGt_Name(rs.getString("gt_Name"));
                    goodsType.setGt_RID(rs.getString("gt_RID"));
                    gtList.add(goodsType);
                }
            }
            return gtList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean addGoodsType(String gt_ID,String gt_Name,String gt_RID){
        return doUpdate("insert into GoodsType(gt_ID,gt_Name,gt_RID) values(?,?,?)",gt_ID,gt_Name,gt_RID);
    }
    public String addBuy(String buyer_ID,int buy_State){//Ôö¼Ó¶©µ¥
        String buy_ID = new RandID().getID(RandID.BuyID);
        boolean flag = doUpdate("insert into Buy(buy_ID,buyer_ID,buy_State) values(?,?,?)",buy_ID,buyer_ID,buy_State);
        if (flag){
            return buy_ID;
        }
        return null;
    }
    public boolean addShoppingList(String buy_ID,String gd_ID,int buyi_Count){
        return doUpdate("insert into BuyInfo values(?,?,?,?)",new RandID().getID(RandID.BuyInfoID),buy_ID,gd_ID,buyi_Count);
    }
    public boolean addGoods(String gd_ID,String gd_Name,Double gd_Price,int gd_Count,String gt_ID){
        return doUpdate("insert into Goods(gd_ID,gd_Name,gd_Price,gd_Count,gt_ID) values(?,?,?,?,?)",gd_ID,gd_Name,gd_Price,gd_Count,gt_ID);
    }
    public boolean isExist(String gt_Name,String gt_RID){
        return doUpdate("select * from GoodsType where gt_Name = ? and gt_RID = ? ",gt_Name,gt_RID);
    }
    public boolean isExist(String gt_Name){
        return doUpdate("select * from GoodsType where gt_Name = ? and gt_RID = ? ",gt_Name);
    }
    public String getGT_ID(String gt_RID){
        rs = doQuery("select gt_ID from GoodsType where gt_RID = ?",gt_RID);
        try {
            if (rs.next()){
                return rs.getString("gt_ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
