
@tag
Feature: Error Validation
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce Page
    When Logged In with the <username> and <password>
    Then verify the success message "Incorrect email or password."

    Examples: 
      | username  								| password 				  | product       |
      | priyanshu12@gmail.com 		|     123@Abc$    	| ZARA COAT 3 	|
