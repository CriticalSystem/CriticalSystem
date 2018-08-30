/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 会員
 */
@NamedQueries({
    @NamedQuery(name = Members.MembersQAll, query = "SELECT m FROM Members m"),
//    @NamedQuery(name = Members.MembersQCode, query = "SELECT m FROM Members m WHERE name LIKE '%'| ?1 |'%';")
    @NamedQuery(name = Members.MembersQMaxCode, query = "SELECT m FROM Members m WHERE m.MembersCD = (SELECT MAX(m.MembersCD) FROM Members m)")
})
@Entity
@Table(name = "MEMBERS")
public class Members implements Serializable {

    public static final String MembersQAll = "MembersQAll";
    public static final String MembersQCode = "MembersQCode";
    public static final String MembersQMaxCode = "MembersQMaxCode";
    @Id
    @NotNull
    @Column(name = "members_code")
    private String MembersCD;        //会員CD
    @NotNull
    @Column(name = "name")
    private String Name;      //会員名
    @NotNull
    @Column(name = "name_ruby")
    private String NameRuby;  //会員名カナ
    @NotNull
    @Column(name = "sex")
    private String Sex;          //性別
    @NotNull
    @Column(name = "birthday")
    private Date Birthday;    //生年月日
    @NotNull
    @Column(name = "postal_code")
    private String PostalCD;     //郵便番号
    @NotNull
    @Column(name = "address")
    private String Address;   //住所
    @NotNull
    @Column(name = "tel_number")
    private String Tel;       //電話番号
    @Column(name = "email")
    private String Mail;      //メールアドレス
    @NotNull
    @Column(name = "is_magazine")
    private String Magazine;        //メールマガジン
    @NotNull
    @Column(name = "join_date")
    private String JoinDate;  //入会日
    @Column(name = "defect_date")
    private String DefectDate;
    @NotNull
    @Column(name = "members_state")
    private String Stats;     //状態
    @NotNull
    @ManyToOne
    @JoinColumn(name = "job_code")
    private Job Job;                //職業
    @OneToOne
    @JoinColumn(name = "discount_number")
    private Discount Discount;      //割引CD
    
    /**
     * @return the MembersCD
     */
    public Members() {
    }

    /**
     * @return the MembersCD
     */
    public String getMembersCD() {
        return MembersCD;
    }

    /**
     * @param MembersCD the MembersCD to set
     */
    public void setMembersCD(String MembersCD) {
        this.MembersCD = MembersCD;
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
     * @return the Sex
     */
    public String getSex() {
        return Sex;
    }

    /**
     * @param Sex the Sex to set
     */
    public void setSex(String Sex) {
        this.Sex = Sex;
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

    /**
     * @return the DefectDate
     */
    public String getDefectDate() {
        return DefectDate;
    }

    /**
     * @param DefectDate the DefectDate to set
     */
    public void setDefectDate(String DefectDate) {
        this.DefectDate = DefectDate;
    }
    
    public String getSei() {
        return this.Name.split(" ", 2)[0];
    }
    
    public String getMei() {
        return this.Name.split(" ", 2)[1];
    }
    
    
    
}
