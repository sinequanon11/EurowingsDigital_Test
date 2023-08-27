Feature: Check Flight Status Functionality For EDI-HAM Flight

  Background:

    Given User is on Home Page

    And Navigate to Check Flight Status Page

      | iUnderstand       |
      | myTrip            |
      | checkFlightStatus |

  Scenario: Check Flight Status

    And Click Departure airport and Enter Other Airport

    And Click Destination airport and Enter Other Airport

    And Click Departure date and choose date 1

    And Click Show flight status

    Then No Result for This Flight Message Should be Displayed
