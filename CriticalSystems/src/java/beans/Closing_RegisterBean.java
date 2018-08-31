/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.RegisterInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author s20163051
 */
@Named
@RequestScoped
public class Closing_RegisterBean {

//    private int xkyen;          //  一万円紙幣(枚)
//    private int vkyen;          //  五千円紙幣(枚)
//    private int iikyen;         //  二千円紙幣(枚)
//    private int ikyen;          //  千円紙幣(枚)
//    private int dyen_1;         //  五百円硬貨(本)
//    private int dyen_2;         //  五百円硬貨(枚)
//    private int cyen_1;         //  百円硬貨(本)
//    private int cyen_2;         //  百円硬貨(枚)
//    private int lyen_1;         //  五十円硬貨(本)
//    private int lyen_2;         //  五十円硬貨(枚)
//    private int xyen_1;         //  十円硬貨(本)
//    private int xyen_2;         //  十円硬貨(枚)
//    private int vyen_1;         //  五円硬貨(本)
//    private int vyen_2;         //  五円硬貨(枚)
//    private int iyen_1;         //  一円硬貨(本)
//    private int iyen_2;         //  一円硬貨(枚)
    private int amount;         //  合計金額(円)
    private int sales;          //  売上金額(円)
    private int difference;     //  過不足額(円)

    private List<Cash_Register> cash_Register_Bill;
    private List<Cash_Register> cash_Register_Coin;

    {
        cash_Register_Bill = new ArrayList<>();
        cash_Register_Bill.add(new Cash_Register("一万円紙幣", 0, 0, 10000));
        cash_Register_Bill.add(new Cash_Register("五千円紙幣", 0, 0, 5000));
        cash_Register_Bill.add(new Cash_Register("二千円紙幣", 0, 0, 2000));
        cash_Register_Bill.add(new Cash_Register("　千円紙幣", 0, 0, 1000));

        cash_Register_Coin = new ArrayList<>();
        cash_Register_Coin.add(new Cash_Register("五百円硬貨", 0, 0, 500));
        cash_Register_Coin.add(new Cash_Register("　百円硬貨", 0, 0, 100));
        cash_Register_Coin.add(new Cash_Register("五十円硬貨", 0, 0, 50));
        cash_Register_Coin.add(new Cash_Register("　十円硬貨", 0, 0, 10));
        cash_Register_Coin.add(new Cash_Register("　五円硬貨", 0, 0, 5));
        cash_Register_Coin.add(new Cash_Register("　一円硬貨", 0, 0, 1));

    }

    @Inject
    transient Logger log;

    public String next() {
        return "closing_register_output.xhtml";
    }

    public List<Cash_Register> getCash_Register_Bill() {
        return cash_Register_Bill;
    }

    public void setCash_Register_Bill(List<Cash_Register> cash_Register_Bill) {
        this.cash_Register_Bill = cash_Register_Bill;
    }

    public List<Cash_Register> getCash_Register_Coin() {
        return cash_Register_Coin;
    }

    public void setCash_Register_Coin(List<Cash_Register> cash_Register_Coin) {
        this.cash_Register_Coin = cash_Register_Coin;
    }

    public int getAmount() {
        int amount_bill = 0;
        int amount_coin = 0;
        for (int i = 0; i < 4; i++) {
            int moneys = cash_Register_Bill.get(i).getMoneys() * cash_Register_Bill.get(i).getSheet();
            amount_bill = amount_bill + moneys;
        }
        for (int i = 0; i < 6; i++) {
            int moneys = cash_Register_Coin.get(i).getMoneys() * ((cash_Register_Coin.get(i).getPiece() * 50) + cash_Register_Coin.get(i).getSheet());
            amount_coin = amount_coin + moneys;
        }
        amount = amount_bill + amount_coin;
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSales() {
        RegisterInfo regi = new RegisterInfo();
        sales = regi.getTotal();
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getDifference() {
        difference = getAmount() - getSales();
        return difference;
    }

    public void setDifference(int difference) {
        this.difference = difference;
    }

}
