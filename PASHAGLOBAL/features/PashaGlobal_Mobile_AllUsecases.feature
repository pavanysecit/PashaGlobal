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
	
	
		Scenario: Check change password functionalities with valid inputs and invalid inputs
    Given Mobile: Chrome browser, valid URL, valid login details, Online games link, change password window, old password textbox, new password textbox, confirm password textbox and submit button
    When Mobile: Open any Online slot game by entering the valid URL in browser, enter the valid login details, click on change password link, enter old password, enter new password, enter confirm password and click on submit button
    Then Mobile: System should display validation message for entering wrong old password
	And Mobile: System should display validation message if new password and confirm password are not same
	And Mobile: System should display validation message if the entered password doesn't meet the password policy rules
	And Mobile: Password should get changed successfully and confirmation message should be displayed if all the entered data is correct and meets the password policy rules
	
	
		Scenario: Verify online games categories into Slots, Fuit, Cards and Roulettes 
    Given Mobile: Chrome browser, valid URL, Go button, valid login details, Online games link and different tabs for each game categories
    When Mobile: Navigate to pasha global website by entering valid URL, click on online games link and click on each tab to find out category
    Then Mobile: User should able to navigate to different tabs for each category
	
	
	Scenario: Checking the functionality of Game Info and PlayNow button
    Given Mobile: Chrome browser, valid URL, Go button, valid login details, Online games link, Game Info link and PlayNow link
    When Mobile: Navigate to pasha global website by entering valid URL, click on online games link, click on Game Info link on any slot game and Click on PlayNow link
    Then Mobile: Game info page for particular slot game should get displayed
	And Mobile: PlayNow page should get displayed for that particular game which is clicked
	
	Scenario: Checking the functionality of Try Nnow button and default balance
    Given Mobile: Chrome browser, valid URL, Go button, valid login details, Online games link, Try Now link and default balance
    When Mobile: Navigate to pasha global website by entering valid URL, click on online games link, click on Try Now link on any slot game and check balance
    Then Mobile: Try Now page should get loaded along with default balance of 5000
	
	
		Scenario: Checking whether balance is refreshing automatically after transferring the balance
    Given Mobile: Chrome browser, valid URL, Go button, valid login details, Online games link, Play Now link and  balance refresh
    When Mobile: Navigate to pasha global website by entering valid URL, click on online games link, click on Play Now link on any slot game and go back to main page
    Then Mobile: Transeffered amount to slot game should be deducted in the main balance and should be auto refreshed after 3 seconds
	
		Scenario: Check whether winning amount is getting added to the main balance after collecting the amount from slot game
    Given Mobile: Chrome browser, valid URL, valid login details, Online games link, balance, transfer button, Play Now link, spin button and win amount
    When Mobile: Open any Online slot game by entering the valid URL in browser, enter the valid login details, transfer the amount, click on spin button till user win and check the balance after win 
    Then Mobile: Win amount should get added to the main balance after win and balance should get added to the main balance after closing slot game
	

	Scenario: Check basic validations for login & logoff scenarios and home page validations
    Given Mobile: Chrome browser, valid URL, valid login details, Online games link, balance, transfer button, Play Now link, home button, login and logout buttons
    When Mobile: Open any Online slot game by entering the valid URL in browser, enter the valid login details, transfer the amount, click on logoff button, click on home butotn and login button
    Then Mobile:After login, refresh the balance and check it should be same on clicking on refresh button 
	And Mobile:After navigating to home page from online games, it should not logout automatically
	And Mobile:After logout, navigating from home page to online games, it should not login automatically
	And Mobile:Based on the selected category, games should be display under each category like Slots, Fruits, Cards and Roulettes
	
	
	Scenario: To check the transferred amount is added to online game balance and its related validation messages
    Given Chrome browser, valid URL, valid login details, online games, balance, text field to transfer balance and Ok button
    When Open the any online slot game by entering the valid URL in browser, enter the valid login details, click on Play button, enter the valid amount to transfer and click on Ok butotn
    Then Player should be blocked from loading the online game when the amount entered in the transfer page is more than the available balance
	And An error should be displayed if the balance field is empty and player should be blocked from loading the online game
	And An error should be displayed if balance entered was zero and player should be blocked from loading the online game
	And The exact amount entered in the transfer page should transfer to online game and same amount should get displayed on the balance section


	Scenario: To check the transferred amount from card login is added to online game balance and its related validation messages
    Given Chrome browser, valid URL, valid login details, online games, balance, Card login, text field to transfer balance and Ok button
    When Open the any online slot game by entering the valid URL in browser, enter the valid login details, click on Play button, switch to card login, enter the valid amount to transfer and click on Ok butotn
    Then Player should be blocked from loading the online game when the amount entered in the transfer page from card login is more than the available balance
	And An error should be displayed if the balance field is empty and player should be blocked from loading the online game from card login
	And An error should be displayed if balance entered was zero and player should be blocked from loading the online game from card login
	And The exact amount entered in the transfer page from card login should  get transferred to online game and same amount should get displayed on the balance section


    Scenario: Check whether updating the profile is being reflected in account summary tab
    Given Mobile: Chrome browser, valid URL, valid login details, Profile link, profile tab password, Profile update tab, submit button, successfull message
    When Mobile: Open any Online slot game by entering the valid URL in browser, enter the valid login details, click on profile link and fill the login credentials and update the profile summary 
    Then Mobile: Fill the profile link with invalid credentials and validate the user message 
    Then Mobile: Updated profile must be reflected in the same Profile tab 

	

	 # Multiple tabs operation
     #Mobile_OnlineGame_Multiptile_LoginSessions

    Scenario: Check whether Multiple YGT game window can be played simultaneously
    Given Mobile: Chrome browser, valid URL, valid login details, Online games link, balance, transfer button, Play Now link, spin button , another game window tab
    When Mobile: Open any Online slot game by entering the valid URL in browser, enter the valid login details, transfer the amount, click on spin button, open another tab and open game and play ion new tab and switch back to older session  
    Then Mobile: older session would be terminated with error message 'Session already closed due to multiple logins or network issue' and user is allowed to play with current session in slot game
    
    
    #  Payment mode--- Card
    #  Mobile_OnlineGame_Cardmode_Transaction

    Scenario: Login with valid login details and switch to card mode of playable and verify switch dropdowns to switch back to online playable  
    Given Mobile: Chrome browser, valid URL, Valid login credentials, card details login, and authenticated card 
    When Mobile: Open the chrome browser, Enter the valid URL, Login via email or phone number mode and switch to card mode of transaction for further playable
    Then Mobile: Verify the balance in card before and after switching the mode of transacations
    Then Movile: Verify the balance after reloading/refresh the balance in card mode of transcations
    Then Mobile: Verify if the used is allowed again to switch to online mode of transactions  for suribet client
	
	
	
	# Card balance under different login methods
    # Mobile_OnlineGame_CardBalance_Validations_UnderDifferentLoginModes

    Scenario: Login with valid differerent login credentails linking to same account and verify the card balance is same across all modes of login methods
    Given Mobile: Chrome browser, valid URL, different Valid login credentials, card details login, card balance and refresh button
    When Mobile: Open the chrome browser, Enter the valid URL, Login via email and switch to card mode of transaction for further playable
    Then Mobile: Verify the balance in card before and logoff from the session
    Then Movile: Login to the account via card mode and verify the balance 
    Then Mobile: Card balance must be same across different login modes for same account ID in suribet client
	
	
	# Fetch the account summary of the user 
	# Mobile_OnlineGame_CardBalance_AccountSummaryDetails_Validation

	 Scenario: Check whether Account Summary is able to fetch for the particular logged in user
    Given Mobile: Chrome browser, valid URL, valid Card login details, Online games link, main balance, Account Summary tab, print button and PDF file
    When Mobile: Open any online slot game by entering the valid URL in browser, enter the valid Card login details, click on Account and print the account summary 
    Then Mobile: Verify the fetched Account Summary deatils is for the logged account  
	

	
	# Multiple Game sessions in EGT games
	# Mobile_OnlineGame_CardBalance_EGT_Multiple_GameSessions_Validations

	 Scenario: Check whether multiple game sessions is allowed in EGT slot games
    Given Mobile: Chrome browser, valid URL, valid Card login details, Online games link, main balance, transfer button, EGT Play Now link, spin button , multiple game link, user error message
    When Mobile: Open any online slot game by entering the valid URL in browser, enter the valid Card login details, transfer the amount, click on spin button and try to open new EGT games and transfer balance to the game
    Then Mobile: New Game Sessions created should not be allowed and 'Pending fund transfers, please try after few mins!' error message to be displayed to user for disabled creation of new game sessions in EGT games
    
	
	# Verifying the session login and logoff state after navigating to different modules 
	# Mobile_OnlineGames_CardBalance_Login_LogOff_Validations
	
    Scenario: Check whether Account state after navigating to all modules and after logout navigating to any modules are not allowed
    Given Mobile: Chrome browser, valid URL, valid Card login details, Online games link, main balance, Account ID, Log off, other modules
    When Mobile: Login to the Pasha Global account and navigate to online game and later to home and verify the account state and after logout from Pasha Global navigate and online Games 
    Then Mobile: Verify whether the account is logged off automatically
    Then Mobile: Verify after log off from the Pasha Global navigate to home and online games and verify the account state shoudn't login automatically
	
	
	# main balance refresh after online games opened
    #   Mobile_OnlineGame_CardMainBalance_RefreshBalance_MultipleGame_Sessions

     Scenario: Check whether multiple game sessions is allowed and the main balance after login in to game session before and after refreshing the main balance
    Given Mobile: Chrome browser, valid URL, valid Card login details, Online games link, main balance, transfer button, Play Now link, spin button , multiple tabs and game sessions
    When Mobile: Open any Online slot game by entering the valid URL in browser, enter the valid Card login details, transfer the amount, click on spin button and check the main updated pasha global balance and open another game sessions and play the game and switch to old game session
    Then Mobile: Main Pasha Balance has to be updated to the latest balance 
    Then Mobile: New session created and user is allowed to place bet and change over to older sessions should result in 'Session Closed' error popup and game should be terminated
	
	
	# Win amount added to card balance when login via card
    #  Mobile_OnlineGames_CardBalance_Check_WinAmount_AddedToBalance

    Scenario: Check whether winning amount is getting added to the main card balance after collecting the amount from slot game when logged via card
    Given Mobile: Chrome browser, valid URL, valid Card login details, Online games link, balance, transfer button, Play Now link, spin button and win amount
    When Mobile: Open any Online slot game by entering the valid URL in browser, enter the Card valid login details, transfer the amount to slot game, click on spin button till user win and check the balance after win 
    Then Mobile: Win amount should get added to the main slot balance after win and balance should get added to the main account card balance after closing slot game
	

	Scenario: Check whether Gamble winning amount is getting added to the main balance after collecting the amount from slot game
    Given Mobile: Chrome browser, valid URL, valid login details, Online games link, balance, transfer button, Play Now link, spin button , win amount, Red button and collect button
    When Mobile: Open any Online slot game by entering the valid URL in browser, enter the valid login details, transfer the amount, click on spin button till user win , Click on Gamble button, Click on Red button and check the balance after Gamble win 
    Then Mobile: Gamble Win amount should get added to the main balance after win and balance should get added to the main balance after closing slot game
    
    
     #Gamble win amount added to card balance when login via card
     # Mobile_OnlineGames_CardBalance_Check_GambleWinAmount_AddedToBalance

    Scenario: Check whether Gamble winning amount is getting added to the main card balance after collecting the amount from slot game when logged via card
    Given Mobile: Chrome browser, valid URL, valid Card login details, Online games link, balance, transfer button, Play Now link, spin button , win amount, Red button and collect button
    When Mobile: Open any Online slot game by entering the valid URL in browser, enter the valid Card login details, transfer the amount, click on spin button till user win , Click on Gamble button, Click on Red button and check the balance after Gamble win 
    Then Mobile: Gamble Win amount should get added to the game main balance after win and balance should get added to the main card balance after closing slot game
	
	
	

    
	
	

  
	

	
	
     #Login to super bet with valid mail and account id 
    # Mobile_Superbet_Login_AccountId_CardNo_ValidCredentials_Success

	Scenario: Check the valid logins for the super bet client
    Given Mobile: Chrome browser, valid URL, Go button, pasha global(super bet) valid account id, valid password and login button
    When Mobile:Open the chrome browser, Enter the valid URL, click on Go button, select the super bet client,  click on login button, enter valid account id & password  with both mail and account id and click on Login butotn 
    Then Mobile: User should be able to login website successfully post entering valid online account details and online account balance should be displayed  for superbet client 
  
   # Invalid logins validations       
   # Mobile_Superbet_InValidLogin_AccountId_CardNo_ValidCredentials_Failure

	Scenario: Check the Invalid logins for the super bet client
    Given Mobile: Chrome browser, valid URL, Go button, pasha global(super bet) Invalid account id, Invalid password and login button
    When Mobile:Open the chrome browser, Enter the valid URL, click on Go button, select the super bet client,  click on login button, enter Invalid account id & password  with both mail and account id and click on Login butotn 
    Then Mobile: User should not be able to login website successfully post entering defined error message should be addressed for user in superbet client 
     
    
    
     # Win amount added to balance for super bet client
     # Mobile_OnlineGames_SuperBet_Balance_Check_WinAmount_AddedToBalance

    Scenario: Check whether winning amount is getting added to the main balance after collecting the amount from slot game in super bet client
    Given Mobile: Chrome browser, valid URL, login details, Online games link, balance, transfer button, Play Now link, spin button and win amount in super bet client
    When Mobile: Open any Online slot game by entering the valid URL in browser, enter valid login details, transfer the amount to slot game, click on spin button till user win and check the balance after win in super bet
    Then Mobile: Win amount should get added to the main slot balance after win and balance should get added to the main account card balance after closing slot game in superbet client
  
    
     #Gamble win amount added to balance for superbet client
    # Mobile_OnlineGames_SuperBet_Balance_Check_GambleWinAmount_AddedToBalance

    Scenario: Check whether Gamble winning amount is getting added to the main balance after collecting the amount from slot game when logged for superbet client
    Given Mobile: Chrome browser, valid URL, valid superbet client login details, Online games link, balance, transfer button, Play Now link, spin button , win amount, Red button and collect button
    When Mobile: Open any Online slot game by entering the valid URL in browser, enter the valid super bet login details, transfer the amount, click on spin button till user win , Click on Gamble button, Click on Red button and check the balance after Gamble win 
    Then Mobile: Gamble Win amount should get added to the game main balance after win and balance should get added to the main  balance after closing slot game in superbet client
    
    


    

    
	Scenario: Register for pasha global website with existing user detaisl for suribet client
    Given Mobile: Chrome browser, valid URL, Go button, Register link, mobile no, email id, captcha code and register now button
    When Mobile: Navigate to pasha global website by entering valid URL, click on Register button, enter all the mandatory details and click on register now button
    Then Mobile: User should be fail to register with existing mobile no and validation message needs to be displayed for failure
	
	
	Scenario: Check Balance refresh when network issue occured
    Given Mobile: Chrome browser, valid URL, valid login details, Online games link, balance, transfer button, Play Now link and wifi button
    When Mobile: Open any Online slot game by entering the valid URL in browser, enter the valid login details, transfer the amount, check balance, turn off wifi & turn on wifi after few min, and check amount added to balance
    Then Mobile: Slot game balance should get added to the main balance after wifi turn off and turn off