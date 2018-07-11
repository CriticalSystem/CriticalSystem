/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author s20163048
 * 貸出明細
 */
@Entity
@Table(name="RECEIPT_DETAILS")
public class ReceiptDetails implements Serializable{
    
    @EmbeddedId
    @NotNull
    @Column(name = "")
    private PK DetailsPK;       //伝票
    @NotNull
    @Column(name = "disc_code")
    private Disc disc;          //ディスク
    @Column(name = "return_date")
    private Date returnDate;    //返却日
    @NotNull
    @Column(name = "due_date")
    private Date dueDate;       //返却予定日
    @Column(name = "late_fees")
    private int lateFees;       //延滞料
    @NotNull
    @Column(name = "price")
    private int price;            //料金

    /**
     * @return the DetailsPK
     */
    public PK getDetailsPK() {
        return DetailsPK;
    }

    /**
     * @param DetailsPK the DetailsPK to set
     */
    public void setDetailsPK(PK DetailsPK) {
        this.DetailsPK = DetailsPK;
    }

    /**
     * @return the disc
     */
    public Disc getDisc() {
        return disc;
    }

    /**
     * @param disc the disc to set
     */
    public void setDisc(Disc disc) {
        this.disc = disc;
    }

    /**
     * @return the returnDate
     */
    public Date getReturnDate() {
        return returnDate;
    }

    /**
     * @param returnDate the returnDate to set
     */
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * @return the dueDate
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * @return the lateFees
     */
    public int getLateFees() {
        return lateFees;
    }

    /**
     * @param lateFees the lateFees to set
     */
    public void setLateFees(int lateFees) {
        this.lateFees = lateFees;
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
     * 主キー用のクラス
     */
    private static class PK {
        @Column(name = "slip_number")
        private Receipt receipt;
        @Column(name = "details_number")
        private int No;
        
        public PK(Receipt receipt , int No){
            this.setReceipt(receipt);
            this.setNo(No);
        }
        /**
         * @return the receipt
         */
        public Receipt getReceipt() {
            return receipt;
        }

        /**
         * @param receipt the receipt to set
         */
        public void setReceipt(Receipt receipt) {
            this.receipt = receipt;
        }

        /**
         * @return the No
         */
        public int getNo() {
            return No;
        }

        /**
         * @param No the No to set
         */
        public void setNo(int No) {
            this.No = No;
        }
        
    }
    
}
