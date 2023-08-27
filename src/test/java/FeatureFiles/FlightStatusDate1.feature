Feature: Check Flight Status Functionality For CGN-BER Flight With Date 1

  Background:

    Given User is on Home Page

    And Navigate to Check Flight Status Page

      | iUnderstand       |
      | myTrip            |
      | checkFlightStatus |

  Scenario: Check Flight Status

    And Click Departure airport and Enter Airport

    And Click Destination airport and Enter Airport

    And Click Departure date and choose date 1

    And Click Show flight status

    Then Results of the Flight Status Should be Displayed
