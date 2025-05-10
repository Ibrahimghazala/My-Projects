package TESTS;

import DriverFactory.DriverFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.P01_LogIN;

import java.time.Duration;

import static DriverFactory.DriverFactory.GetDriver;
import static DriverFactory.DriverFactory.SetupDriver;

public class TC02_NewCustomer {
    public static String CUSTOMERID ;
    @BeforeMethod
    public void setup() {
        SetupDriver("chrome");
        GetDriver().get("https://demo.guru99.com/V4/index.php");
        GetDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }

    @Test
    public void ValidAddCustomr() {
        new P01_LogIN(GetDriver()).Enterusername("mngr620985")
                .Enterpassword("tyrunAv").Login().navigateToNewCustomer()
                .enterName("mohamed1").selectMale() .enterDate("11032000")
                .enterAdress("elgnayen street")
                .enterCity("sirs")
                .enterState("menofua")
                .enterPin("154156")
                .enterPhoneNumber("01227550514")
                .enterEmail("hema123@gmail.com")
                .enterPass("122344anm").submit();
       String result =  GetDriver().findElement(By.className("heading3")).getText() ;


        Assert.assertEquals(result,"Customer Registered Successfully!!!");

    }
    @Test
    public void ValidREset() {
        new P01_LogIN(GetDriver()).Enterusername("mngr620985")
                .Enterpassword("tyrunAv").Login().navigateToNewCustomer()
                .enterName("mahmoud").selectMale() .enterDate("11032000")
                .enterAdress("elgnayen street")
                .enterCity("sirs")
                .enterState("menofua")
                .enterPin("154156")
                .enterPhoneNumber("01227550514")

                .enterPass("12345mm5jj").reset().submit();
        String Result = GetDriver().switchTo().alert().getText() ;
        Assert.assertEquals(Result,"please fill all fields");


    }





    @AfterMethod
    public void QUIT() {
       DriverFactory.quit();
    }
}
