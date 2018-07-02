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
    private static String EmpCD;
    @NotNull
    private static String EmpName;
    @NotNull
    private static String password;
    
    private static Shop Shop;
   
    /**
     * @return the CD
     */
    public static String getCD() {
        return EmpCD;
    }

    /**
     * @param aEmpCD the CD to set
     */
    public static void setCD(String aEmpCD) {
        EmpCD = aEmpCD;
    }

    /**
     * @return the Name
     */
    public static String getEmpName() {
        return EmpName;
    }

    /**
     * @param aEmpName the Name to set
     */
    public static void setEmpName(String aEmpName) {
        EmpName = aEmpName;
    }

    /**
     * @return the password
     */
    public static String getPassword() {
        return password;
    }

    /**
     * @param aPassword the password to set
     */
    public static void setPassword(String aPassword) {
        password = aPassword;
    }

    /**
     * @return the Shop
     */
    public static Shop getShop() {
        return Shop;
    }

    /**
     * @param aShop the Shop to set
     */
    public static void setShop(Shop aShop) {
        Shop = aShop;
    }
}
