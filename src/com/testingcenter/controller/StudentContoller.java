package com.testingcenter.controller;

import com.testingcenter.model.Assignment;
import com.testingcenter.model.Student;
import com.testingcenter.model.Test;
import com.testingcenter.model.TestResult;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Class to make business logic with Student user
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
        Iterator<Assignment> iterator = assignments.iterator();
        while (iterator.hasNext()) {
            Assignment assignment = iterator.next();
            if (assignment.getStudent() == student && !assignment.isComlpeted()) {
                studentTests.add(assignment.getTest());
            }
        }
        return studentTests;
    }

    /**
     * Method to get single student raiting
     *
     * @param student student which rairing we want to know
     * @return raiting in double format from 0 to 10
     */
    public double getRaiting(Student student) {
        int allPoints = 0;
        int studentPoints = 0;
        List<TestResult> results = Repository.getResults();
        Iterator<TestResult> iterator = results.iterator();
        while (iterator.hasNext()) {
            TestResult testResult = iterator.next();
            if (testResult.getStudent() == student) {
                studentPoints += testResult.getPoints();
                allPoints += new TestController().getTestMaxPoints(testResult.getTest());
            }
        }
        if (allPoints != 0) {
            return (double) studentPoints / (double) allPoints * 10;
        }
        return 0;
    }

}
