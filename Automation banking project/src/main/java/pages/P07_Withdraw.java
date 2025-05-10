package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Utilities;

public class P07_Withdraw {
    private final By withdraw = By.cssSelector("[href=\"WithdrawalInput.php\"]") ;
    private final By accontNumber = By.cssSelector("[name=\"accountno\"]") ;
    private final By amount = By.cssSelector("[name=\"ammount\"]") ;
    private final By descrption = By.cssSelector("[name=\"desc\"]") ;
    private  final By submit = By.cssSelector("[name=\"AccSubmit\"]") ;

    private WebDriver driver;
    public P07_Withdraw(WebDriver driver) {
        this.driver = driver;

    }
    public P07_Withdraw navigateToWithdraw(){
        Utilities.ClickOnElement(driver,withdraw);
        return this ;
    }
    public P07_Withdraw enetrAccNumber(String id){
        Utilities.senddata(driver,accontNumber,id);
        return this ;
    }
    public P07_Withdraw enterAmount(String amount1){
        Utilities.senddata(driver,amount,amount1);
        return this ;
    }
    public P07_Withdraw eneterDescribtion(String des){
        Utilities.senddata(driver,descrption,des);
        return this ;
    }



    public P07_Withdraw submit(){
        Utilities.ClickOnElement(driver,submit);
        return this ;
    }
}
