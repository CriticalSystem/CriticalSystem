/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 貸出
 */
@NamedQueries({
    @NamedQuery(name = "Receipt.ReceiptQAll" , query = "INSERT "),
})
@Entity
@Table(name="RECEIPT")
public class Receipt implements Serializable{
    public static final String ReceiptQAll = "ReceiptQAll";
    @Id
    @NotNull
    private int receiptNo;      //伝票No
    @NotNull
    private Member Member;      //会員CD
    @NotNull
    private Employee Employee;  //店員CD
    @NotNull
    private Store store;         //店舗
    @NotNull
    private Date LendDate;      //貸出日時
    @NotNull
    private int subtotal;       //合計金額
    @NotNull
    private Register Register;   // レジ

    /**
     * @return the receiptNo
     */
    public int getReceiptNo() {
        return receiptNo;
    }

    /**
     * @param receiptNo the receiptNo to set
     */
    public void setReceiptNo(int receiptNo) {
        this.receiptNo = receiptNo;
    }

    /**
     * @return the Member
     */
    public Member getMember() {
        return Member;
    }

    /**
     * @param Member the Member to set
     */
    public void setMember(Member Member) {
        this.Member = Member;
    }

    /**
     * @return the Employee
     */
    public Employee getEmployee() {
        return Employee;
    }

    /**
     * @param Employee the Employee to set
     */
    public void setEmployee(Employee Employee) {
        this.Employee = Employee;
    }

    /**
     * @return the Store
     */
    public Store getStore() {
        return store;
    }

    /**
     * @param store the Store to set
     */
    public void setStore(Store store) {
        this.store = store;
    }

    /**
     * @return the Date
     */
    public Date getLendDate() {
        return LendDate;
    }

    /**
     * @param Date the Date to set
     */
    public void setLendDate(Date LendDate) {
        this.LendDate = LendDate;
    }

    /**
     * @return the subtotal
     */
    public int getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return the Register
     */
    public Register getRegister() {
        return Register;
    }

    /**
     * @param Register the Register to set
     */
    public void setRegister(Register Register) {
        this.Register = Register;
    }
    
    
}