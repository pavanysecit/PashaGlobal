package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="features/PashaGlobal_Mobile_AllUsecases.feature", glue={"PASHAGLOBAL_MOBILE"}, plugin={"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"} )

public class PashaGlobal_Mobile {

}