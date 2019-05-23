package junit;

import entity.Student;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import database.StudentMapper;
import database.TestDataSource;
import database.TestDatabaseMapper;
import java.sql.SQLException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Zaeem
 */
@RunWith(JUnitPlatform.class)
public class TestStudentMapper {

    private int age;
    private String output;

    @Given("^a user who is (-?\\d*\\.{0,1}\\d+) years old$")
    public void the_input(int age) {
        this.age = age;
    }

    @When("^user tries to register$")
    public void user_tries_to_register() throws SQLException {
        Student student = new Student(age, "Student", "testStudent", "1234");
        StudentMapper studentMapper = new StudentMapper(new TestDataSource().getDataSource());

        output = studentMapper.createStudent(student);
    }

    @Then("^user should get the message (.*?)$")
    public void user_gets_message(String expectedResult) {
        assertThat(output, is(expectedResult));

    }
}
