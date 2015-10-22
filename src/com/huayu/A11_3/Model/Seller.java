package com.huayu.A11_3.Model;

/**
 * Created by Qiyeah on 2015/10/16.
 */
public class Seller {
    private String seller_ID;
    private String seller_Name;
    private String seller_Pass;
    private double seller_Money;

    public Seller() {
    }

    public Seller(String seller_ID, String seller_Name, String seller_Pass, double seller_Money) {
        this.setSeller_ID(seller_ID);
        this.setSeller_Name(seller_Name);
        this.setSeller_Pass(seller_Pass);
        this.setSeller_Money(seller_Money);
    }

    public String getSeller_ID() {
        return seller_ID;
    }

    public void setSeller_ID(String seller_ID) {
        this.seller_ID = seller_ID;
    }

    public String getSeller_Name() {
        return seller_Name;
    }

    public void setSeller_Name(String seller_Name) {
        this.seller_Name = seller_Name;
    }

    public String getSeller_Pass() {
        return seller_Pass;
    }

    public void setSeller_Pass(String seller_Pass) {
        this.seller_Pass = seller_Pass;
    }

    public double getSeller_Money() {
        return seller_Money;
    }

    public void setSeller_Money(double seller_Money) {
        this.seller_Money = seller_Money;
    }
}
