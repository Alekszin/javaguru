package stepDefs;

import io.cucumber.java.en.Given;
import screens.OnboardingScreen;
import screens.RegistrationScreen;

public class RegistrationStepdefs {

    OnboardingScreen onboardingScreen = new OnboardingScreen();
    RegistrationScreen registrationScreen = new RegistrationScreen();


    @Given("user should be able to register an account")
    public void registrationStepDef() throws InterruptedException {
        onboardingScreen.setUp();
        onboardingScreen.skipOnboarding(4);
        registrationScreen.register();
    }
}
