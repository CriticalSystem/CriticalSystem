/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 売り上げ
 */
@Entity
@Table(name="SALES")
public class Sales implements Serializable{
    @Id
    @NotNull
    @Column(name = "store_code")
    private Store store;    //店舗CD
    @NotNull
    @Column(name = "month")
    private Date date;      //年月
    @NotNull
    @Column(name = "total_sales")
    private int totalSales; //総売り上げ

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
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the totalSales
     */
    public int getTotalSales() {
        return totalSales;
    }

    /**
     * @param totalSales the totalSales to set
     */
    public void setTotalSales(int totalSales) {
        this.totalSales = totalSales;
    }
    
}