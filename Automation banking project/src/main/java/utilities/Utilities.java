package utilities;


import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class Utilities {
    //TODO :reding data from json file
    private static final String testDataPath = "src/test/resources/TestData/";
    private static final String ScreenshotsPath = "src/test/Test_Output/screenshots/";

    public static void ClickOnElement(WebDriver driver, By Locater) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(Locater));



        driver.findElement(Locater).click();

    }

    public static void senddata(WebDriver driver, By locater, String TEXT) {
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locater));
        driver.findElement(locater).sendKeys(TEXT);

    }

    public static String getData(WebDriver driver, By locater) {
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locater));
        return driver.findElement(locater).getText();

    }

    public static void Scrolling(WebDriver driver, By locater) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoview();", ByToWebElemnt(driver, locater));


    }

    public static WebElement ByToWebElemnt(WebDriver driver, By Locater) {

        return driver.findElement(Locater);

    }

    public static String GetJsonData(String FileName, String Field) throws FileNotFoundException {
        FileReader Reader = new FileReader(testDataPath + FileName + ".json");
        JsonElement jsonElement = JsonParser.parseReader(Reader);
        return jsonElement.getAsJsonObject().get(Field).getAsString();


    }

    public static String GetProperty(String Filename, String key) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(testDataPath + Filename + ".properties"));
        return properties.getProperty(key);


    }

    public static String GetTimeSample() {
        return new SimpleDateFormat("yyyy-MM-dd-h-m-ssa").format(new Date());

    }

    public static void TakeScreenshots(WebDriver driver, String ScreenName) throws IOException {

        File ScreenshotSRC = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File Screenshitfile = new File(ScreenshotsPath + ScreenName + "-" + GetTimeSample() + ".png");
        FileUtils.copyFile(ScreenshotSRC, Screenshitfile);


    }



    public static int CreateRandomnumber(int upperBound) {
        return new Random().nextInt(upperBound) + 1;

    }

    public static Set<Integer> GenerateUniqueNumber(int UpperBound, int NumberOfProduct) {
        Set<Integer> generatedNubber = new HashSet<>();
        while (generatedNubber.size() < UpperBound) {
            int number = CreateRandomnumber(NumberOfProduct);
            generatedNubber.add(number);

        }
        return generatedNubber;
    }
}
