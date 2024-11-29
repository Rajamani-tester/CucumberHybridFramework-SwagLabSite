Feature: Login Page Automation of saucedemo site
Scenario: Check login is successfuly with valid credentials
Given User is on login page
When User enters "<username>" and "<password>"
And Clicks on Login Button
Then User is navigated to Home Page

  Examples:
    | username       | password     |
    | standard_user  | secret_sauce |
    
Scenario: Check login with invalid username and valid password
Given User is on login page
When User enters "<username>" and "<password>"
And Clicks on Login Button
Then An error message is displayed "<error_message>"

  Examples:
    | username       | password     | error_message                                         			|
    | invalid_user   | secret_sauce | Username and password do not match any user in this service |

Scenario: Check login with valid username and invalid password
Given User is on login page
When User enters "<username>" and "<password>"
And Clicks on Login Button
Then An error message is displayed "<error_message>"

	Examples:
    | username       | password     | error_message                                         			|
    | standard_user  | invalid_pass | Username and password do not match any user in this service | 

Scenario: Check login with empty username and valid password
Given User is on login page
When User enters "<username>" and "<password>"
And Clicks on Login Button
Then An error message is displayed "<error_message>"

	Examples:
    | username | password     | error_message              |
    |          | secret_sauce | Username is required       |

Scenario: Check login with valid username and empty password
Given User is on login page
When User enters "<username>" and "<password>"
And Clicks on Login Button
Then An error message is displayed "<error_message>"

	Examples:
    | username       | password | error_message     	 |
    | standard_user  |          | Password is required |

Scenario: Check login with empty username and password
Given User is on login page
When User enters "<username>" and "<password>"
And Clicks on Login Button
Then An error message is displayed "<error_message>"

	Examples:
    | username | password | error_message              |
    |          |          | Username is required       |