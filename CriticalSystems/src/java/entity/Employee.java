package entity;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 * 店員
 */

@Entity
@NamedQuery(name = "Employee.EmployeeQAll" , query = "SELECT e FROM Employee")
public class Employee implements Serializable {
    public static final String EmployeeQAll = "EmployeeQAll";
    
    @Id
    @NotNull
    private  String empCD;      //店員CD
    @NotNull
    private  String empName;    //店員名
    @NotNull
    private  String password;   //パスワード
    
    private  Store store;       //店舗
    
    private Role role;          //役職

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
