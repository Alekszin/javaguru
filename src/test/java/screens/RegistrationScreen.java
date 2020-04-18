package screens;

import helpers.RandomGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class RegistrationScreen extends AbstractScreen {

    RandomGenerator randomGenerator = new RandomGenerator();

    By fullNameField = By.id("profileName");
    By maleRadioButton = By.id("radioButtonMale");
    By profileBirthdayButton = By.id("profileBirthday");
    By sizeField = By.id("profileSize");
    By createAccountButton = By.id("create_newprofil");
    By datePickerHeaderYearButton = By.id("android:id/date_picker_header_year");
    By yearButton = By.xpath("//android.widget.TextView[@text='2000']");
    By okButton = By.id("android:id/button1");
    By profileCreatedApprovalButton = By.id("confirm_button");

    public void register() throws InterruptedException {
        setUsers();
        waitUntil(visibilityOfElementLocated(fullNameField));
        isDisplayed(fullNameField);
        waitAndSetValue(fullNameField, users.getUsername());
        click(maleRadioButton);
        selectYearAndDate();
        waitUntil(visibilityOfElementLocated(sizeField));
        waitAndSetValue(sizeField, users.getSize());
        click(createAccountButton);
        Thread.sleep(2000);
        waitUntil(visibilityOfElementLocated(profileCreatedApprovalButton));
        click(profileCreatedApprovalButton);
    }

    private void setUsers() {
        users.setUsername(randomGenerator.randomString());
        users.setSize(randomGenerator.randomInt());
    }

    private void selectYearAndDate() {
        click(profileBirthdayButton);
        waitAndSelectElement(datePickerHeaderYearButton);
        selectYear();
        selectDay();
        click(okButton);
    }

    public void selectYear() {
        List<WebElement> element = driver.findElements(By.xpath("//android.widget.ListView/android.widget.TextView"));
        clickRandomElement(element);
    }

    private void selectDay() {
        List<WebElement> dates = driver.findElements(By.xpath("//android.view.View/android.view.View"));
        clickRandomElement(dates);
    }
}

