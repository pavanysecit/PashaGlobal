package PASHAGLOBAL_MOBILE;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class Mobile_PashaGlobal_URL_Login {
private static AppiumDriver<MobileElement> driver;
	
	public AppiumDriver<MobileElement> Mobile_PashaGlobal_URL_Login() throws InterruptedException, MalformedURLException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName", "ASUS X00TD");
		cap.setCapability("udid", "JAAAGF10Z743V8H");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9");
		cap.setCapability("browserName", "Chrome");
		cap.setCapability("skipDeviceInitialization", true);
		cap.setCapability("skipServerInstallation", true);
		cap.setCapability("ignoreUnimportantViews", true);
		cap.setCapability("disableAndroidWatchers", true);
		
		URL url=new URL("http://10.10.13.84:4723/wd/hub");
		
		driver=new AndroidDriver<MobileElement>(url,cap);
		
		System.out.println("Appium started sucessfully");
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.navigate().to("https://onlinegames.pashaglobal.com/");
							
		
	   //clicking on login button and entering valid credentials
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("UnserlnkLogin")));
		driver.findElement(By.id("UnserlnkLogin")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[18]/div[1]/div/div/div[1]/div[1]/div/div[2]/ul/li[1]/div")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("txt_Login_Email")).sendKeys("pmansoorktr@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("txt_login_password")).sendKeys("mansoor@123");
		Thread.sleep(1000);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(8000);
		
		String parent1=driver.getWindowHandle();
		Set<String>s1=driver.getWindowHandles();

		System.out.println("Window for slot game is"+" "+s1);
		 
		Set<String> contx = driver.getContextHandles();
		String pk = driver.getContext();
		//System.out.println("The current contesx is"+" "+pk);
		for(String cont:contx){
			 System.out.println(cont);
		 }

		return driver;
	}
}