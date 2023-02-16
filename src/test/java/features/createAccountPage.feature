Feature: user create new account

  Background:
    Given navigate to website "https://magento.softwaretestingboard.com/customer/account/create/"

    Scenario Outline: Different users create
      And fill first name "<first name>"
      And fill last name "<last name>"
      And click to sign up
      And fill email "<e-mail name>"
      And fill password "<password>"
      And fill confirm password "<confirm password>"
      When click create new account
      Then verify create new account "Thank you for registering with Fake Online Clothing Store."

      Examples:
        | first name | last name | e-mail name             | password   | confirm password    |
        | Can        | Guclu     | deneme1923564@gmail.com | Deneme1234 | Deneme1234          |
        | Mert       | Kosar     | deneme19134563@gmail.com| Deneme1134 | Deneme1134          |
