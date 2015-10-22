package com.huayu.A11_3.Model;

import java.util.Date;

/**
 * Created by Qiyeah on 2015/10/19.
 */
public class ChargeLog {
    private String cl_ID;
    private double cl_Money;
    private int cl_State;
    private String buyer_ID;
    private Date cl_Date;

    public ChargeLog() {
    }

    public ChargeLog(String cl_ID, double cl_Money, int cl_State, String buyer_ID, Date cl_Date) {
        this.setCl_ID(cl_ID);
        this.setCl_Money(cl_Money);
        this.setBuyer_ID(buyer_ID);
        this.setCl_State(cl_State);
        this.setCl_Date(cl_Date);
    }

    public String getCl_ID() {
        return cl_ID;
    }

    public void setCl_ID(String cl_ID) {
        this.cl_ID = cl_ID;
    }

    public double getCl_Money() {
        return cl_Money;
    }

    public void setCl_Money(double cl_Money) {
        this.cl_Money = cl_Money;
    }

    public int getCl_State() {
        return cl_State;
    }

    public void setCl_State(int cl_State) {
        this.cl_State = cl_State;
    }

    public String getBuyer_ID() {
        return buyer_ID;
    }

    public void setBuyer_ID(String buyer_ID) {
        this.buyer_ID = buyer_ID;
    }

    public Date getCl_Date() {
        return cl_Date;
    }

    public void setCl_Date(Date cl_Date) {
        this.cl_Date = cl_Date;
    }
}
