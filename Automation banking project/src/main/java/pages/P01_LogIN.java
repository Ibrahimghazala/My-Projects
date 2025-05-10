package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Utilities;

public class P01_LogIN {
    private final By username = By.cssSelector("[name = \"uid\"]");
    private final By password = By.cssSelector("[name=\"password\"]") ;
    private final By LogButton = By.cssSelector("[name=\"btnLogin\"]") ;
    private final By restButton = By.cssSelector("[name=\"btnReset\"]") ;

    private WebDriver driver;

    public P01_LogIN(WebDriver driver) {
        this.driver = driver;

    }

    public P01_LogIN Enterusername(String username1) {
        Utilities.senddata(driver, username, username1);
        return this;

    }

    public P01_LogIN Enterpassword(String pass) {
        Utilities.senddata(driver, password, pass);
        return this;

    }

    public P02_NewCustomer Login() {
        Utilities.ClickOnElement(driver, LogButton);
        return new P02_NewCustomer(driver) ;
    }
    public P01_LogIN reset() {
        Utilities.ClickOnElement(driver, restButton);
        return this ;
    }




}
