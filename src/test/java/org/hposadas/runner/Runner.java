package org.hposadas.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.hposadas.pages.BasePage;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "org/hposadas/steps",
        plugin = {"json:target/cucumber.json"}
)
public class Runner {
    @AfterClass
    public static void classDriver(){
        BasePage.closeNavigator();
    }
}
