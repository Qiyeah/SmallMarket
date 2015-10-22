package com.huayu.A11_3.Model;

/**
 * Created by Qiyeah on 2015/10/16.
 */
public class Goods {
    private String gd_ID;
    private String gd_Name;
    private double gd_Price;
    private int gd_Count;
    private int gd_State;
    private String gt_ID;

    public Goods() {
    }

    public Goods(String gd_ID, String gd_Name, double gd_Price, int gd_Count, int gd_State, String gt_ID) {
        this.setGd_ID(gd_ID);
        this.setGd_Name(gd_Name);
        this.setGd_Price(gd_Price);
        this.setGd_Count(gd_Count);
        this.setGd_State(gd_State);
        this.setGt_ID(gt_ID);
    }

    public String getGd_ID() {
        return gd_ID;
    }

    public void setGd_ID(String gd_ID) {
        this.gd_ID = gd_ID;
    }

    public String getGd_Name() {
        return gd_Name;
    }

    public void setGd_Name(String gd_Name) {
        this.gd_Name = gd_Name;
    }

    public double getGd_Price() {
        return gd_Price;
    }

    public void setGd_Price(double gd_Price) {
        this.gd_Price = gd_Price;
    }

    public int getGd_Count() {
        return gd_Count;
    }

    public void setGd_Count(int gd_Count) {
        this.gd_Count = gd_Count;
    }

    public int getGd_State() {
        return gd_State;
    }

    public void setGd_State(int gd_State) {
        this.gd_State = gd_State;
    }

    public String getGt_ID() {
        return gt_ID;
    }

    public void setGt_ID(String gt_ID) {
        this.gt_ID = gt_ID;
    }
}
