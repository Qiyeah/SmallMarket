package com.huayu.A11_3.View;

import com.huayu.A11_3.Model.Seller;
import com.huayu.A11_3.Util.Exit;
import com.huayu.A11_3.Util.GetData;

/**
 * Created by Qiyeah on 2015/10/16.
 */
public class SellerPage {
    GetData gd = new GetData();
    public void sellerCenter(Seller seller){
        System.out.println("-------------------��ӭ �� " + seller.getSeller_Name() + " ��ʹ��ţxxϵͳ-------------------");
        for (int i = 0; i < 1;) {
        System.out.println("|-1.�޸�����\n|-2.�ʻ���ֵ\n|-3.Ӫҵ���ѯ\n|-4.��Ʒ�ϼ�\n|-5.��Ʒ�¼�\n|-6.��������\n|-7.�˳���½");
        System.out.println("-------------------------------------------------------------------------");
            String dec = gd.getData();
            if ("1".equals(dec)){
                i++;
            }else if ("2".equals(dec)){
                i++;
                new ChargeCenter().charge(seller);
            }else if ("3".equals(dec)){
                i++;
                new QuerySellerMoney().querySellerMoney(seller);
            }else if ("4".equals(dec)){
                i++;
                new Shelves().goodsShelves(seller);
            }else if ("5".equals(dec)){
                i++;
                new UnshelvesPage().unshelvesGoods(seller);
            }else if ("6".equals(dec)){
                i++;
                new CataloguedPage().classfiedGoods(seller);
            }else if ("7".equals(dec)){
                i++;
                new Exit().exit();
            }else{
                System.out.println("Error:����Ҫ���ð�������д");
            }
        }
    }
}
