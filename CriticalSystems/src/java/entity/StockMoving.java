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
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 在庫移動
 */
@Entity
@Table(name="STOCK_MOVING")
public class StockMoving implements Serializable{
    @Id
    @Column(name = "serial_number")
    private int serialNo;       //連番
    @NotNull
    @JoinColumn(name = "title_code")
    private Title title;        //タイトル
    @NotNull
    @Column(name = "approval")
    private String stats;       //承認状況
    @NotNull
    @JoinColumn(name = "req_store")
    private Store reqStore;     //申請店舗
    @JoinColumn(name = "offer_store")
    private Store offerStore;   //提供店舗
    @NotNull
    @Column(name = "req_date")
    private Date reqDate;       //申請日
    @Column(name = "req_number")
    private int Number;         //個数 

    /**
     * @return the serialNo
     */
    public int getSerialNo() {
        return serialNo;
    }

    /**
     * @param serialNo the serialNo to set
     */
    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    /**
     * @return the title
     */
    public Title getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(Title title) {
        this.title = title;
    }

    /**
     * @return the stats
     */
    public String getStats() {
        return stats;
    }

    /**
     * @param stats the stats to set
     */
    public void setStats(String stats) {
        this.stats = stats;
    }

    /**
     * @return the reqStore
     */
    public Store getReqStore() {
        return reqStore;
    }

    /**
     * @param reqStore the reqStore to set
     */
    public void setReqStore(Store reqStore) {
        this.reqStore = reqStore;
    }

    /**
     * @return the offerStore
     */
    public Store getOfferStore() {
        return offerStore;
    }

    /**
     * @param offerStore the offerStore to set
     */
    public void setOfferStore(Store offerStore) {
        this.offerStore = offerStore;
    }

    /**
     * @return the reqDate
     */
    public Date getReqDate() {
        return reqDate;
    }

    /**
     * @param reqDate the reqDate to set
     */
    public void setReqDate(Date reqDate) {
        this.reqDate = reqDate;
    }

    /**
     * @return the Number
     */
    public int getNumber() {
        return Number;
    }

    /**
     * @param Number the Number to set
     */
    public void setNumber(int Number) {
        this.Number = Number;
    }
    
    
}