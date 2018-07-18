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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 身分証
 */

@Entity
@Table(name="IDCARD")
public class IDCard implements Serializable{
    @Id
    @NotNull
    @Column(name = "ident_number")
    private String IDCardNo;    //身分証番号    
    @NotNull
    @Column(name = "member_code")
    private Members Members;      //会員
    @NotNull
    @Column(name = "ident_type")
    private String IDCardType;  //身分証分類

    /**
     * @return the IDCardNo
     */
    public String getIDCardNo() {
        return IDCardNo;
    }

    /**
     * @param IDCardNo the IDCardNo to set
     */
    public void setIDCardNo(String IDCardNo) {
        this.IDCardNo = IDCardNo;
    }

    /**
     * @return the Members
     */
    public Members getMembers() {
        return Members;
    }

    /**
     * @param Members the Members to set
     */
    public void setMembers(Members Members) {
        this.Members = Members;
    }

    /**
     * @return the IDCardType
     */
    public String getIDCardType() {
        return IDCardType;
    }

    /**
     * @param IDCardType the IDCardType to set
     */
    public void setIDCardType(String IDCardType) {
        this.IDCardType = IDCardType;
    }
                    
}
