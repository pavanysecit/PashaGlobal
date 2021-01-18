Feature: Test all the functionalities of Pasha Global in Website
   

	Scenario: Checking the functionality of Game Info, TryNow and PlayNow button
    Given Chrome browser, valid URL, Go button, valid login details, Online games link, Game Info link, TryNow link and PlayNow link
    When Navigate to pasha global website by entering valid URL, click on online games link, click on Game Info link on any slot game , Click on TryNow link and Click on PlayNow link
    Then Game info page for particular slot game should get displayed
	And TryNow page should get displayed with default balance of 5000
	And PlayNow page should get displayed for that particular game which is clicked