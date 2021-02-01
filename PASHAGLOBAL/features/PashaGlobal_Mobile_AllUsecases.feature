Feature: Test all the functionalities of Pasha Global in Website
   


   Scenario: Load the pasha global website with valid URL
    Given  Mobile: Chrome browser, pasha global valid URL and Go button 
    When Mobile: Open the chrome browser, Enter the valid  pasha global URL and click on Go button
    Then Mobile: User should be able to see the pasha global logo after login
	
	Scenario: Login with valid Online account details for authentication for suribet client
    Given Mobile: Chrome browser, valid URL, Go button, pasha global valid account id, valid password and login button
    When Mobile: Open the chrome browser, Enter the valid URL, click on Go button, click on login button, enter valid account id & password and click on Login butotn
    Then Mobile: User should be able to login website successfully post entering valid online account details and online account balance should be displayed  for suribet client
	
	Scenario: Mobile: Login with Invalid Online account details for authentication for suribet client
    Given Mobile: Chrome browser, valid URL, Go button, Invalid account id, valid password and login button for suribet client
    When Mobile: Open the chrome browser, Enter the valid URL, click on Go button, click on login button, enter invalid account id & password and click on Login button for suribet client
    Then Mobile: User should be failed to login the website post entering invalid account details for suribet client
	
	
	Scenario: Login with valid Email account details for authentication for suribet client
    Given Mobile: Chrome browser, valid URL, Go button, valid email id, valid password and login button
    When Mobile: Open the chrome browser, Enter the valid URL, click on Go button, click on login button, enter valid email id & password and click on Login butotn
    Then Mobile: User should be able to login to website successfully post entering valid email account details and balance should be displayed
	
	Scenario: Login with Invalid email account details for authentication for suribet client
    Given Mobile: Chrome browser, valid URL, Go button, Invalid email id, valid password and login button for suribet client
    When Mobile: Open the chrome browser, Enter the valid URL, click on Go button, click on login button,, enter invalid email id & password and click on Login butotn
    Then Mobile: User should be failed to login to the website post entering invalid email id
	
	Scenario: Login with valid mobile number for authentication for suribet client
    Given Mobile: Chrome browser, valid URL, Go button, valid mobile number, valid password and login button for suribet client
    When Mobile: Open the chrome browser, Enter the valid URL, click on Go button, click on login button, enter valid mobile number & password and click on Login butotn  for suribet client
    Then Mobile: User should be able to login to pasha global website successfully post entering valid mobile number and balance should be displayed for suribet client
	
	Scenario: Login with Invalid mobile number for authentication for suribet client
    Given Mobile: Chrome browser, valid URL, Go button, Invalid mobile number, valid password and login button for suribet client
    When Mobile:  Open the chrome browser, Enter the valid URL, click on Go button, click on login button, enter invalid mobile number & password and click on Login butotn for suribet client
    Then Mobile: User should be failed to login to the website post entering invalid mobile number for suribet client
	
	Scenario: Mobile: Login with valid card details for authentication for suribet client
    Given Mobile: Chrome browser, valid URL, Go button, valid card number, valid card pin and login button
    When Mobile: Open the chrome browser, Enter the valid URL, click on Go button, click on login button, enter valid card number & valid card pin and click on Login butotn
    Then Mobile: User should be able to login to website successfully post entering valid card details and card balance should be displayed
	
	Scenario: Login with Invalid card details for authentication for suribet client
    Given Mobile: Chrome browser, valid URL, Go button, Invalid card number, card pin and login button
    When Mobile: Open the chrome browser, Enter the valid URL, click on Go button, click on login button, enter invalid card number & card pin and click on Login butotn
    Then Mobile: User should be failed to login to the website post entering invalid card details for suribet client
#	
#	
#	
#	Scenario: Register for pasha global website with existing user detaisl for suribet client
    #Given Mobile: Chrome browser, valid URL, Go button, Register link, mobile no, email id, captcha code and register now button
    #When Mobile: Navigate to pasha global website by entering valid URL, click on Register button, enter all the mandatory details and click on register now button
    #Then Mobile: User should be fail to register with existing mobile no and validation message needs to be displayed for failure
#
#
#
#
#
#	Scenario: Verify online games categories into Slots, Fuit, Cards and Roulettes 
    #Given Mobile: Chrome browser, valid URL, Go button, valid login details, Online games link and different tabs for each game categories
    #When Mobile: Navigate to pasha global website by entering valid URL, click on online games link and click on each tab to find out category
    #Then Mobile: User should able to navigate to different tabs for each category
#	
#	
#	Scenario: Checking the functionality of Game Info and PlayNow button
    #Given Mobile: Chrome browser, valid URL, Go button, valid login details, Online games link, Game Info link and PlayNow link
    #When Mobile: Navigate to pasha global website by entering valid URL, click on online games link, click on Game Info link on any slot game and Click on PlayNow link
    #Then Mobile: Game info page for particular slot game should get displayed
#	And Mobile: PlayNow page should get displayed for that particular game which is clicked
#	
#	Scenario: Checking the functionality of Try Nnow button and default balance
    #Given Mobile: Chrome browser, valid URL, Go button, valid login details, Online games link, Try Now link and default balance
    #When Mobile: Navigate to pasha global website by entering valid URL, click on online games link, click on Try Now link on any slot game and check balance
    #Then Mobile: Try Now page should get loaded along with default balance of 5000