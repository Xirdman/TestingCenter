package com.testingcenter.view;

import com.testingcenter.Main;
import com.testingcenter.controller.StudentContoller;
import com.testingcenter.controller.TestController;
import com.testingcenter.model.Student;
import com.testingcenter.model.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * View class for admin menu
 */
public class StudentMenu {
    /**
     * First Screen of student menu after log in
     *
     * @param student Student to display menu after log in
     */
    public static void showFirstScreen(Student student) {
        System.out.print("Choose options you want to do \n");
        System.out.print("1 - Watch your tests and how many questions in it \n");
        System.out.print("2 - Log out \n");
        System.out.print("3 - Exit \n");
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        try {
            i = Integer.parseInt(scanner.next());
            System.out.print("\n");
        } catch (Exception e) {
            System.out.print("Waiting to choose an option from 1 to 3 \n");
        }
        switch (i) {
            case 1:
                printTests(student);
                showFirstScreen(student);
                break;
            case 2:
                Main.showWelcomeScreen();
                break;
            case 3:
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.print("Waiting to choose an option from 1 to 3 \n");
                showFirstScreen(student);
        }
    }

    private static void printTests(Student student) {
        List<Test> studentTests = new StudentContoller().getStudentTests(student);
        Iterator<Test> iterator = studentTests.iterator();
        while (iterator.hasNext()) {
            Test test = iterator.next();
            System.out.print(test.getName() + " " + new TestController().getQuestionNumber(test));
        }
    }

}
