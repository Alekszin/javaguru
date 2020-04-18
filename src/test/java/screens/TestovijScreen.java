package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TestovijScreen extends AbstractScreen {

    public TestovijScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "azaza")
    public MobileElement da;

    public void dejstvie() {
        da.click();
    }
}
