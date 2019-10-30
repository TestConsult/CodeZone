Feature: NHS Cost Checker functionality
  As a person from wales
  I need to know what help I can get with my NHS cost
  So that I can get the treatment I need

  @wip
  Scenario: Health cost for a person from wales
    Given I am person from wales
    When I put my circumstances in the checker tool
    Then I should get a result whether I will get help or not

