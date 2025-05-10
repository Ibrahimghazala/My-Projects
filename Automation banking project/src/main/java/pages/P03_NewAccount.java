package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.Utilities;

public class P03_NewAccount {
    private final  By addAccount = By.cssSelector("[href=\"addAccount.php\"]") ;
    private final By customerID = By.cssSelector("[name=\"cusid\"]") ;
    private final By depoist1 = By.cssSelector("[name=\"inideposit\"]") ;
    private  final By submit = By.cssSelector("[type=\"submit\"]") ;

    private WebDriver driver;
    public P03_NewAccount(WebDriver driver) {
        this.driver = driver;

    }
    public P03_NewAccount navigteToNewAccount(){
        Utilities.ClickOnElement(driver,addAccount);
        return this ;
    }
    public P03_NewAccount enetrCustomerID(String id){
        Utilities.senddata(driver,customerID,id);
        return this ;
    }
    public P03_NewAccount eneterIntialDepoist(String deposit){
        Utilities.senddata(driver,depoist1,deposit);
        return this ;
    }
    public P03_NewAccount selectSaving(){
        new Select(driver.findElement(By.cssSelector("[name=\"selaccount\"]")))
                .selectByIndex(0);
        return this ;
    }
    public P03_NewAccount selectCurrent(){
        new Select(driver.findElement(By.cssSelector("[name=\"selaccount\"]")))
                .selectByIndex(1);
        return this ;
    }

    public P03_NewAccount submit(){
        Utilities.ClickOnElement(driver,submit);
        return this ;
    }
}
