package selenium;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(JUnitPlatform.class)
public class TestCourseUI {

    WebDriver driver;

    @Given("^user navigates to courses page$")
    public void navigatePage() {
        if (System.getProperty("os.name").startsWith("Linux")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
        } else if (System.getProperty("os.name").startsWith("Windows")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
        }
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/TestSemesterProject/courses.jsp");
    }

    @When("^user clicks on course 1$")
    public void user_clicks_on_course() throws InterruptedException {
        WebElement element = driver.findElement(By.id("1"));
        Thread.sleep(1000);
        element.click();
    }

    @When("^user clicks on delete$")
    public void user_clicks_on_delete() throws InterruptedException {
        WebElement delete = driver.findElement(By.id("delete"));
        Thread.sleep(1000);
        delete.click();

    }

    @Then("^course should be successfully deleted$")
    public void course_should_be_successfully_deleted() {
        String title = driver.getTitle();
        assertThat(title, is("Servlet CourseServlet"));
        driver.quit();
    }

}
