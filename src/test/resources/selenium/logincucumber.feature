Feature: Login 

Scenario Outline: Login
Given the user <user>
Given the password <password>
Given the role <role>
When logs in
Then the page header should be <output>

Examples:
|user     |password   |role     |output |
|Hallur   |123        |Student  |Student|
|Kasper   |123        |Teacher  |Teacher|
|Mo       |1234       |Admin    |Admin  |
