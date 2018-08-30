/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author s20163051
 */
public class Cash_Register_Result {

    private String title;
    private int money;

    //  コンストラクタ
    public Cash_Register_Result() {
    }

    public Cash_Register_Result(String title, int money) {
        this.title = title;
        this.money = money;
    }

    //  セッター、ゲッター
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

}
