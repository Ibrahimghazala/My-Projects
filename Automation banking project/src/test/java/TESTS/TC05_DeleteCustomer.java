package TESTS;

import DriverFactory.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.P01_LogIN;
import pages.P04_DeleteCustomer;

import java.time.Duration;

import static DriverFactory.DriverFactory.GetDriver;
import static DriverFactory.DriverFactory.SetupDriver;

public class TC05_DeleteCustomer {
    @BeforeMethod
    public void setup() {
        SetupDriver("chrome");
        GetDriver().get("https://demo.guru99.com/V4/index.php");
        GetDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }

    @Test
    public void ValidDeleteCustomer() {
        //ADD ACCOUNT**********************************************************/
        new P01_LogIN(GetDriver()).Enterusername("mngr620985")
                .Enterpassword("tyrunAv").Login().navigateToNewCustomer()
                .enterName("ahmed mohamed").selectMale() .enterDate("11032000")
                .enterAdress("elgnayen street")
                .enterCity("sirs")
                .enterState("menofua")
                .enterPin("154156")
                .enterPhoneNumber("01227550514")
                .enterEmail("Ahmed1@gmail.com")
                .enterPass("12345mm5jj").submit();

        TC02_NewCustomer.CUSTOMERID = GetDriver().getCurrentUrl()
                .toString().substring(GetDriver()
                        .getCurrentUrl().toString().indexOf("?") + 5);
        /*DELETE ACCOUNT ***************************************************************/
        new P04_DeleteCustomer(GetDriver()).deleteCustomer()
                .enterCustomerId(TC02_NewCustomer.CUSTOMERID)
                .submit() ;
        GetDriver().switchTo().alert().accept();
        DriverFactory.quit();
        /* CHECK THAT THE ACCOUNT DELETED ********/
        SetupDriver("chrome");
        GetDriver().get("https://demo.guru99.com/V4/index.php");
        GetDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        new P01_LogIN(GetDriver()).Enterusername("mngr620985")
                .Enterpassword("tyrunAv").Login() ;
        new P04_DeleteCustomer(GetDriver()).deleteCustomer().enterCustomerId(TC02_NewCustomer.CUSTOMERID).submit() ;
        GetDriver().switchTo().alert().accept();
        String result = GetDriver().switchTo().alert().getText() ;
        Assert.assertEquals(result,"Customer does not exist!!");



    }





    @AfterMethod
    public void QUIT() {

        DriverFactory.quit();
    }

}
