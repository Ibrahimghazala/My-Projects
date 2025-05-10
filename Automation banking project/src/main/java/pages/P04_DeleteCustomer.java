package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Utilities;

public class P04_DeleteCustomer {
    private  final By deleteCustomer = By.cssSelector("[href=\"DeleteCustomerInput.php\"]") ;
    private final By customerId = By.cssSelector("[name=\"cusid\"]") ;
    private final By submit = By.cssSelector("[name=\"AccSubmit\"]") ;
    WebDriver driver ;
    public  P04_DeleteCustomer(WebDriver driver){
        this.driver = driver ;
    }
    public  P04_DeleteCustomer deleteCustomer(){
        Utilities.ClickOnElement(driver,deleteCustomer);
        return this ;
    }
    public  P04_DeleteCustomer submit(){
        Utilities.ClickOnElement(driver,submit);
        return this ;
    }
    public  P04_DeleteCustomer enterCustomerId(String Id){
        Utilities.senddata(driver,customerId,Id);
        return this ;
    }

}
