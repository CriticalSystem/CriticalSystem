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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 貸出明細
 */
@Entity
@Table(name="RECEIPT_DETAILS")
public class ReceiptDetails implements Serializable{
    
    @Id
    @NotNull
    @Column(name = "serial_number")
    private int serial_number;       //連番
    @NotNull
    @Column(name = "slip_number")
    private String slip_number;
    @NotNull
    @Column(name = "disc_code")
    private String disc_code;          //ディスク
    @Column(name = "return_date")
    private Date return_date;    //返却日
    @NotNull
    @Column(name = "due_date")
    private String due_date;       //返却予定日
    @Column(name = "late_fees")
    private int late_fees;       //延滞料
    @NotNull
    @Column(name = "price")
    private int price;          //料金

    /**
     * @return the serial_number
     */
    public int getSerial_number() {
        return serial_number;
    }

    /**
     * @param serial_number the serial_number to set
     */
    public void setSerial_number(int serial_number) {
        this.serial_number = serial_number;
    }
    /**
     * @return the return_date
     */
    public Date getReturn_date() {
        return return_date;
    }

    /**
     * @param return_date the return_date to set
     */
    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }
    /**
     * @return the late_fees
     */
    public int getLate_fees() {
        return late_fees;
    }

    /**
     * @param late_fees the late_fees to set
     */
    public void setLate_fees(int late_fees) {
        this.late_fees = late_fees;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the disc_code
     */
    public String getDisc_code() {
        return disc_code;
    }

    /**
     * @param disc_code the disc_code to set
     */
    public void setDisc_code(String disc_code) {
        this.disc_code = disc_code;
    }

    /**
     * @return the slip_number
     */
    public String getSlip_number() {
        return slip_number;
    }

    /**
     * @param slip_number the slip_number to set
     */
    public void setSlip_number(String slip_number) {
        this.slip_number = slip_number;
    }

    /**
     * @return the due_date
     */
    public String getDue_date() {
        return due_date;
    }

    /**
     * @param due_date the due_date to set
     */
    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }
    
}
