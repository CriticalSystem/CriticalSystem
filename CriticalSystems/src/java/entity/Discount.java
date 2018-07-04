/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * 割引カード
 */
@Entity
public class Discount implements Serializable{
    @Id
    @NotNull
    private int DiscountNo;
    @NotNull
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
