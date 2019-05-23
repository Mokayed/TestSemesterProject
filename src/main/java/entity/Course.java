package entity;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private int id;
    private Subject subject;
    private Teacher teacher;
    private List<Student> students;

    public Course() {
    }

    public Course(int id, Subject subject, Teacher teacher) {
        this.id = id;
        this.subject = subject;
        this.teacher = teacher;
        students = new ArrayList();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
