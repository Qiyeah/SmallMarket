package com.huayu.A11_3.Model;

/**
 * Created by Qiyeah on 2015/10/16.
 */
public class GoodsType {
    private String gt_ID ;
    private String gt_Name;
    private String gt_RID;

    public GoodsType() {
    }

    public GoodsType(String gt_ID, String gt_Name, String gt_RID) {
        this.setGt_ID(gt_ID);
        this.setGt_Name(gt_Name);
        this.setGt_RID(gt_RID);
    }

    public String getGt_ID() {
        return gt_ID;
    }

    public void setGt_ID(String gt_ID) {
        this.gt_ID = gt_ID;
    }

    public String getGt_Name() {
        return gt_Name;
    }

    public void setGt_Name(String gt_Name) {
        this.gt_Name = gt_Name;
    }

    public String getGt_RID() {
        return gt_RID;
    }

    public void setGt_RID(String gt_RID) {
        this.gt_RID = gt_RID;
    }
}
