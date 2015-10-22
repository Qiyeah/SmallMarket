package com.huayu.A11_3.Model;

import java.util.Date;

/**
 * Created by Qiyeah on 2015/10/16.
 */
public class GoodsComment {
    private String gc_ID;
    private String buyer_ID;
    private String gd_ID;
    private Date gc_Date;
    private String gc_Comment;
    private int gc_State;

    public GoodsComment() {
    }

    public GoodsComment(String gc_ID, String buyer_ID, String gd_ID, Date gc_Date, String gc_Comment, int gc_State) {
        this.setGc_ID(gc_ID);
        this.setBuyer_ID(buyer_ID);
        this.setGd_ID(gd_ID);
        this.setGc_Date(gc_Date);
        this.setGc_Comment(gc_Comment);
        this.setGc_State(gc_State);
    }

    public String getGc_ID() {
        return gc_ID;
    }

    public void setGc_ID(String gc_ID) {
        this.gc_ID = gc_ID;
    }

    public String getBuyer_ID() {
        return buyer_ID;
    }

    public void setBuyer_ID(String buyer_ID) {
        this.buyer_ID = buyer_ID;
    }

    public String getGd_ID() {
        return gd_ID;
    }

    public void setGd_ID(String gd_ID) {
        this.gd_ID = gd_ID;
    }

    public Date getGc_Date() {
        return gc_Date;
    }

    public void setGc_Date(Date gc_Date) {
        this.gc_Date = gc_Date;
    }

    public String getGc_Comment() {
        return gc_Comment;
    }

    public void setGc_Comment(String gc_Comment) {
        this.gc_Comment = gc_Comment;
    }

    public int getGc_State() {
        return gc_State;
    }

    public void setGc_State(int gc_State) {
        this.gc_State = gc_State;
    }
}
