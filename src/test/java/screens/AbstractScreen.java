package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Before;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AbstractScreen {

    public AppiumDriver<? extends MobileElement> driver;

    public AbstractScreen(AppiumDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
    }

    public void waitAndSelectElement(MobileElement element) {
        click(element);
    }

    public void click(MobileElement element) {
        element.click();
    }

    @Before
    public void setUp() throws MalformedURLException {
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
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4111/wd/hub"), capability);
    }
}
