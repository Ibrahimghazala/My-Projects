package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Utilities;

public class P01_LogIN {
    private final By username = By.id("login-username");
    private final By password = By.id("login-password");
    private final By LogButton = By.id("login-button");
    private final By checkbox = By.id("account-settings-link") ;
    private final  By webPlayer = By.cssSelector("[data-testid=web-player-link]")   ;
    private final By songs = By.cssSelector("[data-encore-id=formInput]") ;



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

    public P01_LogIN Login() {
        Utilities.ClickOnElement(driver, LogButton);
        return this;
    }
    public P01_LogIN clickOnCheckbox() {
        Utilities.ClickOnElement(driver, checkbox);
        return this;
    }
    public P01_LogIN clickOnWebLink() {
        Utilities.ClickOnElement(driver, webPlayer);
        return this;
    }
    public P01_LogIN Entersong(String song) {
        Utilities.senddata(driver, songs, song);
        return this;

    }



}
