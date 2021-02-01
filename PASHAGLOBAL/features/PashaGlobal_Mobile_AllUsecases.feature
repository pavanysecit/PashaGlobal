Feature: Test all the functionalities of Pasha Global in Website
   
		
		
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
    
    
   # Win amount added to card balance when login via card
   #  Mobile_OnlineGames_CardBalance_Check_WinAmount_AddedToBalance

    Scenario: Check whether winning amount is getting added to the main card balance after collecting the amount from slot game when logged via card
    Given Mobile: Chrome browser, valid URL, valid Card login details, Online games link, balance, transfer button, Play Now link, spin button and win amount
    When Mobile: Open any Online slot game by entering the valid URL in browser, enter the Card valid login details, transfer the amount to slot game, click on spin button till user win and check the balance after win 
    Then Mobile: Win amount should get added to the main slot balance after win and balance should get added to the main account card balance after closing slot game
    
    
     #Gamble win amount added to card balance when login via card
     # Mobile_OnlineGames_CardBalance_Check_GambleWinAmount_AddedToBalance

    Scenario: Check whether Gamble winning amount is getting added to the main card balance after collecting the amount from slot game when logged via card
    Given Mobile: Chrome browser, valid URL, valid Card login details, Online games link, balance, transfer button, Play Now link, spin button , win amount, Red button and collect button
    When Mobile: Open any Online slot game by entering the valid URL in browser, enter the valid Card login details, transfer the amount, click on spin button till user win , Click on Gamble button, Click on Red button and check the balance after Gamble win 
    Then Mobile: Gamble Win amount should get added to the game main balance after win and balance should get added to the main card balance after closing slot game
	
	
	
	# main balance refresh after online games opened
    #   Mobile_OnlineGame_CardMainBalance_RefreshBalance_MultipleGame_Sessions

     Scenario: Check whether multiple game sessions is allowed and the main balance after login in to game session before and after refreshing the main balance
    Given Mobile: Chrome browser, valid URL, valid Card login details, Online games link, main balance, transfer button, Play Now link, spin button , multiple tabs and game sessions
    When Mobile: Open any Online slot game by entering the valid URL in browser, enter the valid Card login details, transfer the amount, click on spin button and check the main updated pasha global balance and open another game sessions and play the game and switch to old game session
    Then Mobile: Main Pasha Balance has to be updated to the latest balance 
    Then Mobile: New session created and user is allowed to place bet and change over to older sessions should result in 'Session Closed' error popup and game should be terminated
    
	
	
	# Multiple Game sessions in EGT games
	# Mobile_OnlineGame_CardBalance_EGT_Multiple_GameSessions_Validations

	 Scenario: Check whether multiple game sessions is allowed in EGT slot games
    Given Mobile: Chrome browser, valid URL, valid Card login details, Online games link, main balance, transfer button, EGT Play Now link, spin button , multiple game link, user error message
    When Mobile: Open any online slot game by entering the valid URL in browser, enter the valid Card login details, transfer the amount, click on spin button and try to open new EGT games and transfer balance to the game
    Then Mobile: New Game Sessions created should not be allowed and 'Pending fund transfers, please try after few mins!' error message to be displayed to user for disabled creation of new game sessions in EGT games
    
	
	# Fetch the account summary of the user 
	# Mobile_OnlineGame_CardBalance_AccountSummaryDetails_Validation

	 Scenario: Check whether Account Summary is able to fetch for the particular logged in user
    Given Mobile: Chrome browser, valid URL, valid Card login details, Online games link, main balance, Account Summary tab, print button and PDF file
    When Mobile: Open any online slot game by entering the valid URL in browser, enter the valid Card login details, click on Account and print the account summary 
    Then Mobile: Verify the fetched Account Summary deatils is for the logged account  
  
	
	# Verifying the session login and logoff state after navigating to different modules 
	# Mobile_OnlineGames_CardBalance_Login_LogOff_Validations
	
    Scenario: Check whether Account state after navigating to all modules and after logout navigating to any modules are not allowed
    Given Mobile: Chrome browser, valid URL, valid Card login details, Online games link, main balance, Account ID, Log off, other modules
    When Mobile: Login to the Pasha Global account and navigate to online game and later to home and verify the account state and after logout from Pasha Global navigate and online Games 
    Then Mobile: Verify whether the account is logged off automatically
    Then Mobile: Verify after log off from the Pasha Global navigate to home and online games and verify the account state shoudn't login automatically
	
	
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
    
    
    # Edit user profile and submit and verify for the updated profile in the account summary tab
    # Mobile_OnlineGames_ProfileUpdate_Validation

    Scenario: Check whether updating the profile is being reflected in account summary tab
    Given Mobile: Chrome browser, valid URL, valid login details, Profile link, profile tab password, Profile update tab, submit button, successfull message
    When Mobile: Open any Online slot game by entering the valid URL in browser, enter the valid login details, click on profile link and fill the login credentials and update the profile summary 
    Then Mobile: Fill the profile link with invalid credentials and validate the user message 
    Then Mobile: Updated profile must be reflected in the same Profile tab 
