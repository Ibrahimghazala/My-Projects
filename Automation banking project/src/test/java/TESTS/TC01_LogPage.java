package TESTS;

import DriverFactory.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.P01_LogIN;

import java.time.Duration;

import static DriverFactory.DriverFactory.GetDriver;
import static DriverFactory.DriverFactory.SetupDriver;

public class TC01_LogPage {
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
        Assert.assertEquals(GetDriver().getCurrentUrl() ,"https://demo.guru99.com/V4/manager/Managerhomepage.php");
    }
    @Test
    public void inValidLOG() {
        new P01_LogIN(GetDriver()).Enterusername("mngr6119")
                .Enterpassword("EgYmAdy").Login() ;
        String result = GetDriver().switchTo().alert().getText() ;
        Assert.assertEquals(result,"User or Password is not valid");
    }
    @Test
    public void validReset() {
        new P01_LogIN(GetDriver()).Enterusername("mngr616919")
                .Enterpassword("EgYmAdy").reset().Login() ;
        String Result = GetDriver().switchTo().alert().getText() ;
        Assert.assertEquals(Result,"User or Password is not valid");
    }




  @AfterMethod
    public void QUIT() {

        DriverFactory.quit();
    }


}
