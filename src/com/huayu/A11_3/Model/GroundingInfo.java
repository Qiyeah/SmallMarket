package com.huayu.A11_3.Model;

import java.util.Date;

/**
 * Created by Qiyeah on 2015/10/16.
 */
public class GroundingInfo {
    private String gri_ID;
    private String gr_ID;
    private String gd_ID;

    public GroundingInfo() {
    }

    public GroundingInfo(String gri_ID, String gr_ID, String gd_ID) {
        this.setGri_ID(gri_ID);
        this.setGr_ID(gr_ID);
        this.setGd_ID(gd_ID);
    }

    public String getGri_ID() {
        return gri_ID;
    }

    public void setGri_ID(String gri_ID) {
        this.gri_ID = gri_ID;
    }

    public String getGr_ID() {
        return gr_ID;
    }

    public void setGr_ID(String gr_ID) {
        this.gr_ID = gr_ID;
    }

    public String getGd_ID() {
        return gd_ID;
    }

    public void setGd_ID(String gd_ID) {
        this.gd_ID = gd_ID;
    }
}
