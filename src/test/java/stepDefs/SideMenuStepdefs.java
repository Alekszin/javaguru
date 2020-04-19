package stepDefs;

import helpers.SideMenu;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import screens.SideMenuScreen;

public class SideMenuStepdefs {
    SideMenuScreen sideMenuScreen = new SideMenuScreen();

    @And("user selects {} option")
    public void userSelectsBodyTrack(SideMenu sidemenuOption) {
        switch (sidemenuOption) {
            case ABOUT:
                sideMenuScreen.openAbout();
                break;
            case SETTINGS:
                sideMenuScreen.openSettings();
                break;
            case BODYTRACK:
                sideMenuScreen.openBodyTrack();
                break;
            case WEIGHTTRACK:
                sideMenuScreen.openWeightTrack();
                break;
            default:
                throw new IllegalArgumentException("No such side menu option");
        }
    }

    @Then("{} should be displayed")
    public void sideMenuShouldBeDisplayed(SideMenu sidemenuOption) {
        switch (sidemenuOption) {
            case ABOUT:
                Assert.assertTrue(sideMenuScreen.aboutIsDisplayed());
                break;
            case SETTINGS:
                Assert.assertTrue(sideMenuScreen.settingsIsDisplayed());
                break;
            case BODYTRACK:
                Assert.assertTrue(sideMenuScreen.bodyTrackIsDisplayed());
                break;
            case WEIGHTTRACK:
                Assert.assertTrue(sideMenuScreen.weightTrackIsDisplayed());
                break;
            default:
                throw new IllegalArgumentException("No such side menu option");
        }
        sideMenuScreen.quit();
    }
}
