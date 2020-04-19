package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import screens.MainScreen;


public class MainStepdefs {

    MainScreen mainScreen = new MainScreen();

    @Then("user should be logged in")
    public void userShouldBeLoggedIn() {
        mainScreen.profileIsDisplayed();
        mainScreen.quit();
    }

    @Given("user creates an exercise")
    public void userCreatesAnExercise() {
        mainScreen.createExercise();
    }

    @Then("exercises should be created")
    public void exercisesShouldBeCreated() {
        Assert.assertTrue(mainScreen.exerciseIsDisplayed());
        mainScreen.quit();
    }

    @And("user opens side menu")
    public void userOpensSideMenu() {
        mainScreen.openSideMenu();
    }
}