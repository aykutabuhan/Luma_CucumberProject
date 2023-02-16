Feature: User select product size, color, qty and add cart

  Background:
    Given navigate to website "https://magento.softwaretestingboard.com/marco-lightweight-active-hoodie.html"

    Scenario Outline: Different details select
      And select size "<size>"
      And select random any color
      And select quantities of product "<qty>"
      When click add to cart
      Then verify add to cart with message
      Examples:
        | size | qty |
        | xs   | 1   |
        | s    | 3   |
        | m    | 2   |
        | l    | 5   |
        | xl   | 4   |

