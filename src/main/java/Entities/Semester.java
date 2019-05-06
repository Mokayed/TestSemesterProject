/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import interfaces.semesterFunctions;
import java.util.Date;

/**
 *
 * @author hallur
 */
public class Semester implements semesterFunctions {
    private Date startDate;
    private String name;

    public Semester(Date startDate, String name) {
        this.startDate = startDate;
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int daysUntilDeadLine() {
        return 0;
    }
    
    
}
