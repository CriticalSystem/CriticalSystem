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
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 店舗
 */

@NamedQuery(name = "Store.StoreQAll" , query = "SELECT e FROM Store")

@Entity
@Table(name="STORE")
public class Store implements Serializable {
    public static final String StoreQAll = "StoreQAll";
    
    @Id
    @NotNull
    @Column(name = "store_code")
    private String StoreCD;      //店舗CD
    @NotNull
    @Column(name = "store_name")
    private String Name;    //店舗名
    @NotNull
    @Column(name = "address")
    private String Addres;  //住所
    @NotNull
    @Column(name = "tel_number")
    private String Tel;     //電話番号
    @Column(name = "store_map")
    private String StoreMAP;     //店舗見取り図
    @Column(name = "email")
    private String email;
    

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

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    

}
