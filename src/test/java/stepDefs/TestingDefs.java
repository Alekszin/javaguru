package stepDefs;

import io.cucumber.java.en.Given;
import screens.TestovijScreen;

public class TestingDefs {

    private final TestovijScreen testovijScreen;

    public TestingDefs(TestovijScreen testovijScreen) {
        this.testovijScreen = testovijScreen;
    }

    @Given("testScenario")
    public void stepDefchik() {
        testovijScreen.dejstvie();
    }
}
