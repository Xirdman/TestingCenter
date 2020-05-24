package com.testingcenter.controller;

import com.testingcenter.Main;
import com.testingcenter.model.Assignment;
import com.testingcenter.model.Teacher;
import com.testingcenter.model.Test;
import com.testingcenter.model.TestQuestion;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Class to make business logic with tests
 */
public class TestController {
    /**
     * Method to find all tests of the teacher
     *
     * @param teacher Teacher who make test
     * @return List of tests created by teacher
     */
    public static List<Test> getTeachersTests(Teacher teacher) {
        List<Test> tests = Main.getTests();
        List<Test> result = new LinkedList<Test>();
        Iterator<Test> iterator = tests.iterator();
        while (iterator.hasNext()) {
            Test test = iterator.next();
            if (test.getTeacher() == teacher) {
                result.add(test);
            }
        }
        return result;
    }

    /**
     * Method to get results of the test
     *
     * @param test Test to get results
     * @return String with progress of test
     */
    public static String getTestResults(Test test) {
        int allTests = 0;
        int completedTests = 0;
        List<Assignment> assignments = Main.getAssignments();
        Iterator<Assignment> iterator = assignments.iterator();
        while (iterator.hasNext()) {
            Assignment assignment = iterator.next();
            if (assignment.getTest() == test) {
                allTests++;
                if (assignment.isComlpeted()) completedTests++;
            }
        }
        if (allTests > 0) {
            return completedTests + "/" + allTests + " completed";
        } else {
            return "No assignments for this test";
        }
    }

    /**
     * Method to get number of questions in test
     *
     * @param test Test to know how many number of questions
     * @return number of questions
     */
    public static int getQuestionNumber(Test test) {
        int i = 0;
        List<TestQuestion> questions = Main.getQuestions();
        Iterator<TestQuestion> iterator = questions.iterator();
        while (iterator.hasNext()) {
            TestQuestion question = iterator.next();
            if (question.getQuestionTest() == test) {
                i++;
            }
        }
        return i;
    }
}
