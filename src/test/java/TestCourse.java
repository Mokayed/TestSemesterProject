
import data.CourseMapper;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hallur
 */
@RunWith(JUnitPlatform.class)
public class TestCourse {

    @Test
    public void testDeleteCourse() {
        CourseMapper cm = new CourseMapper();
        int length = cm.courses.size() - 1;
        
        cm.deleteCourse(1);

        assertThat(cm.courses.size(), is(length));
    }

}