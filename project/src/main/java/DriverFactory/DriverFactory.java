package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> DriverThreadLocal = new ThreadLocal<>() ;

    public static void SetupDriver(String Browser){
        switch (Browser.toLowerCase()){
            case "chrome" :

                DriverThreadLocal.set(new ChromeDriver()) ;
                DriverThreadLocal.get().manage().window().maximize();
                break;
            case "firefox"   :
                DriverThreadLocal.set(new FirefoxDriver());
                DriverThreadLocal.get().manage().window().maximize();
                break;

            default:
                DriverThreadLocal.set(new EdgeDriver());

                DriverThreadLocal.get().manage().window().maximize();


        }
    }
    public static WebDriver GetDriver(){
        return DriverThreadLocal.get() ;

    }
    public static void quit(){
        GetDriver().quit();
        DriverThreadLocal.remove();
    }
}
