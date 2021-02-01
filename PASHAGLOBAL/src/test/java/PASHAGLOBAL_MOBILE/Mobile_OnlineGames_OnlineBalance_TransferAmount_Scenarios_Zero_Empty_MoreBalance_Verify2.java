package PASHAGLOBAL_MOBILE;

import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Mobile_OnlineGames_OnlineBalance_TransferAmount_Scenarios_Zero_Empty_MoreBalance_Verify2 {
	AppiumDriver<MobileElement> driver;

	public Mobile_OnlineGames_OnlineBalance_TransferAmount_Scenarios_Zero_Empty_MoreBalance_Verify2() throws InterruptedException {
		this.driver = Mobile_PashaGlobal_URL_Login.getDriver();
	}
	

	@Given("^Chrome browser, valid URL, valid login details, online games, balance, text field to transfer balance and Ok button$")
	public void chrome_browser_valid_URL_valid_login_details_online_games_balance_text_field_to_transfer_balance_and_Ok_button() throws Throwable {
	   
	}
	
	@When("^Open the any online slot game by entering the valid URL in browser, enter the valid login details, click on Play button, enter the valid amount to transfer and click on Ok butotn$")
	public void open_the_any_online_slot_game_by_entering_the_valid_URL_in_browser_enter_the_valid_login_details_click_on_Play_button_enter_the_valid_amount_to_transfer_and_click_on_Ok_butotn() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DisplayBalance1")));
		WebElement element = driver.findElement(By.cssSelector(".main_menu_active.online_Games"));
		element.click();
		Thread.sleep(8000);
		// Clicking on Play Now link
		WebElement playnow = driver.findElement(By.xpath("/html/body/div[15]/div[4]/div/div/div[2]/div[2]/div/div/div/div/div[1]/ul/li[5]/div[1]/div/div[1]/div"));
		playnow.click();
		Thread.sleep(5000);
	}
	
	@Then("^Player should be blocked from loading the online game when the amount entered in the transfer page is more than the available balance$")
	public void player_should_be_blocked_from_loading_the_online_game_when_the_amount_entered_in_the_transfer_page_is_more_than_the_available_balance() throws Throwable {
		//1. Transferring more balance than available balance in the account and checking the validation message
		
		//Getting available balance and splitting into numbers n characters
		MobileElement TargetElement =driver.findElement(By.id("lblshowBalanceforPopup"));
		String getValue1 = TargetElement.getText();
		System.out.println("Available Balance in Account:" +getValue1);
		String[] br = getValue1.split("\\W");
		for(int i=0;i<br.length;i++){
		System.out.println("The value of char is"+" "+br[i]);
		}
		String unique="";
		for(int i=0;i<br.length;i++){
        if(i==0)
		unique=unique+br[i];
		System.out.println(unique+"unique");

		}
		System.out.println("The unique value is"+" "+unique);
		System.out.println("length"+br.length);
		double value1 = Integer.parseInt(unique);
		
		//Passing 100 to the balance field and storing in getvalue2 variable
		MobileElement transfer = driver.findElement(By.id("txtTransferedBalance"));
		transfer.sendKeys("2222");
		Thread.sleep(2000);
		TargetElement.click();
		String getValue2 = transfer.getAttribute("value");
		System.out.println("Balance to Transfer:" +getValue2);

		double value2 = Integer.parseInt(getValue2);
		
		//Adding main balance and getValue2(100 SRD)
        double total1 = value1 + value2;
//        DecimalFormat format = new DecimalFormat("#0,0000.00");
//        String formattedNumber = format.format(total);
        long total = Double.valueOf(total1).longValue();
        System.out.println("Total:" +total);
        String pk="";
        String totalf = pk+total;
        
        MobileElement fbal = driver.findElement(By.id("txtTransferedBalance"));
        fbal.clear();
        fbal.sendKeys(totalf);
        System.out.println("Final Balance is:" +totalf);
        Thread.sleep(2000);
		driver.findElement(By.className("Transfer_EGT_ok_but")).click();
		Thread.sleep(4000);

		String actual = driver.findElement(By.id("spnValidateBalance")).getText();
	    String expected = "Entered Amount should not be Greater than Current balance!";
	    Assert.assertEquals(actual, expected);
	    Thread.sleep(2000);
 
	    fbal.clear();
	}

	
	@Then("^An error should be displayed if the balance field is empty and player should be blocked from loading the online game$")
	public void an_error_should_be_displayed_if_the_balance_field_is_empty_and_player_should_be_blocked_from_loading_the_online_game() throws Throwable {
		//Cleared the balance above and clicking on transfer button without entering amount
		driver.findElement(By.className("Transfer_EGT_ok_but")).click();
		Thread.sleep(3000);
		
		String expected1 = driver.findElement(By.id("spnValidateBalance")).getText();
	    String actual1 = "Entered Amount is not in correct format!";
	    System.out.println("Validation Message displayed is: " +expected1);
	    Assert.assertEquals(expected1, actual1);
	}
	
	@Then("^An error should be displayed if balance entered was zero and player should be blocked from loading the online game$")
	public void an_error_should_be_displayed_if_balance_entered_was_zero_and_player_should_be_blocked_from_loading_the_online_game() throws Throwable {
		//Clearing value from balance field and sending value as Zero
		MobileElement transfer = driver.findElement(By.id("txtTransferedBalance"));
		transfer.clear();
		transfer.sendKeys("0");
		Thread.sleep(2000);
		driver.findElement(By.className("Transfer_EGT_ok_but")).click();
		Thread.sleep(2000);
		
		String expected2 = driver.findElement(By.id("spnValidateBalance")).getText();
	    String actual2 = "Entered Amount should be greater than Zero!";
	    System.out.println("Validation message displayed is: " +expected2);
	    Assert.assertEquals(expected2, actual2);
	}
	
	@Then("^The exact amount entered in the transfer page should transfer to online game and same amount should get displayed on the balance section$")
	public void the_exact_amount_entered_in_the_transfer_page_should_transfer_to_online_game_and_same_amount_should_get_displayed_on_the_balance_section() throws Throwable {
		MobileElement balT = driver.findElement(By.id("txtTransferedBalance"));
		balT.clear();
		Thread.sleep(1000);
		balT.sendKeys("300");
		Thread.sleep(1000);
		driver.findElement(By.className("Transfer_EGT_ok_but")).click();
		Thread.sleep(1000);
		
		String parent1=driver.getWindowHandle();
		Set<String>s1=driver.getWindowHandles();

		System.out.println("Window for slot game is"+" "+s1);
		 
		Set<String> contx = driver.getContextHandles();
		String pk = driver.getContext();
		//System.out.println("The current contesx is"+" "+pk);
		for(String cont:contx){
			 System.out.println(cont);
		 }
		driver.context("NATIVE_APP");
		Thread.sleep(2000);
		
		WebDriverWait wait2 = new WebDriverWait(driver, 90);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("hud_Hud_txtBalance1")));
		
		String actual3 = driver.findElement(By.id("hud_Hud_txtBalance1")).getText();
		System.out.println("Balance of the online slot game is : "+actual3);
	    String expected3 = "300.00";
	    Assert.assertEquals(actual3, expected3);
	    
	    
	    Thread.sleep(3000);
	    driver.quit();
	}
}