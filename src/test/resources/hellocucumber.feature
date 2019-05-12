Feature: Planning

Scenario Outline: Get Days Difference
Given the teacher-date <date1>
Given the semester-date <date2>
When the teacher logs in
Then the days difference should be <output>

Examples:
|date1      |date2     |output|
|2019-06-01 |2019-08-01|30    |
