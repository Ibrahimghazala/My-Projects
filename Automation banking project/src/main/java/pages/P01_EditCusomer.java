package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Utilities;

public class P01_EditCusomer {
    private final  By editCustomer = By.cssSelector("[href=\"EditCustomer.php\"]") ;
    private final  By customerId = By.cssSelector("[name=\"cusid\"]") ;
    private final  By submit = By.cssSelector("[name=\"AccSubmit\"]") ;

    WebDriver driver ;
     public P01_EditCusomer(WebDriver driver){
         this.driver = driver ;


     }
    public P01_EditCusomer navigateToEditCustomer() {
        Utilities.ClickOnElement(driver,editCustomer);
        return this ;

    }
    public P01_EditCusomer enterID(String Id){
         Utilities.senddata(driver,customerId,Id);
         return this ;
    }
    public P01_EditCusomer submit() {
        Utilities.ClickOnElement(driver,submit);
        return this ;

    }


}
