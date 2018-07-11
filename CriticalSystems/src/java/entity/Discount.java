/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 * 割引カード
 */
@Entity
@Table(name="DISCOUNT")
public class Discount implements Serializable{
    @Id
    @NotNull
    @Column(name = "discount_number")
    private int DiscountNo;
    @NotNull
    @Column(name = "discount_times")
    private int Discount;
    
    /**
     * @return the DiscountNo
     */
    public int getDiscountNo() {
        return DiscountNo;
    }

    /**
     * @param DiscountNo the DiscountNo to set
     */
    public void setDiscountNo(int DiscountNo) {
        this.DiscountNo = DiscountNo;
    }

    /**
     * @return the Discount
     */
    public int getDiscount() {
        return Discount;
    }

    /**
     * @param Discount the Discount to set
     */
    public void setDiscount(int Discount) {
        this.Discount = Discount;
    }
    
    
}
