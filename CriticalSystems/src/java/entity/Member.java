/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

/**
 * 会員
 */
@NamedQuery(name = "Member.MemberQAll" , query = "SELECT e FROM Member")
@Entity
public class Member implements Serializable {
    public static final String MemberQAll = "MemberQAll";
    @Id
    private String MemberCD;
    @NotNull
    private String MemberName;
    @NotNull
    private String MemberNameRuby;
    @NotNull
    private String Gender;
    @NotNull
    private Date MemberBirthday;
    @NotNull
    private int MemberAddNo;
    @NotNull
    private String MemberAddress;
    @NotNull
    private String MemberTel;
    private String MemberMail;
    @NotNull
    private String Merumaga;
    @NotNull
    private String AdmissionDate;
    @NotNull
    private String MemberStats;
    @NotNull
    private Job Job;

    /**
     * @return the MemberCD
     */
    public String getMemberCD() {
        return MemberCD;
    }

    /**
     * @param MemberCD the MemberCD to set
     */
    public void setMemberCD(String MemberCD) {
        this.MemberCD = MemberCD;
    }

    /**
     * @return the MemberName
     */
    public String getMemberName() {
        return MemberName;
    }

    /**
     * @param MemberName the MemberName to set
     */
    public void setMemberName(String MemberName) {
        this.MemberName = MemberName;
    }

    /**
     * @return the MemberNameRuby
     */
    public String getMemberNameRuby() {
        return MemberNameRuby;
    }

    /**
     * @param MemberNameRuby the MemberNameRuby to set
     */
    public void setMemberNameRuby(String MemberNameRuby) {
        this.MemberNameRuby = MemberNameRuby;
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
     * @return the MemberBirthday
     */
    public Date getMemberBirthday() {
        return MemberBirthday;
    }

    /**
     * @param MemberBirthday the MemberBirthday to set
     */
    public void setMemberBirthday(Date MemberBirthday) {
        this.MemberBirthday = MemberBirthday;
    }

    /**
     * @return the MemberAddNo
     */
    public int getMemberAddNo() {
        return MemberAddNo;
    }

    /**
     * @param MemberAddNo the MemberAddNo to set
     */
    public void setMemberAddNo(int MemberAddNo) {
        this.MemberAddNo = MemberAddNo;
    }

    /**
     * @return the MemberAddress
     */
    public String getMemberAddress() {
        return MemberAddress;
    }

    /**
     * @param MemberAddress the MemberAddress to set
     */
    public void setMemberAddress(String MemberAddress) {
        this.MemberAddress = MemberAddress;
    }

    /**
     * @return the MemberTel
     */
    public String getMemberTel() {
        return MemberTel;
    }

    /**
     * @param MemberTel the MemberTel to set
     */
    public void setMemberTel(String MemberTel) {
        this.MemberTel = MemberTel;
    }

    /**
     * @return the MemberMail
     */
    public String getMemberMail() {
        return MemberMail;
    }

    /**
     * @param MemberMail the MemberMail to set
     */
    public void setMemberMail(String MemberMail) {
        this.MemberMail = MemberMail;
    }

    /**
     * @return the Merumaga
     */
    public String getMerumaga() {
        return Merumaga;
    }

    /**
     * @param Merumaga the Merumaga to set
     */
    public void setMerumaga(String Merumaga) {
        this.Merumaga = Merumaga;
    }

    /**
     * @return the AdmissionDate
     */
    public String getAdmissionDate() {
        return AdmissionDate;
    }

    /**
     * @param AdmissionDate the AdmissionDate to set
     */
    public void setAdmissionDate(String AdmissionDate) {
        this.AdmissionDate = AdmissionDate;
    }

    /**
     * @return the MemberStats
     */
    public String getMemberStats() {
        return MemberStats;
    }

    /**
     * @param MemberStats the MemberStats to set
     */
    public void setMemberStats(String MemberStats) {
        this.MemberStats = MemberStats;
    }

    /**
     * @return the Job
     */
    public Job getJob() {
        return Job;
    }

    /**
     * @param Job the Job to set
     */
    public void setJob(Job Job) {
        this.Job = Job;
    }
    
    
    
}
