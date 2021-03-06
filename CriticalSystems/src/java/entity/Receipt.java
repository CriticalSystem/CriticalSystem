/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 貸出
 */
@NamedQueries({
    @NamedQuery(name = "Receipt.ReceiptQAll" , query = "SELECT r FROM Receipt r"),
    //@NamedQuery(name = "Receipt.ReceiptDel" , query = "DELETE FROM Receipt"),
})

@Entity
@Table(name="RECEIPT")
public class Receipt implements Serializable{
//    public static final String ReceiptQAll = "";
    public static final String ReceiptDel = "ReceiptDel";
    public static final String ReceiptQAll = "ReceiptQAll";
    
    @Id
    @NotNull
    @Column(name = "slip_number")
    private String slip_number;      //伝票No
    @JoinColumn(name = "members_code")
    private String members_code;      //会員CD
    @JoinColumn(name = "employees_code")
    private String employees_code;  //店員CD
    @JoinColumn(name = "store_code")
    private String store_code;         //店舗
    @Column(name = "lend_date")
    private Date Lend_date;      //貸出日時
    @Column(name = "total_price")
    private int total_price;      //合計金額
    @Column(name = "is_discount")
    private boolean is_discount;   // 割引フラグ
    @Column(name = "disc_code")
    private String disc_code;
    @Column(name = "rental_flg")
    private String rental_flg;
    
    public Receipt() {
    }
    
    public Receipt(String slip_number) {
        this.slip_number = slip_number;
    }

    /**
     * @return the slip_number
     */
    public String getSlip_number() {
        return slip_number;
    }

    /**
     * @param slip_number the slip_number to set
     */
    public void setSlip_number(String slip_number) {
        this.slip_number = slip_number;
    }

    /**
     * @return the members_code
     */
    public String getMembers_code() {
        return members_code;
    }

    /**
     * @param members_code the members_code to set
     */
    public void setMembers_code(String members_code) {
        this.members_code = members_code;
    }

    /**
     * @return the employees_code
     */
    public String getEmployees_code() {
        return employees_code;
    }

    /**
     * @param employees_code the employees_code to set
     */
    public void setEmployees_code(String employees_code) {
        this.employees_code = employees_code;
    }

    /**
     * @return the store_code
     */
    public String getStore_code() {
        return store_code;
    }

    /**
     * @param store_code the store_code to set
     */
    public void setStore_code(String store_code) {
        this.store_code = store_code;
    }

    /**
     * @return the Lend_date
     */
    public Date getLend_date() {
        return Lend_date;
    }

    /**
     * @param Lend_date the Lend_date to set
     */
    public void setLend_date(Date Lend_date) {
        this.Lend_date = Lend_date;
    }

    /**
     * @return the total_price
     */
    public int getTotal_price() {
        return total_price;
    }

    /**
     * @param total_price the total_price to set
     */
    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    /**
     * @return the is_discount
     */
    public boolean isIs_discount() {
        return is_discount;
    }

    /**
     * @param is_discount the is_discount to set
     */
    public void setIs_discount(boolean is_discount) {
        this.is_discount = is_discount;
    }

    /**
     * @return the disc_code
     */
    public String getDisc_code() {
        return disc_code;
    }

    /**
     * @param disc_code the disc_code to set
     */
    public void setDisc_code(String disc_code) {
        this.disc_code = disc_code;
    }

    /**
     * @return the rental_flg
     */
    public String getRental_flg() {
        return rental_flg;
    }

    /**
     * @param rental_flg the rental_flg to set
     */
    public void setRental_flg(String rental_flg) {
        this.rental_flg = rental_flg;
    }
}
