Feature: swag lab test

    @PositiveLogin
    Scenario Outline: login test
      Given Go to this webpage "https://www.saucedemo.com/"
      Then User enter the "<username>" and  "<password>"
      And User click on Login button
      Then Verify inventory page is opend

      Examples:
        | username                | password     |
        | standard_user           | secret_sauce |
        | problem_user            | secret_sauce |
        | performance_glitch_user | secret_sauce |
        | error_user              | secret_sauce |
        | visual_user             | secret_sauce |

    @NegativeLogin
    Scenario Outline: negative login test
      Given Go to this webpage "https://www.saucedemo.com/"
      Then User enter the "<username>" and  "<password>"
      And User click on Login button
      Then Verify error message is displayed

      Examples:
        | username        | password     |
        | standard_user   | secret       |
        | standard        | secret_sauce |
        | locked_out_user | secret_sauce |

  @ShoppingTest
      Scenario Outline: positive test
        Given Go to this webpage "https://www.saucedemo.com/"
        Then User enter the "<username>" and  "<password>"
        And User click on Login button
        Then Click on Add to cart button of "backpack"
        Then Select "Price (high to low)" from the sort container
        And Click on the "1" item
        When Add to cart button is clicked
        Then Click on Remove Button
        And Click on Back to products button
        Then Click on shopping cart container
        And Click on Checkout button
        Then Fill the "Norah" and "Aziz" and "12345" and Click on Continue button
        When Finish button is clicked
        Then Verify "Thank you for your order!" message displayed
        And Click on logout button from menu button

        Examples:
          | username                | password     |
          | standard_user           | secret_sauce |
          | performance_glitch_user | secret_sauce |
          | visual_user             | secret_sauce |

  @errorUser
  Scenario Outline: error user test
    Given Go to this webpage "https://www.saucedemo.com/"
    Then User enter the "<username>" and  "<password>"
    And User click on Login button
    Then Click on Add to cart button of "backpack"
    Then Select "Price (high to low)" from the sort container
    And Click on the "1" item

    Examples:
      | username   | password     |
      | error_user | secret_sauce |

  @problemUser
  Scenario Outline: problem user test
    Given Go to this webpage "https://www.saucedemo.com/"
    Then User enter the "<username>" and  "<password>"
    And User click on Login button
    Then Click on Add to cart button of "backpack"
    Then Select "Price (high to low)" from the sort container
    And Click on the "1" item
    When Add to cart button is clicked
    Then Click on Remove Button

    Examples:
      | username     | password     |
      | problem_user | secret_sauce |





