package com.huayu.A11_3.Util;

/**
 * Created by Qiyeah on 2015/10/17.
 */
public class Next {
    public int nextStep(GetData gd,int j){
        System.out.println("·µ»Ø£º Y / N ");
        String dec1 = gd.getData();
        if (dec1.matches("[Yy]")){
            j++;
        }else if (dec1.matches("[Nn]")){
            j=0;
        }
        return j;
    }
}
