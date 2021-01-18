package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="features/PashaGlobal_Mobile_AllUsecases.feature", glue={"PASHAGLOBAL_MOBILE"})

public class PashaGlobal_Mobile {

}