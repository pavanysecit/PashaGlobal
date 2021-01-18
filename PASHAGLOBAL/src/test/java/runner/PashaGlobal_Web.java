package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="features/PashaGlobal_Web_AllUsecases.feature", glue={"LIVE.PASHAGLOBAL_WEB"})

public class PashaGlobal_Web {

}