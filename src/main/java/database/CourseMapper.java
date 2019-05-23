package database;

import entity.Category;
import entity.Course;
import entity.Subject;
import entity.Teacher;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseMapper {

    private DatabaseConnector dbc = new DatabaseConnector();
    public List<Course> courses = new ArrayList();

    
    public CourseMapper() {
        dbc.setDataSource(new ProductionDataSource().getDataSource());
        courses.add(new Course(1, new Subject("System Integration", new Category("IT", ""), 0), new Teacher("Lars", "none", null)));
        courses.add(new Course(2, new Subject("Test", new Category("IT", ""), 0), new Teacher("Ole", "none", null)));
        courses.add(new Course(3, new Subject("Databases", new Category("IT", ""), 0), new Teacher("Hans", "none", null)));

    }

    public List<Course> getCourses() throws ClassNotFoundException, SQLException {
        List<Course> courses = new ArrayList();

        try {
            dbc.open();

            String sql = "SELECT * FROM course";

            PreparedStatement pstmt = dbc.preparedStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Course course = new Course();

                int id = rs.getInt("id");
                int teacherId = rs.getInt("teacherId");
                int semesterId = rs.getInt("semesterId");
                int subjectId = rs.getInt("subjectId");
                String name = rs.getString("name");

                course.setId(id);

                courses.add(course);

            }
            for (Course course : courses) {
                System.out.println(course.getId());
            }

            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            dbc.close();
        }
        return courses;

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
