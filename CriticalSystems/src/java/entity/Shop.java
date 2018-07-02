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
    private static String ShopCD;
    
    private static String ShopName;

    private static String ShopAddres;
    
    private static String ShopTel;
    
    private static String ShopMAP;
    
    private static String ShopMail;

    /**
     * @return the ShopCD
     */
    public static String getShopCD() {
        return ShopCD;
    }

    /**
     * @param aShopCD the ShopCD to set
     */
    public static void setShopCD(String aShopCD) {
        ShopCD = aShopCD;
    }

    /**
     * @return the ShopName
     */
    public static String getShopName() {
        return ShopName;
    }

    /**
     * @param aShopName the ShopName to set
     */
    public static void setShopName(String aShopName) {
        ShopName = aShopName;
    }

    /**
     * @return the ShopAddres
     */
    public static String getShopAddres() {
        return ShopAddres;
    }

    /**
     * @param aShopAddres the ShopAddres to set
     */
    public static void setShopAddres(String aShopAddres) {
        ShopAddres = aShopAddres;
    }

    /**
     * @return the ShopTel
     */
    public static String getShopTel() {
        return ShopTel;
    }

    /**
     * @param aShopTel the ShopTel to set
     */
    public static void setShopTel(String aShopTel) {
        ShopTel = aShopTel;
    }

    /**
     * @return the ShopMAP
     */
    public static String getShopMAP() {
        return ShopMAP;
    }

    /**
     * @param aShopM the ShopMAP to set
     */
    public static void setShopMAP(String aShopM) {
        ShopMAP = aShopM;
    }

    /**
     * @return the ShopMail
     */
    public static String getShopMail() {
        return ShopMail;
    }

    /**
     * @param aShopMail the ShopMail to set
     */
    public static void setShopMail(String aShopMail) {
        ShopMail = aShopMail;
    }
    
}
