package com.huayu.A11_3.Model;

/**
 * Created by Qiyeah on 2015/10/16.
 */
public class UndercarriageInfo {
    private String uci_ID;
    private String uc_ID;
    private String gd_ID;

    public UndercarriageInfo() {
    }

    public UndercarriageInfo(String uci_ID, String uc_ID, String gd_ID) {
        this.setUci_ID(uci_ID);
        this.setUc_ID(uc_ID);
        this.setGd_ID(gd_ID);
    }

    public String getUci_ID() {
        return uci_ID;
    }

    public void setUci_ID(String uci_ID) {
        this.uci_ID = uci_ID;
    }

    public String getUc_ID() {
        return uc_ID;
    }

    public void setUc_ID(String uc_ID) {
        this.uc_ID = uc_ID;
    }

    public String getGd_ID() {
        return gd_ID;
    }

    public void setGd_ID(String gd_ID) {
        this.gd_ID = gd_ID;
    }
}
