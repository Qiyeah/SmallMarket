package com.huayu.A11_3.Util;

import com.huayu.A11_3.Model.Goods;
import com.huayu.A11_3.Model.GoodsType;

import java.util.ArrayList;

/**
 * Created by Qiyeah on 2015/10/17.
 */
public class ListGoods {
    public void printType(ArrayList<GoodsType> gtList){
        for (int i = 0; i < gtList.size(); i++) {
            System.out.println((i+1)+"."+gtList.get(i).getGt_ID()+"\t"+gtList.get(i).getGt_Name()
                    +"\t"+gtList.get(i).getGt_RID());
        }
    }
    public void printGoods(ArrayList<Goods> gdList){
        for (int i = 0; i < gdList.size(); i++) {
            System.out.println((i+1)+"."+gdList.get(i).getGd_Name()+"\t"+gdList.get(i).getGd_Price()+"\t"+1+"\t"+gdList.get(i).getGd_Price()*1);
        }

        /*GoodsDAO gdDAO = new GoodsDAO();
        //�½�һ���б����ȥ�ظ������Ʒ�б�
        ArrayList<Goods> newList = new ArrayList<Goods>();
        //ȥ�ظ��������ظ�����
        HashSet<String> hs = new HashSet<String>();
        for (int i = 0; i < gdList.size(); i++) {
            hs.add(gdList.get(i).getGd_ID());
        }
        Iterator<String> it = hs.iterator();
        int count = 0;
        while (it.hasNext()){
            String val = it.next();
            newList.add(gdDAO.queryGoods(val));
            for (int i = 0; i < gdList.size(); i++) {
                if (val.equals(gdList.get(i).getGd_ID())){
                    count++;
                }
            }
        }
        for (int i = 0; i < newList.size(); i++) {
            System.out.println((i+1)+"."+newList.get(i).getGd_Name()+"\t"+newList.get(i).getGd_Price()+"\t"+count+"\t"+newList.get(i).getGd_Price()*count);
        }*/
    }
}
