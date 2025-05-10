package TESTS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.P01_LogIN;
import pages.P09_LogOut;

import java.time.Duration;

import static DriverFactory.DriverFactory.GetDriver;
import static DriverFactory.DriverFactory.SetupDriver;

public class Tc10_LogOut {
    @BeforeMethod
    public void setup() {
        SetupDriver("chrome");
        GetDriver().get("https://demo.guru99.com/V4/index.php");
        GetDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }

    @Test
    public void ValidLOGout() {
        new P01_LogIN(GetDriver()).Enterusername("mngr620985")
                .Enterpassword("tyrunAv").Login() ;
        WebElement element = GetDriver().findElement(By.cssSelector("[href='Logout.php']"));
        ((JavascriptExecutor) GetDriver()).executeScript("arguments[0].click();", element);
       // new P09_LogOut(GetDriver()).LogOut() ;

        String result = GetDriver().switchTo().alert().getText() ;
        Assert.assertEquals(result,"You Have Succesfully Logged Out!!");
    }
}
