package screens;

import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class SideMenuScreen extends AbstractScreen {

    By bodyTrackButton = By.xpath("//android.widget.TextView[@text='Body Track']");
    By weightTrackButton = By.xpath("//android.widget.TextView[@text='Weight Track']");
    By settingsTrackButton = By.xpath("//android.widget.TextView[@text='Settings']");
    By aboutTrackButton = By.xpath("//android.widget.TextView[@text='About']");
    By fastNFitnessField = By.xpath("//android.widget.TextView[@text='Fast N Fitness']");
    By unitSettingsField = By.xpath("//android.widget.TextView[@text='Unit settings']");
    By weightDetailsButton = By.id("weightDetailsButton");
    By bicepsField = By.xpath("//android.widget.TextView[@text='Left biceps']");


    public void openBodyTrack() {
        waitAndSelectElement(bodyTrackButton);
    }

    public void openAbout() {
        waitAndSelectElement(aboutTrackButton);
    }

    public void openSettings() {
        waitAndSelectElement(settingsTrackButton);
    }

    public void openWeightTrack() {
        waitAndSelectElement(weightTrackButton);
    }

    public boolean aboutIsDisplayed() {
        waitUntil(visibilityOfElementLocated(fastNFitnessField));
        return isDisplayed(fastNFitnessField);
    }

    public boolean settingsIsDisplayed() {
        waitUntil(visibilityOfElementLocated(unitSettingsField));
        return isDisplayed(unitSettingsField);
    }

    public boolean bodyTrackIsDisplayed() {
        waitUntil(visibilityOfElementLocated(bicepsField));
        return isDisplayed(bicepsField);
    }

    public boolean weightTrackIsDisplayed() {
        waitUntil(visibilityOfElementLocated(weightDetailsButton));
        return isDisplayed(weightDetailsButton);
    }
}
