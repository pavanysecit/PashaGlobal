package runner;

import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="features/PashaGlobal_Mobile_AllUsecases.feature",
glue={"PASHAGLOBAL_MOBILE"}, 
plugin={"com.cucumber.listener.ExtentCucumberFormatter:"} )

public class PashaGlobal_Mobile {
//	ExtentProperties extentProperties = ExtentProperties.INSTANCE;
//	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//	String userDir =System.getProperty("user.dir"); 
//	extentProperties.setReportPath(userDir+ "/target/cucumberreports/report_"+timeStamp+".html");
}