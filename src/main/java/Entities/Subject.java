/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hallur
 */
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