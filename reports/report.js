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
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"id\",\"selector\":\"planBtn\"}\n  (Session info: chrome\u003d74.0.3729.108)\n  (Driver info: chromedriver\u003d74.0.3729.6 (255758eccf3d244491b8a1317aa76e1ce10d57e9-refs/branch-heads/3729@{#29}),platform\u003dLinux 4.18.0-18-generic x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 11 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.28.0\u0027, revision: \u002718309\u0027, time: \u00272012-12-11 15:53:30\u0027\nSystem info: os.name: \u0027Linux\u0027, os.arch: \u0027amd64\u0027, os.version: \u00274.18.0-18-generic\u0027, java.version: \u00271.8.0_191\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{mobileEmulationEnabled\u003dfalse, timeouts\u003d{implicit\u003d0, pageLoad\u003d300000, script\u003d30000}, hasTouchScreen\u003dfalse, platform\u003dLINUX, acceptSslCerts\u003dfalse, goog:chromeOptions\u003d{debuggerAddress\u003dlocalhost:45273}, acceptInsecureCerts\u003dfalse, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, setWindowRect\u003dtrue, unexpectedAlertBehaviour\u003dignore, applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d74.0.3729.6 (255758eccf3d244491b8a1317aa76e1ce10d57e9-refs/branch-heads/3729@{#29}), userDataDir\u003d/tmp/.com.google.Chrome.13LvsK}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, strictFileInteractability\u003dfalse, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, version\u003d74.0.3729.108, browserConnectionEnabled\u003dfalse, proxy\u003d{}, nativeEvents\u003dtrue, locationContextEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: e8a3181d001cc7227c92a673cc044898\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:187)\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:145)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:533)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:302)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:331)\n\tat org.openqa.selenium.By$ById.findElement(By.java:216)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:294)\n\tat PlanningSeleniumTests.clickBtn(PlanningSeleniumTests.java:40)\n\tat ✽.user clicks on \u0027see planning period\u0027(classpath:hellocucumber.feature:6)\n",
  "status": "failed"
});
});