$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("classpath:course.feature");
formatter.feature({
  "name": "Delete a Course",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Course is deleted",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "user navigates to courses page",
  "keyword": "* "
});
formatter.match({
  "location": "TestCoursePage.navigatePage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on course 1",
  "keyword": "* "
});
formatter.match({
  "location": "TestCoursePage.user_clicks_on_course()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on delete",
  "keyword": "* "
});
formatter.match({
  "location": "TestCoursePage.user_clicks_on_delete()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "course should be successfully deleted",
  "keyword": "* "
});
formatter.match({
  "location": "TestCoursePage.course_should_be_successfully_deleted()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("classpath:hellocucumber.feature");
formatter.feature({
  "name": "Planning functionality Feature",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Login Functionality",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "user navigates to the teacher page",
  "keyword": "* "
});
formatter.match({
  "location": "PlanningSeleniumTests.navigatePage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on \u0027see planning period\u0027",
  "keyword": "* "
});
formatter.match({
  "location": "PlanningSeleniumTests.clickBtn()"
});
formatter.result({
  "status": "passed"
});
});