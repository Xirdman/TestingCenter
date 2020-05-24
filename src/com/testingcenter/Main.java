package com.testingcenter;

import com.testingcenter.model.*;
import com.testingcenter.view.AdminMenu;
import com.testingcenter.view.Menu;
import com.testingcenter.view.StudentMenu;
import com.testingcenter.view.TeacherMenu;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Class with static collections and entry point
 */
public class Main {
    private static List<User> users;
    private static List<Test> tests;
    private static List<Assignment> assignments;
    private static List<TestQuestion> questions;

    /**
     * Get collection of assignments
     *
     * @return List of assignments
     */
    public static List<Assignment> getAssignments() {
        return assignments;
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
     * Get collection of test questions
     *
     * @return List of test questions
     */
    public static List<TestQuestion> getQuestions() {
        return questions;
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
     * Entry point of application
     *
     * @param args no arguments needed
     */
    public static void main(String[] args) {
        initialize();
        showWelcomeScreen();
    }

    private static void initialize() {
        users = new LinkedList<User>();
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
     * Method for users to log in in system
     */
    public static void showWelcomeScreen() {
        String[] loginAndPassword = Menu.welcomeScreen();
        Optional<User> optionalUser;
        optionalUser = logIn(loginAndPassword[0],loginAndPassword[1]);
        if (!optionalUser.isEmpty()) {
            User loggedUser = optionalUser.get();
            System.out.println("Welcome " + loggedUser.getFirstName() + " " + loggedUser.getLastName());
            if (loggedUser instanceof Student) {
                StudentMenu.showFirstScreen((Student) loggedUser);
            } else {
                if (loggedUser instanceof Teacher) {
                    TeacherMenu.showFirstScreen((Teacher) loggedUser);
                } else {
                    if (loggedUser instanceof Admin) {
                        AdminMenu.showFirstScreen((Admin) loggedUser);
                    }
                }
            }
        } else {
            showWelcomeScreen();
        }
    }

    private static Optional<User> logIn(String login, String password) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getLogin().equals(login) && (user.getPassword().equals(password))) {
                return Optional.of(user);
            }
        }
        return Optional.ofNullable(null);
    }
}
