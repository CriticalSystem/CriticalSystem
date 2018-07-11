package entity;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 店員
 */

@NamedQuery(name = "Employee.EmployeeQAll" , query = "SELECT e FROM Employee")

@Entity
@Table(name="EMPLOYEE")
public class Employee implements Serializable {
    public static final String EmployeeQAll = "EmployeeQAll";
    
    @Id
    @NotNull
    @Column(name = "employees_code")
    private  String empCD;      //店員CD
    @NotNull
    @Column(name = "employees_name")
    private  String empName;    //店員名
    @NotNull
    @Column(name = "password")
    private  String password;   //パスワード
    @Column(name = "store_code")
    private  Store store;       //店舗
    @Column(name = "joined_on")
    private Date joined_on; //入社日

    /**
     * @return the empCD
     */
    public String getEmpCD() {
        return empCD;
    }

    /**
     * @param EmpCD the empCD to set
     */
    public void setEmpCD(String EmpCD) {
        this.empCD = EmpCD;
    }

    /**
     * @return the EmpName
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * @param EmpName the EmpName to set
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the Store
     */
    public Store getStore() {
        return store;
    }

    /**
     * @param Shop the Store to set
     */
    public void setStore(Store store) {
        this.store = store;
    }
   
}
