package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.Utilities;

public class P06_Deposit {
    private final By deposit = By.cssSelector("[href=\"DepositInput.php\"]") ;
    private final By accontNumber = By.cssSelector("[name=\"accountno\"]") ;
    private final By amount = By.cssSelector("[name=\"ammount\"]") ;
    private final By descrption = By.cssSelector("[name=\"desc\"]") ;
    private  final By submit = By.cssSelector("[name=\"AccSubmit\"]") ;

    private WebDriver driver;
    public P06_Deposit(WebDriver driver) {
        this.driver = driver;

    }
    public P06_Deposit navigteToDeposit(){
        Utilities.ClickOnElement(driver,deposit);
        return this ;
    }
    public P06_Deposit enetrAccNumber(String id){
        Utilities.senddata(driver,accontNumber,id);
        return this ;
    }
    public P06_Deposit eneterDepoist(String deposit){
        Utilities.senddata(driver,amount,deposit);
        return this ;
    }
    public P06_Deposit eneterDescribtion(String des){
        Utilities.senddata(driver,descrption,des);
        return this ;
    }



    public P06_Deposit submit(){
        Utilities.ClickOnElement(driver,submit);
        return this ;
    }
}
