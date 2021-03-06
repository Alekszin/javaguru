package screens;

import helpers.Exercises;
import helpers.Users;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.joda.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class AbstractScreen {

    public static WebDriver driver;
    public Users users = new Users();
    public Exercises exercise = new Exercises();
    private final Random random = new SecureRandom();

    public static final int DEFAULT_WEBDRIVER_TIMEOUT_SECONDS = 30;

    public static final String APP_ID = "com.easyfitness:id/";

    @Before
    public void setUp() {
        //To create an object of Desired Capabilities
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability(CapabilityType.VERSION, " 7.0.0");
        capability.setCapability("app", "/Users/aleksz/fit.apk");
        capability.setCapability("deviceName", "J7");
        capability.setCapability("platformName", "Android");
        capability.setCapability("reset", true);
        capability.setCapability("appPackage", "com.easyfitness");
        capability.setCapability("appActivity", "com.easyfitness.MainActivity");
        capability.setCapability("udid", "RF8M21PKQWF");
        try {
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4111/wd/hub"), capability);
        } catch (MalformedURLException e) {
            System.out.println("URL Exception");
        }
    }

    @After
    public void quit() {
        driver.quit();
    }

    @After
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void waitUntil(ExpectedCondition<?> until) {
        waitUntil(until, Duration.standardSeconds(DEFAULT_WEBDRIVER_TIMEOUT_SECONDS), true);
    }

    public void waitUntil(ExpectedCondition<?> until, Duration duration, boolean stopOnFailure) {
        WebDriverWait wait = new WebDriverWait(driver, duration.getStandardSeconds());
        try {
            wait.until(until);
        } catch (Exception e) {
            if (stopOnFailure) {
                throw e;
            }
        }
    }

    public WebElement findElement(By by, boolean stopOnFailure) {
        waitUntil(visibilityOfElementLocated(by), Duration.standardSeconds(2), false);
        WebElement elementToFind = null;
        try {
            elementToFind = driver.findElement(by);
        } catch (Exception e) {
            if (stopOnFailure) {
                throw e;
            }
        }
        return elementToFind;
    }

    public void waitAndSelectElement(By by) {
        click(by);
    }

    public boolean isDisplayed(By by) {
        boolean elementIsDisplayed = false;
        try {
            elementIsDisplayed = isDisplayed(findElement(by, false));
        } catch (Exception e) {
        }
        return elementIsDisplayed;
    }

    public boolean isDisplayed(WebElement element) {
        boolean elementIsDisplayed = false;
        try {
            elementIsDisplayed = element.isDisplayed();
        } catch (Exception e) {
        }
        return elementIsDisplayed;
    }

    public void clickRandomElement(List<WebElement> element) {
        int randomValue = random.nextInt(element.size());
        element.get(randomValue).click();
    }

    public void click(By by) {
        driver.findElement(by).click();
    }

    public void setValue(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void waitAndSetValue(By by, String text) {
        setValue(by, text);
    }
}
