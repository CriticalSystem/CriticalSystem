package beans;

import db.IDCardDb;
import db.JobDb;
import db.MembersDb;
import db.TempMemberDb;
import entity.IDCard;
import entity.Job;
import entity.Members;
import entity.TempMember;
import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.*;
import org.primefaces.event.FlowEvent;
import util.CheckDegit;
import static util.DateUtil.DATE_PATTERN;

@Named
@ConversationScoped
public class MembersBean implements Serializable {

    private String temp_reg_code;
    private String member_code;
    private String name;
    private String name_ruby;
    private String sex;
    private String birthday;
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
    private String seifuri;
    private String meifuri;

    private String year;
    private String month;
    private String day;

    private String pos1;
    private String pos2;
    private String pos3;
    private String pos4;

    private String tel1;
    private String tel2;
    private String tel3;

    private String outIdentType;
    private String outsex;
    private String outjob;

    private Members mem = new Members();
    @EJB
    MembersDb membersdb;
    @EJB
    TempMemberDb tmemberdb;
    @EJB
    JobDb jobdb;
    @EJB
    IDCardDb idcarddb;

    @Inject
    transient Logger log;
    @Inject
    Conversation conv;

    @PostConstruct
    public void start() {
        log.info(log.getName() + " | 会員管理画面 ");
        if (!conv.isTransient()) {
            log.info(log.getName() + "｜会話スコープ終了");
            conv.end();
        }
    }

    public String create() {
        log.info(log.getName() + " | 会員登録画面 ");
        if (conv.isTransient()) {
            log.info(log.getName() + "｜会話スコープ開始");
            conv.begin();
        }
        return "register.xhtml";
    }

    public String Search() {
//        log.info(log.getName() + " | 会員検索画面 ");
        if (conv.isTransient()) {
            log.info(log.getName() + "｜会話スコープ開始");
            conv.begin();
        }
        return "memberSearch.xhtml";
    }

    public String delete(Members member) {	// 削除
        membersdb.delete(member);
        return "削除完了画面パス";
    }

    public String test() {
        if (conv.isTransient()) {
            conv.begin();
        }
        Members members = membersdb.find(member_code);

        setMember_code(members.getMembersCD());
        setName(members.getName());
        setAddress(members.getAddress());
        return "testt.xhtml";
    }

    /**
     *
     * 仮登録から情報を写す
     */
    public String next() {	// 仮登録から
        TempMember tmem = tmemberdb.find(temp_reg_code);
        String[] str = tmem.getName().split(" ", 2);
        setSei(str[0]);
        setMei(str[1]);
        str = tmem.getNameRuby().split(" ", 2);
        setSeifuri(str[0]);
        setMeifuri(str[1]);

        String a = tmem.getBirthday().toString();
        str = a.split("-", 3);
        year = str[0];
        month = Integer.toString(Integer.parseInt(str[1]));
        day = Integer.toString(Integer.parseInt(str[2]));

        str = tmem.getTel().split("-", 3);
        setTel1(str[0]);
        setTel2(str[1]);
        setTel3(str[2]);

        str = tmem.getAddress().split(" ", 4);
        setPostal_code(tmem.getPostalCD());
        setPos1(str[0]);
        setPos2(str[1]);
        setPos3(str[2]);
        setPos4(str[3]);
        setSex(tmem.getGender());

        setJob_code(tmem.getJob().getJobCD());

        setIs_magazine(tmem.getMagazine());
        setEmail(tmem.getMail());

        return null;
    }

    /**
     * 会員情報を参照する
     */
    public String reference() {	//参照
        setMem(membersdb.find(member_code));
        //名前
        String[] str = mem.getName().split(" ", 2);
        setSei(str[0]);
        setMei(str[1]);
        str = mem.getNameRuby().split(" ", 2);
        setSeifuri(str[0]);
        setMeifuri(str[1]);

        birthday = mem.getBirthday().toString();
        sex = mem.getSex();
        outputSex();
        tel_number = mem.getTel();

        str = mem.getAddress().split(" ", 4);
        setPostal_code(mem.getPostalCD());
        setPos1(str[0]);
        setPos2(str[1]);
        setPos3(str[2]);
        setPos4(str[3]);
        setSex(mem.getSex());

        setJob_code(mem.getJob().getJobCD());
        setOutjob(getJoblist().get(Integer.parseInt(job_code) - 1).getLabel());
        setIs_magazine(mem.getMagazine());
        setEmail(mem.getMail());

        IDCard idcard = idcarddb.getIDCard(member_code);
        setIdent_number(idcard.getIDCardNo());
        setIdent_type(idcard.getIDCardType());

        return null;
    }

    /**
     * 会員情報変更画面へ
     */
    public String update() {
        if (conv.isTransient()) {
            conv.begin();
        }
        setMem(membersdb.find(member_code));
        String[] str = mem.getName().split(" ", 2);
        setSei(str[0]);
        setMei(str[1]);
        str = mem.getNameRuby().split(" ", 2);
        setSeifuri(str[0]);
        setMeifuri(str[1]);

        String a = mem.getBirthday().toString();
        setBirthday(a);
        str = a.split("-", 3);
        year = str[0];
        month = Integer.toString(Integer.parseInt(str[1]));
        day = Integer.toString(Integer.parseInt(str[2]));

        sex = mem.getSex();
        outputSex();
        setTel_number(mem.getTel());
        str = mem.getTel().split("-", 3);
        setTel1(str[0]);
        setTel2(str[1]);
        setTel3(str[2]);

        str = mem.getAddress().split(" ", 4);
        setPostal_code(mem.getPostalCD());
        setPos1(str[0]);
        setPos2(str[1]);
        setPos3(str[2]);
        setPos4(str[3]);
        setSex(mem.getSex());

        setJob_code(mem.getJob().getJobCD());
        setOutjob(getJoblist().get(Integer.parseInt(job_code) - 1).getLabel());
        setIs_magazine(mem.getMagazine());
        setEmail(mem.getMail());

        IDCard idcard = idcarddb.getIDCard(member_code);
        setIdent_number(idcard.getIDCardNo());
        setIdent_type(idcard.getIDCardType());

        return "change.xhtml";
    }

    public void updateListener(ActionEvent event) {
        member_code  = (String) event.getComponent().getAttributes().get("membersCD");
    }
    

    /**
     * 会員情報変更確認画面へ
     */
    public String updateConfirm() {
        return "updateConfirm.xhtml";
    }
    
    public String updateBack() {
        return "change.xhtml";
    }
    
    public String execUpdate() {
        mem.setName(sei.concat(" ".concat(mei)));
        mem.setNameRuby(seifuri.concat(" ".concat(meifuri)));
        mem.setSex(sex);

        outputSex();

        setBirthday(birth(year, month, day));
        mem.setBirthday(Date.valueOf(getBirthday()));

        setTel_number(tel());
        mem.setTel(tel());

        mem.setPostalCD(postal_code);
        mem.setAddress(postal());

        Job j = new Job();
        j.setJobCD(job_code);
        j.setJobName(jobdb.find(job_code).getJobName());
        mem.setJob(j);
        setOutjob(getJoblist().get(Integer.parseInt(job_code) - 1).getLabel());

        mem.setMail(email);
        mem.setMagazine(is_magazine);

        IDCard idcard = new IDCard();
        idcard.setMembers(mem);
        idcard.setIDCardNo(ident_number);
        idcard.setIDCardType(ident_type);
        outputIdentType();
        try {
            membersdb.update(mem);
            idcarddb.update(idcard);
        } catch (Exception e) {
            if (e.getCause() instanceof ConstraintViolationException) {
                ConstraintViolationException cve = (ConstraintViolationException) e.getCause();
                for (ConstraintViolation cv : cve.getConstraintViolations()) {
                    System.out.println("CONSTRAINT VIOLOATION : " + cv.toString());
                }
                log.fine("■" + log.getName() + "|" + e.getMessage());
            }
        }
        conv.end();
        return "updateComp.xhtml";
    }

    /**
     * 会員情報確認画面に遷移する
     *
     * @return
     */
    public String confirm() {
        if (conv.isTransient()) {
            conv.begin();
        }
//      log.info(log.getName() + " | 会員登録　確認画面");
        mem = new Members();
        mem.setName(sei.concat(" ".concat(mei)));
        mem.setNameRuby(seifuri.concat(" ".concat(meifuri)));
        mem.setSex(sex);
        outputSex();

        setBirthday(birth(year, month, day));
        mem.setBirthday(Date.valueOf(getBirthday()));

        setTel_number(tel());
        mem.setTel(tel());

        mem.setPostalCD(postal_code);
        mem.setAddress(postal());

        Job j = new Job();
        j.setJobCD(job_code);
        j.setJobName(jobdb.find(job_code).getJobName());
        mem.setJob(j);
        setOutjob(getJoblist().get(Integer.parseInt(job_code) - 1).getLabel());

        mem.setMail(email);
        mem.setMagazine(is_magazine);

        mem.setStats("通常");

        outputIdentType();
        return "memberConfirm.xhtml";
    }

    /**
     * 会員登録処理
     */
    public String execCreate() {
//        log.info(log.getName() + " | 会員登録処理");
        //会員番号取得
        Members m = membersdb.getMaxCode().get(0);

        String str = m.getMembersCD().substring(0, m.getMembersCD().length() - 1);
        str = String.format("%07d", (Integer.parseInt(str) + 1));

        member_code = CheckDegit.Check(str);

        mem.setMembersCD(member_code);

        Calendar cal = Calendar.getInstance();
        str = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        mem.setJoinDate(str);

        IDCard idcard = new IDCard();
        idcard.setMembers(mem);
        idcard.setIDCardNo(ident_number);
        idcard.setIDCardType(ident_type);

        try {
            membersdb.create(mem);
            idcarddb.create(idcard);
        } catch (Exception e) {
            if (e.getCause() instanceof ConstraintViolationException) {
                ConstraintViolationException cve = (ConstraintViolationException) e.getCause();
                for (ConstraintViolation cv : cve.getConstraintViolations()) {
                    System.out.println("CONSTRAINT VIOLOATION : " + cv.toString());
                }
                log.fine("■" + log.getName() + "|" + e.getMessage());
            }
        }
//        log.info(log.getName() + " | 会員登録正常終了");
        conv.end();
        return "memberComplete.xhtml";
    }

    public String back() {
        return "register.xhtml";
    }

    public List<SelectItem> getYearlist() {
        ArrayList<SelectItem> items = new ArrayList<>();
        Calendar d = Calendar.getInstance();
        int y = d.get(Calendar.YEAR);
        for (int i = 1900; i <= y; i++) {
            items.add(new SelectItem(Integer.toString(i), Integer.toString(i)));
        }
        return items;
    }

    public List<SelectItem> getMonthlist() {
        ArrayList<SelectItem> items = new ArrayList<>();
        Calendar d = Calendar.getInstance();
        int y = d.get(Calendar.MONTH);
        for (int i = 0; i <= 11; i++) {
            items.add(new SelectItem(Integer.toString(i + 1), Integer.toString(i + 1)));
        }
        return items;
    }

    public List<SelectItem> getDaylist() {
        ArrayList<SelectItem> items = new ArrayList<>();
        Calendar d = Calendar.getInstance();
        int y = d.get(Calendar.DATE);
        for (int i = 1; i <= 31; i++) {
            items.add(new SelectItem(Integer.toString(i), Integer.toString(i)));
        }
        return items;
    }

    public List<SelectItem> getJoblist() {
        ArrayList<SelectItem> items = new ArrayList<>();
        items.add(new SelectItem(1, "会社員・公務員"));
        items.add(new SelectItem(2, "派遣・アルバイト"));
        items.add(new SelectItem(3, "自営業"));
        items.add(new SelectItem(4, "専業主婦"));
        items.add(new SelectItem(5, "学生"));
        items.add(new SelectItem(6, "その他"));
        return items;
    }

    public String getOutjob() {
        return outjob;
    }

    public String birth(String year, String month, String day) {
        String a;

        a = this.year.concat("-");
        a = a.concat(this.month).concat("-");
        a = a.concat(this.day);
        return a;
    }

    /**
     * 入力された電話番号をくっつける
     *
     * @return
     */
    public String tel() {
        String a;
        a = tel1.concat("-");
        a = a.concat(tel2).concat("-");
        a = a.concat(tel3);
        return a;
    }

    /**
     * 入力された住所をくっつける
     *
     * @return
     */
    public String postal() {
        String a;
        a = pos1.concat(" ");
        a = a.concat(pos2).concat(" ");
        a = a.concat(pos3).concat(" ");
        if (!(pos4.isEmpty())) {
            a = a.concat(pos4);
        }
        return a;
    }

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
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(String birthday) {
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
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return the month
     */
    public String getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * @return the day
     */
    public String getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(String day) {
        this.day = day;
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

    /**
     * @return the pos1
     */
    public String getPos1() {
        return pos1;
    }

    /**
     * @param pos1 the pos1 to set
     */
    public void setPos1(String pos1) {
        this.pos1 = pos1;
    }

    /**
     * @return the pos2
     */
    public String getPos2() {
        return pos2;
    }

    /**
     * @param pos2 the pos2 to set
     */
    public void setPos2(String pos2) {
        this.pos2 = pos2;
    }

    /**
     * @return the pos3
     */
    public String getPos3() {
        return pos3;
    }

    /**
     * @param pos3 the pos3 to set
     */
    public void setPos3(String pos3) {
        this.pos3 = pos3;
    }

    /**
     * @return the pos4
     */
    public String getPos4() {
        return pos4;
    }

    /**
     * @param pos4 the pos4 to set
     */
    public void setPos4(String pos4) {
        this.pos4 = pos4;
    }

    /**
     * @return the seifuri
     */
    public String getSeifuri() {
        return seifuri;
    }

    /**
     * @param seifuri the seifuri to set
     */
    public void setSeifuri(String seifuri) {
        this.seifuri = seifuri;
    }

    /**
     * @return the meifuri
     */
    public String getMeifuri() {
        return meifuri;
    }

    /**
     * @param meifuri the meifuri to set
     */
    public void setMeifuri(String meifuri) {
        this.meifuri = meifuri;
    }

    public void outputSex() {
        if (this.sex.equals("1")) {
            setOutsex("男");
        } else {
            setOutsex("女");
        }
    }

    /**
     * 身分証区分を数字から文字に変換する
     */
    public void outputIdentType() {
        if (this.ident_type.equals("1")) {
            setOutIdentType("免許証");
        } else if (this.ident_type.equals("2")) {
            setOutIdentType("保険証");
        } else if (this.ident_type.equals("3")) {
            setOutIdentType("学生証");
        }
    }

    /**
     * @return the outsex
     */
    public String getOutsex() {
        return outsex;
    }

    /**
     * @param outsex the outsex to set
     */
    public void setOutsex(String outsex) {
        this.outsex = outsex;
    }

    /**
     * @return the outIdentType
     */
    public String getOutIdentType() {
        return outIdentType;
    }

    /**
     * @param outIdentType the outIdentType to set
     */
    public void setOutIdentType(String outIdentType) {
        this.outIdentType = outIdentType;
    }

    /**
     * @param outjob the outjob to set
     */
    public void setOutjob(String outjob) {
        this.outjob = outjob;
    }

    /**
     * @return the mem
     */
    public Members getMem() {
        return mem;
    }

    /**
     * @param mem the mem to set
     */
    public void setMem(Members mem) {
        this.mem = mem;
    }

}
