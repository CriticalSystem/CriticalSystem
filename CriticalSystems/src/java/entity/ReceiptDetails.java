/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 *
 * @author s20163048
 * 貸出明細
 */
@Entity
public class ReceiptDetails implements Serializable{
    
    @EmbeddedId
    private PK DetailsPK;
    private Disc disc;
    private Date returnDate;
    private Date dueDate;
    private int lateFees;
    private int fee;

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
     * @return the fee
     */
    public int getFee() {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee(int fee) {
        this.fee = fee;
    }
   
    /**
     * 主キー用のクラス
     */
    private static class PK {
        private Receipt receipt;
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
