package com.huayu.A11_3.Model;

import java.util.Date;

/**
 * Created by Qiyeah on 2015/10/16.
 */
public class Grounding {
    private String gr_ID;
    private String seller_ID;
    private Date gr_Date;
    private int gr_State;

    public Grounding() {
    }

    public Grounding(String gr_ID, String seller_ID, Date gr_Date, int gr_State) {
        this.setGr_ID(gr_ID);
        this.setSeller_ID(seller_ID);
        this.setGr_Date(gr_Date);
        this.setGr_State(gr_State);
    }

    public String getGr_ID() {
        return gr_ID;
    }

    public void setGr_ID(String gr_ID) {
        this.gr_ID = gr_ID;
    }

    public String getSeller_ID() {
        return seller_ID;
    }

    public void setSeller_ID(String seller_ID) {
        this.seller_ID = seller_ID;
    }

    public Date getGr_Date() {
        return gr_Date;
    }

    public void setGr_Date(Date gr_Date) {
        this.gr_Date = gr_Date;
    }

    public int getGr_State() {
        return gr_State;
    }

    public void setGr_State(int gr_State) {
        this.gr_State = gr_State;
    }

}
