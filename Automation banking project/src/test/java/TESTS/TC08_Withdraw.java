package TESTS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.P01_LogIN;
import pages.P06_Deposit;
import pages.P07_Withdraw;

import java.time.Duration;

import static DriverFactory.DriverFactory.GetDriver;
import static DriverFactory.DriverFactory.SetupDriver;

public class TC08_Withdraw {
    @BeforeMethod
    public void setup() {
        SetupDriver("chrome");
        GetDriver().get("https://demo.guru99.com/V4/index.php");
        GetDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }

    @Test
    public void ValidLOG() {
        new P01_LogIN(GetDriver()).Enterusername("mngr620985")
                .Enterpassword("tyrunAv").Login() ;
        WebElement element = GetDriver().findElement(By.cssSelector("[href=\"WithdrawalInput.php\"]"));
        ((JavascriptExecutor) GetDriver()).executeScript("arguments[0].click();", element);
        new P07_Withdraw(GetDriver()).enetrAccNumber("144667")
                .enterAmount("100").eneterDescribtion("withdraw")
                .submit() ;
        String result =  GetDriver().findElement(By.className("heading3")).getText() ;
        Assert.assertEquals(result,"Transaction details of Withdrawal for Account 144667");
    }





    @AfterMethod
    public void QUIT() {

        //DriverFactory.quit();
    }
}
