package com.huayu.A11_3.DTO;

import com.huayu.A11_3.DAO.*;
import com.huayu.A11_3.Model.*;

/**
 * Created by Qiyeah on 2015/10/21.
 */
public class ChargeDTO {
    private BuyerDAO brDAO ;
    private SellerDAO slDAO;
    private Buyer buyer;
    private Seller seller;
    public ChargeDTO() {
    }

    public ChargeDTO(BuyerDAO brDAO, SellerDAO slDAO, Buyer buyer, Seller seller) {
        this.setSeller(seller);
        this.setBuyer(buyer);
        this.setBrDAO(brDAO);
        this.setSlDAO(slDAO);
    }

    public BuyerDAO getBrDAO() {
        return brDAO;
    }

    public void setBrDAO(BuyerDAO brDAO) {
        this.brDAO = brDAO;
    }

    public SellerDAO getSlDAO() {
        return slDAO;
    }

    public void setSlDAO(SellerDAO slDAO) {
        this.slDAO = slDAO;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public boolean doCharge(String buyer_ID,double money){
        System.out.println(buyer_ID+"::"+money);
        boolean ad = brDAO.addCharge(buyer_ID,money);
        boolean pl = slDAO.plusMoney(money);
        if (pl&&ad){
            return true;
        }
        return false;
    }
    public boolean doCharge(int cl_State,String buyer_ID){
        return brDAO.changeChargeState(cl_State,buyer_ID);
    }

}
