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
        GetDriver().get("https://accounts.spotify.com/en/login");
        GetDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }

    @Test
    public void ValidLOG() {
        new P01_LogIN(GetDriver()).
                Enterusername("hema.abughazalh@gmail.com")
                .Enterpassword("Hema12345ghazal*").Login().clickOnCheckbox();

        Assert.assertEquals(GetDriver().getCurrentUrl(), "https://www.spotify.com/eg-ar/account/overview/");
    }
    @Test
    public void inValidLOG() {
        new P01_LogIN(GetDriver()).
                Enterusername("hema.abughazalh@gm.com")
                .Enterpassword("Hema12345ghazal*").Login() ;

        Assert.assertNotEquals(GetDriver().getCurrentUrl(), "https://www.spotify.com/eg-ar/account/overview/");
    }


  @AfterMethod
    public void QUIT() {
        DriverFactory.quit();
    }


}
