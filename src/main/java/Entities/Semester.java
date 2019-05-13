package Entities;

import interfaces.semesterFunctions;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author hallur
 */
public class Semester implements semesterFunctions {
    private LocalDate startDate;
    private String name;

    public Semester(LocalDate startDate, String name) {
        this.startDate = startDate;
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
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