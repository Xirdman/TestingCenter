package com.testingcenter.controller;

import com.testingcenter.model.Assignment;
import com.testingcenter.model.Student;
import com.testingcenter.model.Test;
import com.testingcenter.model.TestResult;

import java.util.LinkedList;
import java.util.List;

/**
 * Class to make business logic with Student user
 *
 * @author Matveev Alexander
 */
public class StudentContoller {
    /**
     * Method to get all tests assigned to student
     *
     * @param student Student to find a tests
     * @return List of student uncomplited tests
     */
    public List<Test> getStudentTests(Student student) {
        List<Test> studentTests = new LinkedList<>();
        List<Assignment> assignments = Repository.getAssignments();
        for (Assignment assignment : assignments)
            if (assignment.getStudent() == student && !assignment.isComlpeted())
                studentTests.add(assignment.getTest());
        return studentTests;
    }

    /**
     * Method to set single student rating
     *
     * @param student student to set rating
     */
    public void setRating(Student student) {
        int allPoints = 0;
        int studentPoints = 0;
        List<TestResult> results = Repository.getResults();
        for (TestResult testResult : results)
            if (testResult.getStudent() == student) {
                studentPoints += testResult.getPoints();
                allPoints += new TestController().getTestMaxPoints(testResult.getTest());
            }
        if (allPoints != 0)
            student.setRating((double) studentPoints / (double) allPoints * 10);
        else student.setRating(0);
    }

}
