package selenium;

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
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.core.IsEqual;
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
 * @author hallur
 */
@RunWith(MockitoJUnitRunner.class)
public class PlanningSeleniumTests {

    WebDriver driver;
    private LocalDate teacherDate;
    private LocalDate semesterDate;

    @Given("^the teacher-date (.*?)$")
    public void navigatePage(String strDate) throws ParseException, InterruptedException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        teacherDate = LocalDate.parse(strDate, formatter);
    }

    @Given("^the semester-date (.*?)$")
    public void clickBtn(String strDate) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        semesterDate = LocalDate.parse(strDate, formatter);
    }

    @When("^the teacher logs in$")
    public void bla() {
        if (System.getProperty("os.name").startsWith("Linux")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
        } else if (System.getProperty("os.name").startsWith("Windows")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
        }
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/TestSemesterProject/");
        List<WebElement> rows = driver.findElements(By.tagName("input"));
        rows.get(0).sendKeys("Kasper");
        rows.get(1).sendKeys("321");
        rows.get(2).click();

        driver.findElement(By.id("planBtn")).click();
        driver.findElement(By.id("tDate")).sendKeys(teacherDate.toString());
        driver.findElement(By.id("sDate")).sendKeys(semesterDate.toString());
    }

    @Then("the days difference should be {int}")
    public void the_days_difference_should_be(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        semesterDate = semesterDate.minusMonths(1);
        int days = (int) DAYS.between(teacherDate, semesterDate);
        System.out.println("days: " + days);
        driver.findElement(By.id("days")).sendKeys("" +days);
    }
}
