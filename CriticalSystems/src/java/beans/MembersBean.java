package beans;

import db.MembersDb;
import db.TempMemberDb;
import entity.Members;
import entity.TempMember;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.*;

@Named
@ConversationScoped
public class MembersBean implements Serializable {
    
    private String temp_reg_code;
    private String member_code;
    private String name;
    private String name_ruby;
    private String sex;
    private Date birthday;
    private String postal_code;
    private String address;
    private String tel_number;
    private String email;
    private String is_magazine;
    private Date join_date;
    private Date defect_date;
    private String member_state;
    private String job_code;
    private String discount_number;
    private List<Members> membersList;
    
    private String ident_number;
    private String ident_type;
    //入力用変数
    private String sei;
    private String mei;
    
    private int year;
    private int month;
    private int day;
    
    private String postal1;
    private String postal2;
    
    private String tel1;
    private String tel2;
    private String tel3;
    
    @EJB
    MembersDb membersdb;
    @EJB
    TempMemberDb tmemberdb;
    
    @Inject
    transient Logger log;
    
    @Inject
    Conversation conv;

    @PostConstruct
    public void start(){
        if(!conv.isTransient()){
            log.info(log.getName() + "｜会話スコープ終了");
            conv.end();
        }
    }
    
    public String create() {
        log.info(log.getName() + " | イベント登録画面 ");
        if(conv.isTransient()) {
            conv.begin();
        }
        return "/pages/member/create.xhtml";
    }
    
    public String confirm() {
        log.info(log.getName() + " | イベント登録確認画面");
        return "confirm.xhtml";
    }

    public String delete(Members member) {	// 削除
        membersdb.delete(member);
        return "削除完了画面パス";
    }
    
    public String test() {
        if(conv.isTransient()) {
            conv.begin();
        }
        Members members = membersdb.find(member_code);
        
        setMember_code(members.getMembersCD());
        setName(members.getName());
        setAddress(members.getAddress());
        return "testt.xhtml";
    }
    
     public String next() {	// 削除
	
	TempMember tmem =  tmemberdb.find(temp_reg_code);
	setSei(tmem.getName());
	setAddress(tmem.getAddress());
	setSex(tmem.getGender());
	
	return null;
    }
    
//    public String execCreate() {t
//        log.info(log.getName() + " | イベント登録処理");
//        Members members = new Members(member_code);// 新規登録
//        try {
//            membersDb.create(members);
//            membersList = membersDb.find(members_code);
//        } catch (Exception e) {
//            log.fine("■" + log.getName() + "|" + e.getMessage());
//        }
//        log.info(log.getName() + " | 会話スコープ終了");
//        conv.end();
//        return "complete.xhtml";
//    }
    
//    public String execCreate() {
//        log.info(log.getName() + " | イベント登録処理");
//        Members member = new Members();
//        try {
//            membersdb.create(member);
//            membersList = membersdb.find(member_code);
//        } catch (Exception e) {
//            log.fine("■" + log.getName() + "|" + e.getMessage());
//        }
//        log.info(log.getName() + " | 会話スコープ終了");
//        conv.end();
//        return "complete.xhtml";
//    }

    public void clear() {	// 変数をクリア
        member_code = null;
    }

    /**
     * @return the member_code
     */
    public String getMember_code() {
        return member_code;
    }

    /**
     * @param member_code the member_code to set
     */
    public void setMember_code(String member_code) {
        this.member_code = member_code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the name_ruby
     */
    public String getName_ruby() {
        return name_ruby;
    }

    /**
     * @param name_ruby the name_ruby to set
     */
    public void setName_ruby(String name_ruby) {
        this.name_ruby = name_ruby;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the postal_code
     */
    public String getPostal_code() {
        return postal_code;
    }

    /**
     * @param postal_code the postal_code to set
     */
    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the tel_number
     */
    public String getTel_number() {
        return tel_number;
    }

    /**
     * @param tel_number the tel_number to set
     */
    public void setTel_number(String tel_number) {
        this.tel_number = tel_number;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the is_magazine
     */
    public String getIs_magazine() {
        return is_magazine;
    }

    /**
     * @param is_magazine the is_magazine to set
     */
    public void setIs_magazine(String is_magazine) {
        this.is_magazine = is_magazine;
    }

    /**
     * @return the join_date
     */
    public Date getJoin_date() {
        return join_date;
    }

    /**
     * @param join_date the join_date to set
     */
    public void setJoin_date(Date join_date) {
        this.join_date = join_date;
    }

    /**
     * @return the defect_date
     */
    public Date getDefect_date() {
        return defect_date;
    }

    /**
     * @param defect_date the defect_date to set
     */
    public void setDefect_date(Date defect_date) {
        this.defect_date = defect_date;
    }

    /**
     * @return the member_state
     */
    public String getMember_state() {
        return member_state;
    }

    /**
     * @param member_state the member_state to set
     */
    public void setMember_state(String member_state) {
        this.member_state = member_state;
    }

    /**
     * @return the job_code
     */
    public String getJob_code() {
        return job_code;
    }

    /**
     * @param job_code the job_code to set
     */
    public void setJob_code(String job_code) {
        this.job_code = job_code;
    }

    /**
     * @return the discount_number
     */
    public String getDiscount_number() {
        return discount_number;
    }

    /**
     * @param discount_number the discount_number to set
     */
    public void setDiscount_number(String discount_number) {
        this.discount_number = discount_number;
    }

    /**
     * @return the memberList
     */
    public List<Members> getMembersList() {
        return membersList;
    }

    /**
     * @param membersList the membersList to set
     */
    public void setMemberList(List<Members> membersList) {
        this.membersList = membersList;
    }

    public MembersDb getMemberDb() {
        return membersdb;
    }

    public void setMemberDB(MembersDb membersdb) {
        this.membersdb = membersdb;
    }

    public Logger getLog() {
        return log;
    }

    public void setLog(Logger log) {
        this.log = log;
    }

    public Conversation getConv() {
        return conv;
    }

    public void setConv(Conversation conv) {
        this.conv = conv;
    }

    /**
     * @return the sei
     */
    public String getSei() {
        return sei;
    }

    /**
     * @param sei the sei to set
     */
    public void setSei(String sei) {
        this.sei = sei;
    }

    /**
     * @return the mei
     */
    public String getMei() {
        return mei;
    }

    /**
     * @param mei the mei to set
     */
    public void setMei(String mei) {
        this.mei = mei;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * @return the day
     */
    public int getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * @return the postal1
     */
    public String getPostal1() {
        return postal1;
    }

    /**
     * @param postal1 the postal1 to set
     */
    public void setPostal1(String postal1) {
        this.postal1 = postal1;
    }

    /**
     * @return the postal2
     */
    public String getPostal2() {
        return postal2;
    }

    /**
     * @param postal2 the postal2 to set
     */
    public void setPostal2(String postal2) {
        this.postal2 = postal2;
    }

    /**
     * @return the tel1
     */
    public String getTel1() {
        return tel1;
    }

    /**
     * @param tel1 the tel1 to set
     */
    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    /**
     * @return the tel2
     */
    public String getTel2() {
        return tel2;
    }

    /**
     * @param tel2 the tel2 to set
     */
    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    /**
     * @return the tel3
     */
    public String getTel3() {
        return tel3;
    }

    /**
     * @param tel3 the tel3 to set
     */
    public void setTel3(String tel3) {
        this.tel3 = tel3;
    }

    /**
     * @return the ident_number
     */
    public String getIdent_number() {
        return ident_number;
    }

    /**
     * @param ident_number the ident_number to set
     */
    public void setIdent_number(String ident_number) {
        this.ident_number = ident_number;
    }

    /**
     * @return the ident_type
     */
    public String getIdent_type() {
        return ident_type;
    }

    /**
     * @param ident_type the ident_type to set
     */
    public void setIdent_type(String ident_type) {
        this.ident_type = ident_type;
    }

    /**
     * @return the temp_reg_number
     */
    public String getTemp_reg_code() {
        return temp_reg_code;
    }

    /**
     * @param temp_reg_code the temp_reg_code to set
     */
    public void setTemp_reg_code(String temp_reg_code) {
        this.temp_reg_code = temp_reg_code;
    }
}