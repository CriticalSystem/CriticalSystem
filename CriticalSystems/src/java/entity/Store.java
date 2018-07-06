/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 店舗
 */

@NamedQuery(name = "Shop.ShopQAll" , query = "SELECT e FROM Shop")

@Entity
@Table(name="STORE")
public class Store implements Serializable {
    public static final String ShopQAll = "ShopQAll";
    
    @Id
    @NotNull
    private String StoreCD;      //店舗CD
    @NotNull
    private String Name;    //店舗名
    @NotNull
    private String Addres;  //住所
    @NotNull
    private String Tel;     //電話番号
    
    private String StoreMAP;     //店舗見取り図

    /**
     * @return the StoreCD
     */
    public String getStoreCD() {
        return StoreCD;
    }

    /**
     * @param StoreCD the StoreCD to set
     */
    public void setStoreCD(String StoreCD) {
        this.StoreCD = StoreCD;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Addres
     */
    public String getAddres() {
        return Addres;
    }

    /**
     * @param Addres the Addres to set
     */
    public void setAddres(String Addres) {
        this.Addres = Addres;
    }

    /**
     * @return the Tel
     */
    public String getTel() {
        return Tel;
    }

    /**
     * @param Tel the Tel to set
     */
    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    /**
     * @return the StoreMAP
     */
    public String getStoreMAP() {
        return StoreMAP;
    }

    /**
     * @param StoreMAP the StoreMAP to set
     */
    public void setStoreMAP(String StoreMAP) {
        this.StoreMAP = StoreMAP;
    }

    

}
