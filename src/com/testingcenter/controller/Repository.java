package com.testingcenter.controller;

import com.testingcenter.model.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Class for data
 */
public class Repository {

    private static List<User> users;
    private static List<Test> tests;
    private static List<Assignment> assignments;
    private static List<TestQuestion> questions;
    private static List<Group> groups;
    private static List<TestResult> results;
    private static List<QuestionAnswer> questionAnswers;

    /**
     * Method to get all question answers from repository
     *
     * @return Collection of question answers
     */
    public static List<QuestionAnswer> getQuestionAnswers() {
        return questionAnswers;
    }

    /**
     * Method to get all results from repository
     *
     * @return Collection of results
     */
    public static List<TestResult> getResults() {
        return results;
    }

    /**
     * Method to initialize data of users, tests,questions and assignments.Later it will upload data from in memory database
     */
    public static void initialize() {
        users = new LinkedList<>();
        Teacher teacher1 = new Teacher("Dmitriy", "Bykovets", "login", "password");
        Teacher teacher2 = new Teacher("Arnold", "Shcwarzeneger", "kabuto", "perpeto");
        users.add(teacher1);
        users.add(teacher2);

        Student student1 = new Student("Ivan", "Ivanov", "Ivan", "123");
        Student student2 = new Student("Sergey", "Sergeevich", "Sergey", "qwerty");
        users.add(student1);
        users.add(student2);
        users.add(new Admin("Vladimir", "Putin", "admin", "admin"));

        tests = new LinkedList<Test>();
        Test test1 = new Test("JavaSE", teacher1);
        Test test2 = new Test("JavaEE", teacher1);
        Test test3 = new Test("Bodybuilding", teacher2);
        tests.add(test1);
        tests.add(test2);
        tests.add(test3);

        Assignment assignment1 = new Assignment(student1, test1);
        Assignment assignment2 = new Assignment(student2, test2, true);
        assignments = new LinkedList<Assignment>();
        assignments.add(assignment1);
        assignments.add(assignment2);

        questions = new LinkedList<>();
        questionAnswers = new LinkedList<>();
        TestQuestion question1 = new TestQuestion("How many primitive data types in Java?", test1);

        questionAnswers.add(new QuestionAnswer("6", 0, question1, 1));
        questionAnswers.add(new QuestionAnswer("7", 0, question1, 2));
        questionAnswers.add(new QuestionAnswer("8", 3, question1, 3));
        questions.add(question1);

        TestQuestion question2 = new TestQuestion("Will you go to gym tomorrow?", test3);
        questionAnswers.add(new QuestionAnswer("Yes", 2, question2, 4));
        questionAnswers.add(new QuestionAnswer("No", 1, question2, 5));
        questions.add(question2);

        TestQuestion question3 = new TestQuestion("How to print in console?", test1);
        questionAnswers.add(new QuestionAnswer("System.out.print()", 3, question3, 6));
        questionAnswers.add(new QuestionAnswer("printf()", 0, question3, 7));
        questionAnswers.add(new QuestionAnswer("cout>>", 0, question3, 8));
        questions.add(question3);

        groups = new LinkedList<>();
        Group group1 = new Group("Group 420", 1);
        Group group2 = new Group("Group 322", 2);
        groups.add(group1);
        groups.add(group2);

        student1.setGroup(1);
        student2.setGroup(1);
        Student student3 = new Student("Petr", "Petrov", "petya", "petro");
        Student student4 = new Student("Victor", "Nurgaliev", "vic", "Victory");
        users.add(student3);
        users.add(student4);
        student3.setGroup(2);
        student4.setGroup(2);
        TestResult testResult1 = new TestResult(student1, test1, 4);
        TestResult testResult2 = new TestResult(student2, test1, 3);
        TestResult testResult3 = new TestResult(student3, test1, 5);
        TestResult testResult4 = new TestResult(student4, test1, 1);
        results = new LinkedList<>();
        results.add(testResult1);
        results.add(testResult2);
        results.add(testResult3);
        results.add(testResult4);
    }

    /**
     * Get collection of users
     *
     * @return List of users
     */
    public static List<User> getUsers() {
        return users;
    }

    /**
     * Get collection of tests
     *
     * @return List of tests
     */
    public static List<Test> getTests() {
        return tests;
    }

    /**
     * Get collection of assignments
     *
     * @return List of assignments
     */
    public static List<Assignment> getAssignments() {
        return assignments;
    }

    /**
     * Get collection of test questions
     *
     * @return List of test questions
     */
    public static List<TestQuestion> getQuestions() {
        return questions;
    }

    /**
     * Method to get collection of groups
     *
     * @return List of groups
     */
    public static List<Group> getGroups() {
        return groups;
    }

}
