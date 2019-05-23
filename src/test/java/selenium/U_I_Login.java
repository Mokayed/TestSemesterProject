package selenium;

import entity.User;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.text.ParseException;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class U_I_Login {

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
        rows.get(3).click();
        rows.get(4).click();
        pageHeader = driver.findElement(By.name("user")).getText();
        Thread.sleep(1000);
    }

    @Then("the page header should be (.*?)")
    public void pageHeader(String header) {
        assertThat(header, is(pageHeader));
        driver.close();
    }
}
