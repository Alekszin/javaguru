package helpers;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
        tags = {"@test"},
        plugin = {"json:build/report/cucumber.json"},
        features = {"src/test/resources/features"},
        glue = "stepDefs")
public class TestRunner {
}