package TESTS;

import DriverFactory.DriverFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.P01_LogIN;
import pages.P03_NewAccount;

import java.time.Duration;

import static DriverFactory.DriverFactory.GetDriver;
import static DriverFactory.DriverFactory.SetupDriver;

public class TC03_AddAccount {
    @BeforeMethod
    public void setup() {
        SetupDriver("chrome");
        GetDriver().get("https://demo.guru99.com/V4/index.php");
        GetDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }

    @Test
    public void ValidNewAccount() {

        new P01_LogIN(GetDriver()).Enterusername("mngr620985")
                .Enterpassword("tyrunAv").Login().navigateToNewCustomer()
                .enterName("Ibrahim mohamed").selectMale() .enterDate("11032000")
                .enterAdress("elgnayen street")
                .enterCity("sirs")
                .enterState("menofua")
                .enterPin("154156")
                .enterPhoneNumber("01227550514")
                .enterEmail("hema55m@gmail.com")
                .enterPass("12345mm5jj").submit();

        TC02_NewCustomer.CUSTOMERID = GetDriver().getCurrentUrl()
                .toString().substring(GetDriver()
                        .getCurrentUrl().toString().indexOf("?") + 5);
        new P03_NewAccount(GetDriver()).navigteToNewAccount().enetrCustomerID(TC02_NewCustomer.CUSTOMERID)
                .eneterIntialDepoist("200000").selectCurrent().submit();
        String result =  GetDriver().findElement(By.className("heading3")).getText() ;
        Assert.assertEquals(result,"Account Generated Successfully!!!");

    }




    @AfterMethod
    public void QUIT() {
       DriverFactory.quit();
    }
}
