$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("classpath:hellocucumber.feature");
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
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "user clicks on \u0027see planning period\u0027",
  "keyword": "* "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});