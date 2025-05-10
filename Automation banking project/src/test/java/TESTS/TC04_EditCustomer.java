package TESTS;

import DriverFactory.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.P01_EditCusomer;
import pages.P01_LogIN;
import pages.P02_NewCustomer;
import pages.P04_DeleteCustomer;

import java.time.Duration;

import static DriverFactory.DriverFactory.GetDriver;
import static DriverFactory.DriverFactory.SetupDriver;

public class TC04_EditCustomer {
    @BeforeMethod
    public void setup() {
        SetupDriver("chrome");
        GetDriver().get("https://demo.guru99.com/V4/index.php");
        GetDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }

    @Test
    public void EditCustomer() {

        new P01_LogIN(GetDriver()).Enterusername("mngr620985")
                .Enterpassword("tyrunAv").Login().navigateToNewCustomer()
                .enterName("mohamed salah").selectMale() .enterDate("11032000")
                .enterAdress("elgnayen street")
                .enterCity("sirs")
                .enterState("menofua")
                .enterPin("154156")
                .enterPhoneNumber("01227550514")
                .enterEmail("hem@gmail.com")
                .enterPass("12345mm5jj").submit();

        TC02_NewCustomer.CUSTOMERID = GetDriver().getCurrentUrl()
                .toString().substring(GetDriver()
                        .getCurrentUrl().toString().indexOf("?") + 5);
        new P01_EditCusomer(GetDriver()).navigateToEditCustomer()
                .enterID(TC02_NewCustomer.CUSTOMERID).submit() ;
        new P02_NewCustomer(GetDriver()).enterCity("MENOFn")
                .enterPhoneNumber("0129955655").submit();
        Assert.assertEquals(GetDriver().getCurrentUrl()
                ,"https://demo.guru99.com/V4/manager/editCustomerPage.php");
        /* delete customer ************************************************************************/
        SetupDriver("chrome");
        GetDriver().get("https://demo.guru99.com/V4/index.php");
        GetDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        new P01_LogIN(GetDriver()).Enterusername("mngr620985")
                .Enterpassword("tyrunAv").Login() ;
        new P04_DeleteCustomer(GetDriver()).deleteCustomer().enterCustomerId(TC02_NewCustomer.CUSTOMERID).submit() ;
        GetDriver().switchTo().alert().accept();
    }





    @AfterMethod
    public void QUIT() {

       DriverFactory.quit();
    }

}
