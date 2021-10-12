Feature: Realty Registraion


    #Background:
    #Given  User Should navigate to Realty Application and Click on login or registerTab

   
    Scenario Outline: Verify whether application allows the user to get registered upon entering valid credentials
        Given User Should navigate to Realty Application and Click on login or registerTab
        When  Click on register tab and Enter valid cradentials in "<Email>" "<FirstName>" "<LastName>"
        And   Click on register button
        Then  User should successfully registered to real estate 
        |You have successfully registered to Real Estate. We have emailed your password to the email address you entered.|
        And User close the browser
        
        Examples:
        |Email|FirstName|LastName|
        |bhavana9876@gmail.com|bhavana|Sanu|
        
      
    Scenario Outline: Verify whether application allows registered user to login into application
        Given User Should navigate to Realty admin Application and Click on login or registerTab
        When   User in login page Enter valid cradentials in "<UserName>" "<Password>" 
        And    Click on Signin 
        Then  User Should landed to Dashboard page
        |Dashboard ‹ Real Estate — WordPress|
        And User close the browser
         
         Examples:
        |UserName|Password|
        |admin|admin@123|
        
       
    #Realty appilcation not working for recover password
    Scenario: Verify whether application allows the user to recover the password
          Given User Should navigate to realty Application and Click on login or registerTab
          When User in login page Click on Lost password
          And  Password page should be displayed and Enter valid "<email>"
          And   Click on Reset Password 
          Then  Click on confirmation link received from the application in the registered email
          
          Examples:
          |email|
          |bhavana@gmail.com|
          
          