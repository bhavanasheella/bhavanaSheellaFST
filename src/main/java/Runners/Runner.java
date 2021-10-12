package Runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\002G4Q744\\Eclipse\\FST\\src\\main\\java\\Feature", glue = { "StepDefinitions" })
public class Runner {


}
