/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 貸出
 */
@Entity
public class Receipt implements Serializable{
    @Id
    private int receiptNo;
    private Member Member;
    private Employee Employee;
    private Shop Shop;
    private Date Date;
    private int subtotal;
    private CashRegister Register;   // レジ

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
     * @return the Shop
     */
    public Shop getShop() {
        return Shop;
    }

    /**
     * @param Shop the Shop to set
     */
    public void setShop(Shop Shop) {
        this.Shop = Shop;
    }

    /**
     * @return the Date
     */
    public Date getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(Date Date) {
        this.Date = Date;
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
    public CashRegister getRegister() {
        return Register;
    }

    /**
     * @param Register the Register to set
     */
    public void setRegister(CashRegister Register) {
        this.Register = Register;
    }
    
    
}
