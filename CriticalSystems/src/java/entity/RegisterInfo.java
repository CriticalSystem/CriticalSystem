/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * レジ内金額 
 */
public class RegisterInfo {
    @Id
    @NotNull
    private CashRegister register;
    @NotNull
    private Date date;
    @NotNull
    private int total;
    @NotNull
    private int Entry;

    /**
     * @return the register
     */
    public CashRegister getRegister() {
        return register;
    }

    /**
     * @param register the register to set
     */
    public void setRegister(CashRegister register) {
        this.register = register;
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
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * @return the Entry
     */
    public int getEntry() {
        return Entry;
    }

    /**
     * @param Entry the Entry to set
     */
    public void setEntry(int Entry) {
        this.Entry = Entry;
    }
    
    
}
