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
    @NotNull
    private String MemberCD;        //会員CD
    @NotNull
    private String Name;      //会員名
    @NotNull
    private String NameRuby;  //会員名カナ
    @NotNull
    private String Gender;          //性別
    @NotNull
    private Date Birthday;    //生年月日
    @NotNull
    private int PostalCD;     //郵便番号
    @NotNull
    private String Address;   //住所
    @NotNull
    private String Tel;       //電話番号
    private String Mail;      //メールアドレス
    @NotNull
    private String Magazine;        //メールマガジン
    @NotNull
    private String JoinDate;        //入会日
    @NotNull
    private String Stats;     //状態
    @NotNull
    private Job Job;                //職業
    private Discount Discount;      //割引CD

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
    public Date getBirthday() {
        return Birthday;
    }

    /**
     * @param Birthday the Birthday to set
     */
    public void setBirthday(Date Birthday) {
        this.Birthday = Birthday;
    }

    /**
     * @return the PostalCD
     */
    public int getPostalCD() {
        return PostalCD;
    }

    /**
     * @param PostalCD the PostalCD to set
     */
    public void setPostalCD(int PostalCD) {
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

    /**
     * @return the JoinDate
     */
    public String getJoinDate() {
        return JoinDate;
    }

    /**
     * @param JoinDate the JoinDate to set
     */
    public void setJoinDate(String JoinDate) {
        this.JoinDate = JoinDate;
    }

    /**
     * @return the Stats
     */
    public String getStats() {
        return Stats;
    }

    /**
     * @param Stats the Stats to set
     */
    public void setStats(String Stats) {
        this.Stats = Stats;
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

    /**
     * @return the Discount
     */
    public Discount getDiscount() {
        return Discount;
    }

    /**
     * @param Discount the Discount to set
     */
    public void setDiscount(Discount Discount) {
        this.Discount = Discount;
    }

    
    
}
