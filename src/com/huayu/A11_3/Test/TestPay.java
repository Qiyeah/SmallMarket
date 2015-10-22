package com.huayu.A11_3.Test;

import com.huayu.A11_3.Model.Buyer;
import com.huayu.A11_3.View.Pay;

/**
 * Created by Qiyeah on 2015/10/18.
 */
public class TestPay {
    public static void main(String[] args) {
        Buyer buyer = new Buyer("brid2015101611032157884121884352",null,null,1000.0,1,null,null);
        new Pay().pay(buyer);
    }
}
