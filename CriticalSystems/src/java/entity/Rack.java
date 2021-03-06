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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * レジ
 */
@Entity
@Table(name="RACK")
public class Rack implements Serializable{
    @Id
    @NotNull
    private int serial;       //連番
    @NotNull
    @ManyToOne
    @JoinColumn(name = "store_code")
    private Store store;
    @NotNull
    @Column(name = "rack_number")
    private int RackNo;
    @NotNull
    @Column(name = "rack_rayout")
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