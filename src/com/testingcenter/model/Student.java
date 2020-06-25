package com.testingcenter.model;

/**
 * Model class for Admin user
 */
public class Student extends User {
    private int groupId;

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

    /**
     * Constructor for model class
     *
     * @param firstName first name of student
     * @param lastName  last name of student
     * @param login     login of student
     * @param password  password of student
     * @param groupId   identificator of group
     */
    public Student(String firstName, String lastName, String login, String password, int groupId) {
        super(firstName, lastName, login, password);
        this.groupId = groupId;
    }

    /**
     * Getter for students group
     *
     * @return identificator of student group
     */
    public int getGroupId() {
        return groupId;
    }

    /**
     * Setter for student group
     *
     * @param groupId identificator of group to set
     */
    public void setGroup(int groupId) {
        this.groupId = groupId;
    }
}
