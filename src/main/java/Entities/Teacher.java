package Entities;

import java.util.Date;

public class Teacher {
    
    private int id;
    private String name;
    private String education;
    private Date lastActive;

    public Teacher(String name, String education, Date lastActive) {
        this.name = name;
        this.education = education;
        this.lastActive = lastActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Date getLastActive() {
        return lastActive;
    }

    public void setLastActive(Date lastActive) {
        this.lastActive = lastActive;
    }
    
}
