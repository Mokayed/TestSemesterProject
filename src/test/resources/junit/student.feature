Feature: Register student

Scenario Outline: Student gets registered
Given a user who is <age> years old
When user tries to register
Then user should get the message <output>

Examples:
|age  |output                                            |
|17   |You must be at least 18 years of age to register  |
|18   |You have been successfully registered             |
|19   |You have been successfully registered             |
|30   |You have been successfully registered             |
|63   |You have been successfully registered             |
|64   |You have been successfully registered             |
|65   |You must be younger than 65 to register           |
|80   |You must be younger than 65 to register           |
|-1   |Invalid age                                       |
|500  |Invalid age                                       |
