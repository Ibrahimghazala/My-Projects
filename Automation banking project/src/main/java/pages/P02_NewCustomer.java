package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Utilities;

public class P02_NewCustomer {
    private final  By newCustomer = By.cssSelector("[href=\"addcustomerpage.php\"]") ;
    private final  By  date = By.id("dob") ;
    private final  By name = By.cssSelector("[name=\"name\"]") ;
    private final  By genderM = By.cssSelector("[value=\"m\"]") ;
    private final  By genderF = By.cssSelector("[value=\"f\"]") ;
    private final By adress =  By.cssSelector("[name=\"addr\"]") ;
    private final By city = By.cssSelector("[name=\"city\"]") ;
    private final By state = By.cssSelector("[name=\"state\"]") ;
    private final By pin = By.cssSelector("[name=\"pinno\"]") ;
    private final By mobileNumber = By.cssSelector("[name=\"telephoneno\"]") ;
    private final By email = By.cssSelector("[name=\"emailid\"]") ;
    private final By password = By.cssSelector("[name=\"password\"]") ;
    private final By submit = By.cssSelector("[name=\"sub\"]") ;
    private final By restButton = By.cssSelector("[name=\"res\"]") ;



    private WebDriver driver;

    public P02_NewCustomer(WebDriver driver) {
        this.driver = driver;

    }
    public P02_NewCustomer navigateToNewCustomer() {
        Utilities.ClickOnElement(driver,newCustomer);
        return this ;

    }
    public P02_NewCustomer selectMale() {
        Utilities.ClickOnElement(driver,genderM);
        return this ;

    }
    public P02_NewCustomer selectFemale() {
        Utilities.ClickOnElement(driver,genderF);
        return this ;

    }
    public P02_NewCustomer enterName(String Name1) {
        Utilities.senddata(driver,name ,Name1);
        return this ;

    }
    public P02_NewCustomer enterDate(String Date1) {
        Utilities.senddata(driver,date ,Date1);
        return this ;
    }
    public P02_NewCustomer enterAdress(String adress1) {
        Utilities.senddata(driver,adress ,adress1);
        return this ;
    }
    public P02_NewCustomer enterCity(String city1) {
        Utilities.senddata(driver,city ,city1);
        return this ;
    }
    public P02_NewCustomer enterState(String state1) {
        Utilities.senddata(driver,state ,state1);
        return this ;
    }
    public P02_NewCustomer enterPin(String pin1) {
        Utilities.senddata(driver,pin ,pin1);
        return this ;
    }
    public P02_NewCustomer enterPhoneNumber(String NUMBER1) {
        Utilities.senddata(driver,mobileNumber ,NUMBER1);
        return this ;
    }
    public P02_NewCustomer enterEmail(String email1) {
        Utilities.senddata(driver,email ,email1);
        return this ;
    }
    public P02_NewCustomer enterPass(String pass1) {
        Utilities.senddata(driver,password ,pass1);
        return this ;
    }
    public P02_NewCustomer submit(){
        Utilities.ClickOnElement(driver,submit);
        return this ;
    }
    public P02_NewCustomer reset() {
        Utilities.ClickOnElement(driver, restButton);
        return this ;
    }

}
