package TESTS;

import DriverFactory.DriverFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.P01_LogIN;
import pages.P04_DeleteCustomer;
import pages.P06_Deposit;

import java.time.Duration;

import static DriverFactory.DriverFactory.GetDriver;
import static DriverFactory.DriverFactory.SetupDriver;

public class TC07_Deposit {
    @BeforeMethod
    public void setup() {
        SetupDriver("chrome");
        GetDriver().get("https://demo.guru99.com/V4/index.php");
        GetDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }

    @Test
    public void ValidDeposit() {
        new P01_LogIN(GetDriver()).Enterusername("mngr616919")
                .Enterpassword("EgYmAdy").Login() ;
        new P06_Deposit(GetDriver()).navigteToDeposit().enetrAccNumber("144667")
                .eneterDepoist("5000")
                .eneterDescribtion("JHJJGHCG")
                .submit();
        String result =  GetDriver().findElement(By.className("heading3")).getText() ;
        Assert.assertEquals(result,"Account Deposited Successfully!!!");
    }





    @AfterMethod
    public void QUIT() {

        DriverFactory.quit();

    }
}
