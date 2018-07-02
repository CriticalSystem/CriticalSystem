package entity;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

@Entity
@NamedQuery(name = "Employee.EmployeeQAll" , query = "SELECT e FROM Employee")
public class Employee implements Serializable {
    public static final String EmployeeQAll = "EmployeeQAll";
    
    @Id
    @NotNull
    private  String EmpCD;
    @NotNull
    private  String EmpName;
    @NotNull
    private  String password;
    
    private  Shop Shop;

    /**
     * @return the EmpCD
     */
    public String getEmpCD() {
        return EmpCD;
    }

    /**
     * @param EmpCD the EmpCD to set
     */
    public void setEmpCD(String EmpCD) {
        this.EmpCD = EmpCD;
    }

    /**
     * @return the EmpName
     */
    public String getEmpName() {
        return EmpName;
    }

    /**
     * @param EmpName the EmpName to set
     */
    public void setEmpName(String EmpName) {
        this.EmpName = EmpName;
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
     * @return the Shop
     */
    public Shop getShop() {
        return Shop;
    }

    /**
     * @param Shop the Shop to set
     */
    public void setShop(Shop Shop) {
        this.Shop = Shop;
    }
   
}
