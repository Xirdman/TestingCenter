package com.testingcenter.model;

/**
 * Model class for Admin user
 */
public class Student extends User {
    /**
     * Constructor for model class
     *
     * @param firstName first name of student
     * @param lastName  last name of student
     * @param login     login of student
     * @param password  password of student
     */
    public Student(String firstName, String lastName, String login, String password) {
        super(firstName, lastName, login, password);
    }
}
