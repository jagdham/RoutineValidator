Feature: Routine Checker

  Scenario Outline: The routine must first ensure that the associated dates do not run backwards
    Given I have "<firstRoutine>" "<adjustment>" and "<finalBill>"
    Then Validator should return <expectedCode>
    Examples:
      | firstRoutine | adjustment   | finalBill    | expectedCode |
      | "2022-12-10" | "2022-12-05" | "2022-12-15" | 99           |
      | "2022-12-10" | "2022-12-15" | "2022-12-05" | 99           |

  Scenario Outline: The routine checker verifies return code according to amount variation
    Given I have three amount as <amount1>, <adjustment> and <finalAmount>
    Then It should return <expectedCode> as per amount rule
    Examples:
      | amount1 | adjustment | finalAmount | expectedCode |
      | 100     | 5          | 105         | 11           |
      | 100     | -5         | 95          | 22           |
      | 100     | 0          | 100         | 3            |
