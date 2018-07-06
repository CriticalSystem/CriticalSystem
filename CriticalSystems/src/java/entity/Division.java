/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 区分
 */
@Entity
@Table(name="DIVISION")
public class Division implements Serializable{
    @Id
    @NotNull
    private String div_code;    //区分CD
    @NotNull
    private String div_name;    //区分名

    /**
     * @return the div_code
     */
    public String getDiv_code() {
        return div_code;
    }

    /**
     * @param div_code the div_code to set
     */
    public void setDiv_code(String div_code) {
        this.div_code = div_code;
    }

    /**
     * @return the div_name
     */
    public String getDiv_name() {
        return div_name;
    }

    /**
     * @param div_name the div_name to set
     */
    public void setDiv_name(String div_name) {
        this.div_name = div_name;
    }
    
    
}
