package selenium;


import Entities.User;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author hallur
 */
public class LoginTests {

    WebDriver driver;
    List<User> list = new ArrayList<>();

    @Test
    public void navigatePage() {
        list.add(new User("Teacher", "Kasper", "321"));
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/TestSemesterProject/");
        driver.findElement(By.name("un")).sendKeys(list.get(0).getUserName());
        driver.findElement(By.name("pw")).sendKeys(list.get(0).getPassword());
        driver.findElement(By.name("sub")).click();
        String userRole = driver.findElement(By.name("user")).getText();
        if (list.get(0).getRole().equals("Teacher")) {
            assertEquals(userRole, "Teacher");
            //driver.close();
        }
        if (list.get(0).getRole().equals("Student")) {
            assertEquals(userRole, "Student");
            driver.close();
        }
        if (list.get(0).getRole().equals("Admin")) {
            assertEquals(userRole, "Admin");
            driver.close();
        }
    }

}
