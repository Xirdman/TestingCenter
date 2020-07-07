package com.testingcenter.controller;

import com.testingcenter.model.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Class to make business logic with tests
 *
 * @author Matveev Alexander
 */
public class TestController {
    /**
     * Method to find all tests of the teacher
     *
     * @param teacher Teacher who make test
     * @return List of tests created by teacher
     */
    public List<Test> getTeachersTests(Teacher teacher) {
        List<Test> tests = Repository.getTests();
        List<Test> result = new LinkedList<>();
        for (Test test : tests)
            if (test.getTeacher() == teacher)
                result.add(test);
        return result;
    }

    /**
     * Method to get results of the test
     *
     * @param test Test to get results
     * @return String with progress of test
     */
    public String getTestResults(Test test) {
        int allTests = 0;
        int completedTests = 0;
        List<Assignment> assignments = Repository.getAssignments();
        for (Assignment assignment : assignments)
            if (assignment.getTest() == test) {
                allTests++;
                if (assignment.isComlpeted()) completedTests++;
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
    public int getQuestionNumber(Test test) {
        int i = 0;
        List<TestQuestion> questions = Repository.getQuestions();
        for (TestQuestion question : questions)
            if (question.getQuestionTest() == test)
                i++;
        return i;
    }

    /**
     * Method to get maximum points depends on tests questions
     *
     * @param test test we want to know points
     * @return maximum points student cant get from this test
     */
    public int getTestMaxPoints(Test test) {
        int points = 0;
        List<TestQuestion> list = Repository.getQuestions();
        TestQuestionController qController = new TestQuestionController();
        for (TestQuestion question : list)
            if (question.getQuestionTest() == test)
                points += qController.getQuestionMaxPoints(question);
        return points;
    }

    /**
     * Method get all unanswered questions from test for student
     *
     * @param test    test to get questions from
     * @param student student who got unanswered questions of test
     * @return Collection of unanswered questions
     */
    public List<TestQuestion> getQuestionsForStudentFromTest(Test test, Student student) {
        List<TestQuestion> questions = Repository.getQuestions();
        List<TestQuestion> result = new LinkedList<>();
        for (TestQuestion question : questions) {
            if (question.getQuestionTest() == test) {
                result.add(question);
            }
        }
        return result;
    }
}
