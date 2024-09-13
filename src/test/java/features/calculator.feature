Feature: Calculator Automation

  Scenario Outline: Basic Calculator Operations
    Given the user opens the system calculator
    When the user enters number <num1>
    And the user enters number <num2>
    When the user presses on the <operation> sign
    Then the result is <expectedResult>

    Examples:
      | num1 | num2 | operation | expectedResult |
      | 1    | 2    | +         | 3.00           |
      | 10.5 | 2.5  | -         | 8.00           |
      | 3    | 2    | *         | 6.00           |
      | 8.4  | 2    | /         | 4.20           |
