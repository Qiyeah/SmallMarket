package com.huayu.A11_3.Util;

/**
 * Created by Qiyeah on 2015/10/21.
 */
public class Exit {
    public void exit(){
        System.out.println("ϵͳ��ʾ��ϵͳ�˳�...");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
