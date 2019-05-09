package selenium;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Entities.User;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(JUnitPlatform.class)
public class LoginTests {

    WebDriver driver;

    @BeforeAll
    public static void setup() {
        if (System.getProperty("os.name").startsWith("Linux")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
        } else if (System.getProperty("os.name").startsWith("Windows")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
        }
    }

    @Test
    public void teacherPage() {
        User teacher = new User("Teacher", "Kasper", "321");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/TestSemesterProject/");
        driver.findElement(By.name("un")).sendKeys(teacher.getUserName());
        driver.findElement(By.name("pw")).sendKeys(teacher.getPassword());
        driver.findElement(By.name("sub")).click();
        String userRole = driver.findElement(By.name("user")).getText();
        assertThat(userRole, is(teacher.getRole()));
        driver.close();
    }

    @Test
    public void studentPage() {
        User student = new User("Student", "Lasse", "321");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/TestSemesterProject/");
        driver.findElement(By.name("un")).sendKeys(student.getUserName());
        driver.findElement(By.name("pw")).sendKeys(student.getPassword());
        driver.findElement(By.name("sub")).click();
        String userRole = driver.findElement(By.name("user")).getText();
        assertThat(userRole, is(student.getRole()));
        driver.close();
    }

    @Test
    public void adminPage() {
        User admin = new User("Admin", "Mo", "321");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/TestSemesterProject/");
        driver.findElement(By.name("un")).sendKeys(admin.getUserName());
        driver.findElement(By.name("pw")).sendKeys(admin.getPassword());
        driver.findElement(By.name("sub")).click();
        String userRole = driver.findElement(By.name("user")).getText();
        assertThat(userRole, is(admin.getRole()));
        driver.close();
    }
}
