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
 * レジ
 */
@Entity
public class Rack implements Serializable{
    @Id
    @NotNull
    private Store store;
    @NotNull
    private int RackNo;
    @NotNull
    private String RackImg;

    /**
     * @return the store
     */
    public Store getStore() {
        return store;
    }

    /**
     * @param store the store to set
     */
    public void setStore(Store store) {
        this.store = store;
    }

    /**
     * @return the RackNo
     */
    public int getRackNo() {
        return RackNo;
    }

    /**
     * @param RackNo the RackNo to set
     */
    public void setRackNo(int RackNo) {
        this.RackNo = RackNo;
    }

    /**
     * @return the RackImg
     */
    public String getRackImg() {
        return RackImg;
    }

    /**
     * @param RackImg the RackImg to set
     */
    public void setRackImg(String RackImg) {
        this.RackImg = RackImg;
    }
    
    
}