package entity;

public class Student extends User {

    private Course course;
    private int age;
    private boolean hasPaid;

    public Student() {
    }

    public Student(int age, String role, String userName, String password) {
        super(role, userName, password);
        this.age = age;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isHasPaid() {
        return hasPaid;
    }

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }

}
