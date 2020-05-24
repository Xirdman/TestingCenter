package com.testingcenter.controller;

import com.testingcenter.Main;
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
    public static LinkedList<Test> getStudentTests(Student student) {
        LinkedList<Test> studentTests = new LinkedList<Test>();
        List<Assignment> assignments = Main.getAssignments();
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
