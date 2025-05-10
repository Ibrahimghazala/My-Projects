package TESTS;

import DriverFactory.DriverFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.P01_LogIN;
import pages.P05_EditAcc;

import java.time.Duration;

import static DriverFactory.DriverFactory.GetDriver;
import static DriverFactory.DriverFactory.SetupDriver;

public class TC06_EditAcc {
    @BeforeMethod
    public void setup() {
        SetupDriver("chrome");
        GetDriver().get("https://demo.guru99.com/V4/index.php");
        GetDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }

    @Test
    public void ValidEditAcc() {
        new P01_LogIN(GetDriver()).Enterusername("mngr620985")
                .Enterpassword("tyrunAv").Login() ;
        new P05_EditAcc(GetDriver()).editAcc().enterAccoountId("144667").submit() ;
        String result =  GetDriver().findElement(By.className("heading3")).getText() ;
        Assert.assertEquals(result,"Account Updated Successfully!!!");
    }





    @AfterMethod
    public void QUIT() {
       // DriverFactory.quit();
    }
}
