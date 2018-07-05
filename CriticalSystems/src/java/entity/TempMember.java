/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author s20163048
 */
@Entity
public class TempMember implements Serializable{
    @Id
    @NotNull
    private String tempMemNo;
    @NotNull
    private Date tempRegDate;
    @NotNull
    private String Name;
    @NotNull
    private String NameRuby;
    @NotNull
    private String Gender;
    @NotNull
    private String Birthday;
    @NotNull
    private String PostalCD;
    @NotNull
    private String Address;
    @NotNull
    private String Tel;
    private String Mail;
    @NotNull
    private String Job;
    @NotNull
    private String Magazine;

    /**
     * @return the tempMemNo
     */
    public String getTempMemNo() {
        return tempMemNo;
    }

    /**
     * @param tempMemNo the tempMemNo to set
     */
    public void setTempMemNo(String tempMemNo) {
        this.tempMemNo = tempMemNo;
    }

    /**
     * @return the tempRegDate
     */
    public Date getTempRegDate() {
        return tempRegDate;
    }

    /**
     * @param tempRegDate the tempRegDate to set
     */
    public void setTempRegDate(Date tempRegDate) {
        this.tempRegDate = tempRegDate;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the NameRuby
     */
    public String getNameRuby() {
        return NameRuby;
    }

    /**
     * @param NameRuby the NameRuby to set
     */
    public void setNameRuby(String NameRuby) {
        this.NameRuby = NameRuby;
    }

    /**
     * @return the Gender
     */
    public String getGender() {
        return Gender;
    }

    /**
     * @param Gender the Gender to set
     */
    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    /**
     * @return the Birthday
     */
    public String getBirthday() {
        return Birthday;
    }

    /**
     * @param Birthday the Birthday to set
     */
    public void setBirthday(String Birthday) {
        this.Birthday = Birthday;
    }

    /**
     * @return the PostalCD
     */
    public String getPostalCD() {
        return PostalCD;
    }

    /**
     * @param PostalCD the PostalCD to set
     */
    public void setPostalCD(String PostalCD) {
        this.PostalCD = PostalCD;
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the Tel
     */
    public String getTel() {
        return Tel;
    }

    /**
     * @param Tel the Tel to set
     */
    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    /**
     * @return the Mail
     */
    public String getMail() {
        return Mail;
    }

    /**
     * @param Mail the Mail to set
     */
    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    /**
     * @return the Job
     */
    public String getJob() {
        return Job;
    }

    /**
     * @param Job the Job to set
     */
    public void setJob(String Job) {
        this.Job = Job;
    }

    /**
     * @return the Magazine
     */
    public String getMagazine() {
        return Magazine;
    }

    /**
     * @param Magazine the Magazine to set
     */
    public void setMagazine(String Magazine) {
        this.Magazine = Magazine;
    }

    
}
