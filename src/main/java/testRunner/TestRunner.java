package testRunner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = {"com.glue"},
        features = {"classpath:features/"}
)
public class TestRunner {
}
