package com.huayu.A11_3.Util;

import java.util.Scanner;

/**
 * Created by Administrator on 15-9-30.
 */
public class GetData {
    public String getData(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (null!=str&&!"".equals(str)){
            return str;
        }else{
            System.out.println("Ī�Ҹ㣬�������Ҫ����");
            return getData();
        }
    }
}
