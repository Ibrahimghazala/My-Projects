package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Utilities;

public class P02_SignUp {
    private final By emailAdress = By.id("username");
    private final By nextButton = By.cssSelector("[data-testid=submit]");
    private final By password = By.cssSelector("[type=password]");


    private WebDriver driver;

    public P02_SignUp(WebDriver driver) {
        this.driver = driver;

    }
    public P02_SignUp Enterusername(String email) {
        Utilities.senddata(driver, emailAdress, email);
        return this ;


    }
    public P02_SignUp nextButton() {
        Utilities.ClickOnElement(driver, nextButton);
        return this ;


    }
    public  void enterPassword(String pass) {
        Utilities.senddata(driver, password, pass);



    }

}
