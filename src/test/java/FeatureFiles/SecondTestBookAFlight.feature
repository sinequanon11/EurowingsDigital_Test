Feature: Flight Booking Functionality

  Scenario: Verification of Booking Flight Functionality

    Given User is on Home Page

    And Click I understand

    And Select Departure airport Destination airport and Date

    And Click Search for flights

    And Select Type of Flight

    And Click Continue button

    And Click Continue to Services button

    And Click Continue button 2

    And Select Gender and Enter Name and Surname

    And Click Continue button

    And Click Continue button

    Then Payment Page Should be Displayed