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
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * レジ
 */
@Entity
@Table(name="REGISTER")
public class Register implements Serializable{
    @Id
    @NotNull
    @Column(name = "register_code")
    private String registerCD;  //レジCD
    @NotNull
    @JoinColumn(name = "store_code")
    private Store store;        //店舗CD

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
     * @return the Store
     */
    public Store getStore() {
        return store;
    }

    /**
     * @param Store the Store to set
     */
    public void setStore(Store store) {
        this.store = store;
    }
}