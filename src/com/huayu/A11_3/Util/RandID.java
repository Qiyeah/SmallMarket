package com.huayu.A11_3.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 15-10-11.
 */
public class RandID {
    public static final int BuyID = 1;
    public static final int BuyerID = 2;
    public  static final int BuyInfoID = 3;
    public  static final int GoodsID = 4;
    public  static final int GoodsCommentID = 5;
    public static final int GoodsTypeID = 6;
    public static final int GroundingID = 7;
    public static final int GroundingInfoID = 8;
    public static final int SellID = 9;
    public static final int SellerID = 10;
    public static final int SellInfoID = 11;
    public static final int UdercarriageID = 12;
    public static final int UndercarriageInfoID = 13;
    public static final int ChargeLogID = 14;

    public String getID(int type){//类型不同产生的ID不同
        if(type==1){
            return "buid"+getInfo();//user2015101115022823515245896235
        }else if(type==2){
            return "brid"+getInfo();
        }else if(type==3){
            return "biid"+getInfo();
        }else if(type==4){
            return "gdid"+getInfo();
        }else if(type==5){
            return "gcid"+getInfo();
        }else if(type==6){
            return "gtid"+getInfo();
        }else if(type==7){
            return "roid"+getInfo();
        }else if(type==8){
            return "rnid"+getInfo();
        }else if(type==9){
            return "slid"+getInfo();
        }else if(type==10){
            return "srid"+getInfo();
        }else if(type==11){
            return "siid"+getInfo();
        }else if(type==12){
            return "ucid"+getInfo();
        }else if(type==13){
            return "uiid"+getInfo();
        }else if(type==14){
            return "clid"+getInfo();
        }
        return null;
    }
    public String getInfo(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
        String str = sdf.format(new Date());
        StringBuffer stb = new StringBuffer();
        for(int i=0;i<11;i++){

            stb.append((int)(Math.random()*10));
        }
        return str+stb.toString();
    }
}
