package com.huayu.A11_3.Model;

/**
 * Created by Qiyeah on 2015/10/16.
 */
public class BuyInfo {
    private String buyi_ID;
    private String buy_ID;
    private String gd_ID;
    private int buyi_Count;
    public BuyInfo() {
    }

    public BuyInfo(String buyi_ID, String buy_ID, String gd_ID, int buyi_Count) {
        this.setBuyi_ID(buyi_ID);
        this.setBuy_ID(buy_ID);
        this.setGd_ID(gd_ID);
        this.setBuyi_Count(buyi_Count);
    }

    public String getBuyi_ID() {
        return buyi_ID;
    }

    public void setBuyi_ID(String buyi_ID) {
        this.buyi_ID = buyi_ID;
    }

    public String getBuy_ID() {
        return buy_ID;
    }

    public void setBuy_ID(String buy_ID) {
        this.buy_ID = buy_ID;
    }

    public String getGd_ID() {
        return gd_ID;
    }

    public void setGd_ID(String gd_ID) {
        this.gd_ID = gd_ID;
    }

    public int getBuyi_Count() {
        return buyi_Count;
    }

    public void setBuyi_Count(int buyi_Count) {
        this.buyi_Count = buyi_Count;
    }
}
