package com.java;

import java.util.HashMap;
import java.util.Map;

public class Student {
    String name;
    private int rollNumber;
    private Map<String, Integer> subjectMarks;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.subjectMarks = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setSubjectMarks(String subject, int marks) {
        subjectMarks.put(subject, marks);
    }

    public Map<String, Integer> getSubjectMarks() {
        return subjectMarks;
    }

    public double calculatePercentage() {
        int totalMarks = 0;
        for (int marks : subjectMarks.values()) {
            totalMarks += marks;
        }
        return (double) totalMarks / subjectMarks.size();
    }

    public String calculateGrade() {
        double percentage = calculatePercentage();
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
