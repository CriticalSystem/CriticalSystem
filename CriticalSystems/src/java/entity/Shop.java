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
 *
 * @author s20163048
 */
@Entity
public class Shop implements Serializable {
    
    @Id
    @NotNull
    private String ShopCD;
    
    private String ShopName;

    private String ShopAddres;
    
    private String ShopTel;
    
    private String ShopMAP;
    
    private String ShopMail;

    /**
     * @return the ShopCD
     */
    public String getShopCD() {
        return ShopCD;
    }

    /**
     * @param ShopCD the ShopCD to set
     */
    public void setShopCD(String ShopCD) {
        this.ShopCD = ShopCD;
    }

    /**
     * @return the ShopName
     */
    public String getShopName() {
        return ShopName;
    }

    /**
     * @param ShopName the ShopName to set
     */
    public void setShopName(String ShopName) {
        this.ShopName = ShopName;
    }

    /**
     * @return the ShopAddres
     */
    public String getShopAddres() {
        return ShopAddres;
    }

    /**
     * @param ShopAddres the ShopAddres to set
     */
    public void setShopAddres(String ShopAddres) {
        this.ShopAddres = ShopAddres;
    }

    /**
     * @return the ShopTel
     */
    public String getShopTel() {
        return ShopTel;
    }

    /**
     * @param ShopTel the ShopTel to set
     */
    public void setShopTel(String ShopTel) {
        this.ShopTel = ShopTel;
    }

    /**
     * @return the ShopMAP
     */
    public String getShopMAP() {
        return ShopMAP;
    }

    /**
     * @param ShopMAP the ShopMAP to set
     */
    public void setShopMAP(String ShopMAP) {
        this.ShopMAP = ShopMAP;
    }

    /**
     * @return the ShopMail
     */
    public String getShopMail() {
        return ShopMail;
    }

    /**
     * @param ShopMail the ShopMail to set
     */
    public void setShopMail(String ShopMail) {
        this.ShopMail = ShopMail;
    }
}
