package com.huayu.A11_3.Util;

import com.huayu.A11_3.DAO.GoodsDAO;
import com.huayu.A11_3.Model.Goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Qiyeah on 2015/10/20.
 */
public class GetGoodsCount {
    public HashMap<String,Integer> getCount(ArrayList<Goods> gdList){
        HashMap<String,Integer> hashMap = new HashMap<>();
        GoodsDAO gdDAO = new GoodsDAO();
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
            hashMap.put(val,count);
        }
       /* for (int i = 0; i < newList.size(); i++) {
            System.out.println((i+1)+"."+newList.get(i).getGd_Name()+"\t"+newList.get(i).getGd_Price()+"\t"+count+"\t"+newList.get(i).getGd_Price()*count);
        }*/
        return hashMap;
    }
}
