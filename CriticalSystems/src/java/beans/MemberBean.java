//package beans;
//
//import db.MemberDb;
//import java.io.Serializable;
//import java.util.List;
//import java.util.logging.Logger;
//import javax.ejb.EJB;
//import javax.faces.view.ViewScoped;
//import javax.inject.Inject;
//import javax.inject.Named;
//import javax.validation.constraints.*;
//
//@Named
//@ViewScoped
//public class MemberBean implements Serializable {
//
//    @NotNull
//    private Integer num;
//    @Size(max = 20, min = 1)
//    private String name;
//    @Size(max = 30, min = 1)
//    private String mail;
//    @EJB
//    MemberDb db;
//    @Inject
//    transient Logger log;
//
//    public String create() {
//        Employee employee = new Employee(num,name,mail);
//        try {
//            db.create(employee);
//            clear();
//        } catch (Exception e) {
//            log.fine("■" + num + "|" + e.getMessage());
//        }
//        return null;
//    }
//
//    public String edit(Employee employee) {	// 編集データのセット
//        num = employee.getNum();
//        name = employee.getName();
//        mail = employee.getMail();
//        return null;
//    }
//
//    public String update() {	// 更新
//        Employee employee = new Employee(num,name,mail);
//        try {
//            db.update(employee);
//            clear();
//        } catch (Exception e) {
//            log.fine("■" + num + "|" + e.getMessage());
//        }
//        return null;
//    }
//
//    public String delete(Employee employee) {	// 削除
//        db.delete(employee);
//        return null;
//    }
//
//    public String find() {						// 検索
//        Employee m = db.find(num);
//        if(m != null) {
//            this.num = m.getNum();
//            this.name = m.getName();
//            this.mail = m.getMail();
//        }
//        return null;
//    }
//
//    public List<Employee> getAll() {	// 全データをListにいれて返す
//        return db.getAll();
//    }
//
//    public void clear() {	// 変数をクリア
//        num = null;
//        name = mail = null;
//    }
//
//    // セッターとゲッター
//    public String getMail() {
//        return mail;
//    }
//
//    public void setMail(String mail) {
//        this.mail = mail;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getNum() {
//        return num;
//    }
//
//    public void setNum(Integer num) {
//        this.num = num;
//    }
//
//}
