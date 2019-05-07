package selenium;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.BeforeAll;

@RunWith(JUnitPlatform.class)
public class TestCoursePage {

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
    }

    @Test
    public void testCoursesListShown() {
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:8080/TestSemesterProject/courses.jsp");

        WebElement element = driver.findElement(By.id("courses"));

        System.out.println(element.getText());

        assertThat(driver.getTitle(), is("Courses"));

        //Close the browser
        driver.quit();
    }
    
//    @Test
//    public void testClickOnCourse() {
//        WebDriver driver = new ChromeDriver();
//
//        driver.get("http://localhost:8080/TestSemesterProject/courses.jsp");
//
//        WebElement element = driver.findElement(By.id("1"));
//
//        System.out.println(element.getText());
//        
//        element.click();
//
//        assertThat(driver.getTitle(), is("Courses"));
//
//        //Close the browser
//        driver.quit();
//    }

}