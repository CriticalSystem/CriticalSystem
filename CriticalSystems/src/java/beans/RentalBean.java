/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.DiscDb;
import db.MembersDb;
import db.ReceiptDb;
import db.TitleDb;
import entity.Disc;
import entity.Members;
import entity.Receipt;
import entity.ReceiptDetails;
import entity.Title;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author s20163045
 */
@Named
@ConversationScoped
public class RentalBean implements Serializable{
    
    //会員情報
    private String member_code;     //会員番号
    private String name;            //名前
    private Date birthday;          //誕生日
    private Date join_date;         //入会日
    private Date defect_date;       //退会日
    private String member_state;    //会員状態
    private String discount_number; //割引番号
    private long age;             //年齢
    //ディスク情報
    private String disc_code;       //ディスク番号
    private Date arrival_date;      //入荷日
    private String is_disposal;     //廃棄フラグ
    private String is_lend;         //貸出フラグ
    private String media;           //媒体
    private String rack;            //棚番号
    private String div_code;        //種類
    private String title_code;      //タイトル番号
    private String title_name;      //タイトル名
    private List<Disc> disclist = new ArrayList<>();
    private int cnt;
    //レシート情報
    private Receipt receipt;
    private String slip_number;     //レシート番号
////    private String members_code;    //会員番号
//    private String employees_code;  //店員番号
//    private String store_code;      //店舗番号
//    private Date lend_date;         //貸出日
//    private int total_price;     //合計金額
//    private String is_discount;     //割引フラグ
    //レシート明細情報
//    private String slip_number;   //レシート番号
    private String serial_number;  //明細番号
//    private String disc_code;     //ディスク番号
    private Date return_date;       //返却日
    private Date return_plan_date;  //返却予定日
    private String late_price;      //延滞料金
    private List<ReceiptDetails> receiptminlist = new ArrayList<>();
    private int subtotal;           //小計
    private int azukari;            //預かり金
    private int oturi;             //おつり
    private List<String> list = new ArrayList<>();
    
    @EJB
    ReceiptDb receiptdb;
    @EJB
    MembersDb membersdb;
    @EJB
    DiscDb discdb;
    @EJB
    TitleDb titledb;
    
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

//    public String delete(Members member) {	// 削除
//        membersdb.delete(member);
//        return "削除完了画面パス";
//    }
//    
    
    public String memberget() {
        if(conv.isTransient()) {
            conv.begin();
        }
        Members members = membersdb.find(member_code);
        
        setMember_code(members.getMembersCD());
        setName(members.getName());
        setBirthday(members.getBirthday());
        setMember_state(members.getStats());
        Date now = new Date();
        setAge(calcAge(birthday,now));
        return "rental2.xhtml";
    }
    
    public String gettitle(String title_code) {
        if(conv.isTransient()) {
            conv.begin();
        }
        log.info("text");
        Title title = titledb.find(title_code);
        log.info(title.getTitle_Name());
        setName(title.getTitle_Name());
        return getTitle_name();
    }
    
    public String discadd() {
        if(conv.isTransient()) {
            conv.begin();
        }
        Disc disc = discdb.find(disc_code);
        disclist.add(disc);
        getList().add(disc_code);
        cnt = disclist.size();        
//        ReceiptDetails receiptmin = new ReceiptDetails();
//        log.info("1");
//        receiptmin.setDisc_code(disc_code);
//        log.info("2");
//        receiptmin.setSerial_number(cnt);
//        log.info("3");
//        receiptminlist.add(receiptmin);
//        log.info("4");
        return null;
    }
    
    public static int calcAge(Date birthday, Date now) {
        int age = now.getYear() - birthday.getYear();
        if (now.getMonth() < birthday.getMonth()) {
            age--;
        } else if (now.getMonth() == birthday.getMonth()) {
            if (now.getDay() < birthday.getDay()) {
                age--;
            }
        }
        return age;
    }
    
    
//    public String execCreate() {
//        log.info(log.getName() + " | イベント登録処理");
//        slip_number = CreateSlipNumber();
//        receipt= new Receipt(slip_number);
//        String store_code = "102";
//        int total_price = 780;
////        receipt.setStore_code(store_code);
//        receipt.setTotal_price(total_price);
//        receipt.setMembers_code(member_code);
//        try {
//            receiptdb.create(receipt);
//        } catch (Exception e) {
//            log.fine("■" + log.getName() + "|" + e.getMessage());
//        }
//        log.info(log.getName() + " | 会話スコープ終了");
//        conv.end();
//        return "rental1.xhtml";
//    }
    
    public String CreateSlipNumber(){
        slip_number = "1234567890";
        return slip_number;
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
     * @return the disc_code
     */
    public String getDisc_code() {
        return disc_code;
    }

    /**
     * @param disc_code the disc_code to set
     */
    public void setDisc_code(String disc_code) {
        this.disc_code = disc_code;
    }

    /**
     * @return the arrival_date
     */
    public Date getArrival_date() {
        return arrival_date;
    }

    /**
     * @param arrival_date the arrival_date to set
     */
    public void setArrival_date(Date arrival_date) {
        this.arrival_date = arrival_date;
    }

    /**
     * @return the is_disposal
     */
    public String getIs_disposal() {
        return is_disposal;
    }

    /**
     * @param is_disposal the is_disposal to set
     */
    public void setIs_disposal(String is_disposal) {
        this.is_disposal = is_disposal;
    }

    /**
     * @return the is_lend
     */
    public String getIs_lend() {
        return is_lend;
    }

    /**
     * @param is_lend the is_lend to set
     */
    public void setIs_lend(String is_lend) {
        this.is_lend = is_lend;
    }

    /**
     * @return the media
     */
    public String getMedia() {
        return media;
    }

    /**
     * @param media the media to set
     */
    public void setMedia(String media) {
        this.media = media;
    }

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
     * @return the title_code
     */
    public String getTitle_code() {
        return title_code;
    }

    /**
     * @param title_code the title_code to set
     */
    public void setTitle_code(String title_code) {
        this.title_code = title_code;
    }

    /**
     * @return the disclist
     */
    public List<Disc> getDisclist() {
        return disclist;
    }

    /**
     * @param disclist the disclist to set
     */
    public void setDisclist(List<Disc> disclist) {
        this.disclist = disclist;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.log);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RentalBean other = (RentalBean) obj;
        if (!Objects.equals(this.log, other.log)) {
            return false;
        }
        return true;
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
     * @return the rack
     */
    public String getRack() {
        return rack;
    }

    /**
     * @param rack the rack to set
     */
    public void setRack(String rack) {
        this.rack = rack;
    }

    /**
     * @return the slip_number
     */
    public String getSlip_number() {
        return slip_number;
    }

    /**
     * @param slip_number the slip_number to set
     */
    public void setSlip_number(String slip_number) {
        this.slip_number = slip_number;
    }

//    /**
//     * @return the employees_code
//     */
//    public String getEmployees_code() {
//        return employees_code;
//    }
//
//    /**
//     * @param employees_code the employees_code to set
//     */
//    public void setEmployees_code(String employees_code) {
//        this.employees_code = employees_code;
//    }
//
//    /**
//     * @return the store_code
//     */
//    public String getStore_code() {
//        return store_code;
//    }
//
//    /**
//     * @param store_code the store_code to set
//     */
//    public void setStore_code(String store_code) {
//        this.store_code = store_code;
//    }
//
//    /**
//     * @return the lend_date
//     */
//    public Date getLend_date() {
//        return lend_date;
//    }
//
//    /**
//     * @param lend_date the lend_date to set
//     */
//    public void setLend_date(Date lend_date) {
//        this.lend_date = lend_date;
//    }
//
//    /**
//     * @return the total_price
//     */
//    public String getTotal_price() {
//        return total_price;
//    }
//
//    /**
//     * @param total_price the total_price to set
//     */
//    public void setTotal_price(String total_price) {
//        this.total_price = total_price;
//    }
//
//    /**
//     * @return the is_discount
//     */
//    public String getIs_discount() {
//        return is_discount;
//    }
//
//    /**
//     * @param is_discount the is_discount to set
//     */
//    public void setIs_discount(String is_discount) {
//        this.is_discount = is_discount;
//    }
    /**
     * @return the return_date
     */
    public Date getReturn_date() {
        return return_date;
    }

    /**
     * @param return_date the return_date to set
     */
    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    /**
     * @return the return_plan_date
     */
    public Date getReturn_plan_date() {
        return return_plan_date;
    }

    /**
     * @param return_plan_date the return_plan_date to set
     */
    public void setReturn_plan_date(Date return_plan_date) {
        this.return_plan_date = return_plan_date;
    }

    /**
     * @return the late_price
     */
    public String getLate_price() {
        return late_price;
    }

    /**
     * @param late_price the late_price to set
     */
    public void setLate_price(String late_price) {
        this.late_price = late_price;
    }

    /**
     * @return the subtotal
     */
    public int getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return the receipt
     */
    public Receipt getReceipt() {
        return receipt;
    }

    /**
     * @param receipt the receipt to set
     */
    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    /**
     * @return the azukari
     */
    public int getAzukari() {
        return azukari;
    }

    /**
     * @param azukari the azukari to set
     */
    public void setAzukari(int azukari) {
        this.azukari = azukari;
    }

    /**
     * @return the oturi
     */
    public int getOturi() {
        return oturi;
    }

    /**
     * @param oturi the oturi to set
     */
    public void setOturi(int oturi) {
        this.oturi = oturi;
    }

    /**
     * @return the age
     */
    public long getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(long age) {
        this.age = age;
    }

    /**
     * @return the title_name
     */
    public String getTitle_name() {
        return title_name;
    }

    /**
     * @param title_name the title_name to set
     */
    public void setTitle_name(String title_name) {
        this.title_name = title_name;
    }

    /**
     * @return the cnt
     */
    public int getCnt() {
        return cnt;
    }

    /**
     * @param cnt the cnt to set
     */
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    /**
     * @return the receiptminlist
     */
    public List<ReceiptDetails> getReceiptminlist() {
        return receiptminlist;
    }

    /**
     * @param receiptminlist the receiptminlist to set
     */
    public void setReceiptminlist(List<ReceiptDetails> receiptminlist) {
        this.receiptminlist = receiptminlist;
    }

    /**
     * @return the serial_number
     */
    public String getSerial_number() {
        return serial_number;
    }

    /**
     * @param serial_number the serial_number to set
     */
    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    /**
     * @return the list
     */
    public List<String> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<String> list) {
        this.list = list;
    }
}
