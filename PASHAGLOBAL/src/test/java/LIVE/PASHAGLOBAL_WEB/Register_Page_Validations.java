package LIVE.PASHAGLOBAL_WEB;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.asprise.ocr.Ocr;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Register_Page_Validations {
	WebDriver driver;
	
	@Given("^Chrome browser, valid URL, Go button, Register link, mobile no, email id, captcha code and register now button$")
	public void chrome_browser_valid_URL_Go_button_Register_link_mobile_no_email_id_captcha_code_and_register_now_button() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://pashaglobal.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@When("^Navigate to pasha global website by entering valid URL, click on Register button, enter all the mandatory details and click on register now button$")
	public void navigate_to_pasha_global_website_by_entering_valid_URL_click_on_Register_button_enter_all_the_mandatory_details_and_click_on_register_now_button() throws Throwable {
	   //clicking on register button and entering details for register
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[18]/div[1]/div/div/div[1]/ul/li[2]")));
		driver.findElement(By.xpath("/html/body/div[18]/div[1]/div/div/div[1]/ul/li[2]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("reg_Telephone_Mobile")).sendKeys("9308481390");
		Thread.sleep(1000);
		driver.findElement(By.id("reg_Password")).sendKeys("pavan@123");
		Thread.sleep(1000);
		driver.findElement(By.id("reg_Confirm_Password")).sendKeys("pavan@123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[8]/div/form/div[7]/input")).click();
		Thread.sleep(1000);
		
//		String captcha = driver.findElement(By.id("capimg")).getText();
//		System.out.println(captcha);
//		String captcha1 = driver.findElement(By.id("capimg")).getAttribute(captcha);
//		System.out.println(captcha1);
		
		String imageUrl=driver.findElement(By.id("capimg")).getAttribute("src");
		 System.out.println("Image source path : \n"+ imageUrl);

//		 URL url = new URL(imageUrl);
//		 Image image = ImageIO.read(url);
//		 String s = new Ocr().recognizeCharacters((RenderedImage) image);
//		 System.out.println("Text From Image : \n"+ s);
//		 System.out.println("Length of total text : \n"+ s.length());

		}

	@Then("^User should be fail to register with existing mobile no and validation message needs to be displayed for failure$")
	public void user_should_be_fail_to_register_with_existing_mobile_no_and_validation_message_needs_to_be_displayed_for_failure() throws Throwable {
	    Thread.sleep(2000);
	    driver.quit();
	}
}