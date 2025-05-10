package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Utilities;

public class P09_LogOut {
    private final By logout = By.cssSelector("[href=\"Logout.php\"]") ;
    private WebDriver driver;

    public P09_LogOut(WebDriver driver) {
        this.driver = driver;

    }
    public P09_LogOut LogOut(){
        Utilities.ClickOnElement(driver,logout);
        return this ;
    }
}
