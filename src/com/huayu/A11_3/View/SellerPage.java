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
        System.out.println("-------------------欢迎 【 " + seller.getSeller_Name() + " 】使用牛xx系统-------------------");
        for (int i = 0; i < 1;) {
        System.out.println("|-1.修改密码\n|-2.帐户充值\n|-3.营业额查询\n|-4.商品上架\n|-5.商品下架\n|-6.归类整理\n|-7.退出登陆");
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
                System.out.println("Error:输入要不得啊，重新写");
            }
        }
    }
}
