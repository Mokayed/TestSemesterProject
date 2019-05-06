package Entities;

public class Subject {
    
    private String name;
    private Category category;
    private int semestersOffered;

    public Subject(String name, Category category, int semestersOffered) {
        this.name = name;
        this.category = category;
        this.semestersOffered = semestersOffered;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getSemestersOffered() {
        return semestersOffered;
    }

    public void setSemestersOffered(int semestersOffered) {
        this.semestersOffered = semestersOffered;
    }
    
}
