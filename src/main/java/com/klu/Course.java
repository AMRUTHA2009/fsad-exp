package com.klu;

import org.springframework.stereotype.Component;

@Component
public class Course {

    private int id = 1430;
    private String course = "Spring";
    private String dateOfCompletion = "28-Jan-2026";

    @Override
    public String toString() {
        return "Course [id=" + id +
               ", course=" + course +
               ", dateOfCompletion=" + dateOfCompletion + "]";
    }
}
