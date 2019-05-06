package data;

import Entities.Category;
import Entities.Course;
import Entities.Subject;
import Entities.Teacher;
import java.util.ArrayList;
import java.util.List;

public class CourseMapper {

    public List<Course> courses = new ArrayList();

    public CourseMapper() {
        courses.add(new Course(1, new Subject("System Integration", new Category("IT", ""), 0), new Teacher("Lars", "none", null)));
        courses.add(new Course(2, new Subject("Test", new Category("IT", ""), 0), new Teacher("Ole", "none", null)));
        courses.add(new Course(3, new Subject("Databases", new Category("IT", ""), 0), new Teacher("Hans", "none", null)));

    }

    public void deleteCourse(int id) {
        Course courseToDelete = null;

        for (Course course : courses) {
            if (course.getId() == id) {
                courseToDelete = course;
            }
        }
        courses.remove(courseToDelete);
    }

}
