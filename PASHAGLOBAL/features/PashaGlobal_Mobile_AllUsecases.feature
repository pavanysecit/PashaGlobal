Feature: Test all the functionalities of Pasha Global in Website
   

		Scenario: Check whether Gamble winning amount is getting added to the main balance after collecting the amount from slot game
    Given Mobile: Chrome browser, valid URL, valid login details, Online games link, balance, transfer button, Play Now link, spin button , win amount, Red button and collect button
    When Mobile: Open any Online slot game by entering the valid URL in browser, enter the valid login details, transfer the amount, click on spin button till user win , Click on Gamble button, Click on Red button and check the balance after Gamble win 
    Then Mobile: Gamble Win amount should get added to the main balance after win and balance should get added to the main balance after closing slot game
    