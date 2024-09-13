Feature: BKB.ch Login Test

  Scenario: Login with invalid credentials
    Given the user navigates to the BKB homepage
    And the user closes any pop-ups
    When the user clicks on the login button
    And the user enters "a" as Identifikationsnummer
    And the user enters "b" as Passwort
    And the user presses the Login button
    Then a red error pop-up with "Identifikationsnummer oder Passwort ist falsch" is displayed
