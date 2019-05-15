package selenium;

import Entities.User;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en_old.Ða;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mok
 */
@RunWith(MockitoJUnitRunner.class)
public class LogSelTest {

    WebDriver driver;
    String userName;
    String password;
    String role;
    String pageHeader;

    @Given("^the user (.*?)$")
    public void getUserName(String userName) throws ParseException {
        this.userName = userName;
    }

    @Given("^the password (.*?)$")
    public void getPassword(String password) throws ParseException {
        this.password = password;
    }

    @Given("^the role (.*?)$")
    public void getRole(String role) throws ParseException {
        this.role = role;
    }

    @When("^logs in$")
    public void login() throws InterruptedException {
        User user = new User(role, userName, password);
        if (System.getProperty("os.name").startsWith("Linux")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
        } else if (System.getProperty("os.name").startsWith("Windows")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
        }
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/TestSemesterProject/");
        List<WebElement> rows = driver.findElements(By.tagName("input"));
        rows.get(0).sendKeys(user.getUserName());
        rows.get(1).sendKeys(user.getPassword());
        //Thread.sleep(1000);
        rows.get(2).click();
        pageHeader = driver.findElement(By.name("user")).getText();
        System.out.println("11111111111111111doiwjdiojiodjaiodjoidjoiwjdoijwdo111"+pageHeader);
        Thread.sleep(1000);
        //driver.findElement(By.id("planBtn")).click();

    }

    @Then("the page header should be (.*?)")
    public void pageHeader(String header) {
        // Write code here that turns the phrase above into concrete actions

        assertThat(header, is(pageHeader));
    }
}
