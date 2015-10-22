package com.huayu.A11_3.Model;

import java.util.Date;

/**
 * Created by Qiyeah on 2015/10/16.
 */
public class Buy {
    private String buy_ID;
    private String buyer_ID;
    private Date buy_Date;
    private int buy_State;

    public Buy() {
    }

    public Buy(String buy_ID, String buyer_ID, Date buy_Date, int buy_State) {
        this.setBuy_ID(buy_ID);
        this.setBuyer_ID(buyer_ID);
        this.setBuy_Date(buy_Date);
        this.setBuy_State(buy_State);
    }

    public String getBuy_ID() {
        return buy_ID;
    }

    public void setBuy_ID(String buy_ID) {
        this.buy_ID = buy_ID;
    }

    public String getBuyer_ID() {
        return buyer_ID;
    }

    public void setBuyer_ID(String buyer_ID) {
        this.buyer_ID = buyer_ID;
    }

    public Date getBuy_Date() {
        return buy_Date;
    }

    public void setBuy_Date(Date buy_Date) {
        this.buy_Date = buy_Date;
    }

    public int getBuy_State() {
        return buy_State;
    }

    public void setBuy_State(int buy_State) {
        this.buy_State = buy_State;
    }
}
