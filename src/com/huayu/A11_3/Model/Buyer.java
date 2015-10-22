package com.huayu.A11_3.Model;

/**
 * Created by Qiyeah on 2015/10/16.
 */
public class Buyer {
    private String buyer_ID;
    private String buyer_Name;
    private String buyer_Pass;
    private double buyer_Money;
    private int buyer_State;
    private String buyer_Phone;
    private String buyer_Email;
    public Buyer(){}

    public Buyer(String buyer_ID, String buyer_Name, String buyer_Pass,
                 double buyer_Money, int buyer_State, String buyer_Phone,
                 String buyer_Email) {
        this.setBuyer_ID(buyer_ID);
        this.setBuyer_Name(buyer_Name);
        this.setBuyer_Pass(buyer_Pass);
        this.setBuyer_Money(buyer_Money);
        this.setBuyer_Phone(buyer_Phone);
        this.setBuyer_Email(buyer_Email);
        this.setBuyer_State(buyer_State);
    }

    public String getBuyer_ID() {
        return buyer_ID;
    }

    public void setBuyer_ID(String buyer_ID) {
        this.buyer_ID = buyer_ID;
    }

    public String getBuyer_Name() {
        return buyer_Name;
    }

    public void setBuyer_Name(String buyer_Name) {
        this.buyer_Name = buyer_Name;
    }

    public String getBuyer_Pass() {
        return buyer_Pass;
    }

    public void setBuyer_Pass(String buyer_Pass) {
        this.buyer_Pass = buyer_Pass;
    }

    public double getBuyer_Money() {
        return buyer_Money;
    }

    public void setBuyer_Money(double buyer_Money) {
        this.buyer_Money = buyer_Money;
    }

    public int getBuyer_State() {
        return buyer_State;
    }

    public void setBuyer_State(int buyer_State) {
        this.buyer_State = buyer_State;
    }

    public String getBuyer_Phone() {
        return buyer_Phone;
    }

    public void setBuyer_Phone(String buyer_Phone) {
        this.buyer_Phone = buyer_Phone;
    }

    public String getBuyer_Email() {
        return buyer_Email;
    }

    public void setBuyer_Email(String buyer_Email) {
        this.buyer_Email = buyer_Email;
    }
}
