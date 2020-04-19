package screens;

import helpers.RandomGenerator;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MainScreen extends AbstractScreen {
    By profileImage = By.id("imageProfile");
    By exerciseNameField = By.id("editMachine");
    By setsInputField = By.id("editSerie");
    By repetitionInputField = By.id("editRepetition");
    By editPoidsInputField = By.id("editPoids");
    By addButton = By.id("addperff");
    By exitButton = By.id("btn_exit");
    By sideMenuButton = By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']");

//   chronoE - remove E, so test will stop failing
    By chronoButton = By.id("action_chronoe");


    RandomGenerator random = new RandomGenerator();

    public void profileIsDisplayed() {
        waitUntil(visibilityOfElementLocated(profileImage));
        isDisplayed(profileImage);
    }

    public void createExercise() {
        exercise.setExercise(random.randomString());
        waitUntil(visibilityOfElementLocated(exerciseNameField));
        waitAndSetValue(exerciseNameField, exercise.getExercise());
        waitAndSetValue(setsInputField, random.randomInt());
        waitAndSetValue(repetitionInputField, random.randomInt());
        waitAndSetValue(editPoidsInputField, random.randomInt());
        waitAndSelectElement(addButton);
        waitUntil(visibilityOfElementLocated(exitButton));
        click(exitButton);
    }

    public boolean exerciseIsDisplayed() {
        By exerciseName = By.xpath("//android.widget.TextView[@text='" + exercise.getExercise() + "']");
        return isDisplayed(exerciseName);
    }

    public void openSideMenu() {
        waitUntil(visibilityOfElementLocated(sideMenuButton));
        click(sideMenuButton);
    }

    public void openChronometer() {
        waitUntil(visibilityOfElementLocated(chronoButton));
        click(chronoButton);
    }
}
