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

        questions = new LinkedList<TestQuestion>();
        String[] answersForQuestion1 = {"6", "7", "8"};
        TestQuestion question1 = new TestQuestion("How many primitive data types in Java?", test1, answersForQuestion1, 2);
        questions.add(question1);

        String[] answersForQuestion2 = {"Yes", "No"};
        TestQuestion question2 = new TestQuestion("Will you go to gym tomorrow?", test3, answersForQuestion2, 0);
        questions.add(question2);
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

}
