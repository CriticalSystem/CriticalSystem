/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import static com.sun.xml.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
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
    private int serial;       //連番
    @NotNull
    @ManyToOne
    @JoinColumn(name = "slip_number")
    private Receipt slip_number;
    @NotNull
    @Column(name = "No")
    private int No;
    @NotNull
    @OneToOne
    @JoinColumn(name = "disc_code")
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
    private int price;          //料金



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

}
