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
 * レジ内金額 
 */
@Table(name="REGISTER_INFO")
@Entity
public class RegisterInfo implements Serializable{
    @Id
    @NotNull
    @Column(name = "register_code")
    private Register register;
    @NotNull
    @Column(name = "reg_date")
    private Date date;
    @NotNull
    @Column(name = "register_total_price")
    private int total;
    @NotNull
    @Column(name = "entry_people")
    private int Entry;

    /**
     * @return the register
     */
    public Register getRegister() {
        return register;
    }

    /**
     * @param register the register to set
     */
    public void setRegister(Register register) {
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
