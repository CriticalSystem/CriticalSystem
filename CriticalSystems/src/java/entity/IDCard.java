/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 身分証
 */

@Entity
public class IDCard implements Serializable{
    @Id
    private String IDCardNo;    //身分証番号    
    private Member Member;      //会員
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
     * @return the Member
     */
    public Member getMember() {
        return Member;
    }

    /**
     * @param Member the Member to set
     */
    public void setMember(Member Member) {
        this.Member = Member;
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
