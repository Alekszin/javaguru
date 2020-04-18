package screens;

import org.openqa.selenium.By;

import java.util.stream.IntStream;

public class OnboardingScreen extends AbstractScreen {

    By nextButton = By.id("mi_button_next");

    public void skipOnboarding(int times) {
        IntStream.range(0, times)
                .forEach(index -> click(nextButton));
    }
}
