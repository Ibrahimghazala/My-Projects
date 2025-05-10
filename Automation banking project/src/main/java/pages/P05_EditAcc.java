package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Utilities;

public class P05_EditAcc {
    private  final By editAcc = By.cssSelector("[href=\"editAccount.php\"]") ;
    private final By AccountId = By.cssSelector("[name=\"accountno\"]") ;
    private final By submit = By.cssSelector("[name=\"AccSubmit\"]") ;
    WebDriver driver ;
    public  P05_EditAcc(WebDriver driver){
        this.driver = driver ;
    }
    public  P05_EditAcc editAcc(){
        Utilities.ClickOnElement(driver,editAcc);
        return this ;
    }
    public  P05_EditAcc submit(){
        Utilities.ClickOnElement(driver,submit);
        return this ;
    }
    public  P05_EditAcc enterAccoountId(String Id){
        Utilities.senddata(driver,AccountId,Id);
        return this ;
    }
}
