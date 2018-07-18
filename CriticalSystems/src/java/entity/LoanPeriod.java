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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 貸出期間
 */
@Entity
@Table(name="LOAN_PERIOD")
public class LoanPeriod implements Serializable{
    @Id
    @NotNull
    @JoinColumn(name = "serial_number")
    private String serial;
    @NotNull
    @JoinColumn(name = "div_code")
    private Division div;
    @NotNull
    @Column(name = "loan_date")
    private int loanDate;
    @NotNull
    @Column(name = "price")
    private int price;

    /**
     * @return the div
     */
    public Division getDiv() {
        return div;
    }

    /**
     * @param div the div to set
     */
    public void setDiv(Division div) {
        this.div = div;
    }

    /**
     * @return the loanDate
     */
    public int getLoanDate() {
        return loanDate;
    }

    /**
     * @param loanDate the loanDate to set
     */
    public void setLoanDate(int loanDate) {
        this.loanDate = loanDate;
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
