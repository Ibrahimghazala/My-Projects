package TESTS;

import DriverFactory.DriverFactory;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.P01_LogIN;
import pages.P02_SignUp;

import java.time.Duration;

import static DriverFactory.DriverFactory.GetDriver;
import static DriverFactory.DriverFactory.SetupDriver;

public class TC02_SignUp {
    @BeforeMethod
    public void setup() {
        SetupDriver("chrome");
        GetDriver().get("https://www.spotify.com/signup/");
        GetDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }

    @Test
    public void inValidEmail() {

        new P02_SignUp(GetDriver()).Enterusername("hema.abughazalhl.com" ) ;
        new P02_SignUp(GetDriver()).nextButton();


        Assert.assertNotEquals(GetDriver().
                getCurrentUrl(), "https://www.spotify.com/eg-ar/signup#step=1");
    }
@Test
    public void ValidEmail() {

        new P02_SignUp(GetDriver()).Enterusername("hema.abughazalh@gmail.com" ) ;

        new P02_SignUp(GetDriver()).nextButton();



        Assert.assertNotEquals(GetDriver().
                getCurrentUrl(), "https://www.spotify.com/eg-ar/signup#step=1");
    }
    @AfterMethod
    public void QUIT() {
        DriverFactory.quit();
    }



}
