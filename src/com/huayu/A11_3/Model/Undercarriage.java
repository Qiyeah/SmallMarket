package com.huayu.A11_3.Model;

import java.util.Date;

/**
 * Created by Qiyeah on 2015/10/16.
 */
public class Undercarriage {
    private String uc_ID;
    private String seller_ID;
    private Date uc_Date;
    private int uc_State;

    public Undercarriage() {
    }

    public Undercarriage(String uc_ID, String seller_ID, Date uc_Date, int uc_State) {
        this.setUc_ID(uc_ID);
        this.setSeller_ID(seller_ID);
        this.setUc_Date(uc_Date);
        this.setUc_State(uc_State);
    }

    public String getUc_ID() {
        return uc_ID;
    }

    public void setUc_ID(String uc_ID) {
        this.uc_ID = uc_ID;
    }

    public String getSeller_ID() {
        return seller_ID;
    }

    public void setSeller_ID(String seller_ID) {
        this.seller_ID = seller_ID;
    }

    public Date getUc_Date() {
        return uc_Date;
    }

    public void setUc_Date(Date uc_Date) {
        this.uc_Date = uc_Date;
    }

    public int getUc_State() {
        return uc_State;
    }

    public void setUc_State(int uc_State) {
        this.uc_State = uc_State;
    }
}
