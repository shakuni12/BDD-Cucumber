Feature: As a user I want to sign up in Application, if not already registered.

@signup
Scenario Outline: SignUp from Welcome to yocket
Given open url
When Enter user email "<email>"
When Click next button
And Click continue
When Enter first name "<fname>"
When Enter last name "<lname>"
When Enter user email "<email2>" 
When Enter phone "<phone>"
When Enter password "<password>"
Then Name fields error "<message>" displays
And Email fields error "<message2>" displays
And Phone fields error "<message3>" displays
And Password fields error "<message4>" displays

Examples: 
|email            |fname |lname   |phone     |password  |email2     |message                                                    |message2                  |message3                  |message4                                        |
|palash@email.com |1234  |1234    |91234343  |Tes       |automation |The first name field may only contain alphabetic characters|Please enter a valid email|Please enter a valid phone|The password field must be at least 7 characters|

 


 