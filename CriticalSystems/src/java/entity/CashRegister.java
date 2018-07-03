/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * レジ
 */
@Entity
public class CashRegister implements Serializable{
    @Id
    private String registerCD;
    private Shop Shop;

    /**
     * @return the registerCD
     */
    public String getRegisterCD() {
        return registerCD;
    }

    /**
     * @param registerCD the registerCD to set
     */
    public void setRegisterCD(String registerCD) {
        this.registerCD = registerCD;
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
}