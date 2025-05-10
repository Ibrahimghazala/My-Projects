package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Utilities;

public class P08_FundTransfer {
    private final By fundTransfer = By.cssSelector("[href=\"FundTransInput.php\"]") ;
    private final By PayersaccontNumber = By.cssSelector("[name=\"payersaccount\"]") ;
    private final By PayeesaccontNumber = By.cssSelector("[name=\"payeeaccount\"]") ;
    private final By amount = By.cssSelector("[name=\"ammount\"]") ;
    private final By descrption = By.cssSelector("[name=\"desc\"]") ;
    private  final By submit = By.cssSelector("[name=\"AccSubmit\"]") ;

    private WebDriver driver;
    public P08_FundTransfer(WebDriver driver) {
        this.driver = driver;

    }
    public P08_FundTransfer navigateToFindTransfer(){
        Utilities.ClickOnElement(driver,fundTransfer);
        return this ;
    }
    public P08_FundTransfer enetrPayeraAccount(String id){
        Utilities.senddata(driver,PayersaccontNumber,id);
        return this ;
    }
    public P08_FundTransfer enetrPayeseaAccount(String id){
        Utilities.senddata(driver,PayeesaccontNumber,id);
        return this ;
    }
    public P08_FundTransfer enterAmount(String amount1){
        Utilities.senddata(driver,amount,amount1);
        return this ;
    }
    public P08_FundTransfer eneterDescribtion(String des){
        Utilities.senddata(driver,descrption,des);
        return this ;
    }



    public P08_FundTransfer submit(){
        Utilities.ClickOnElement(driver,submit);
        return this ;
    }
}
