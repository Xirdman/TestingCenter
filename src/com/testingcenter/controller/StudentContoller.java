package com.testingcenter.controller;

import com.testingcenter.model.Assignment;
import com.testingcenter.model.Student;
import com.testingcenter.model.Test;

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

}
