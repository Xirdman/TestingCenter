package com.testingcenter.view;

import com.testingcenter.Main;
import com.testingcenter.controller.TestController;
import com.testingcenter.model.Teacher;
import com.testingcenter.model.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * View class for Teacher User
 */
public class TeacherMenu {
    /**
     * First screen menu of teacher after log in
     *
     * @param teacher Teacher to show first screen menu
     */
    public static void showFirstScreen(Teacher teacher) {
        System.out.print("Choose options you want to do \n");
        System.out.print("1 - Watch tests and results \n");
        System.out.print("2 - Log out \n");
        System.out.print("3 - Exit \n");
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        try {
            i = Integer.parseInt(scanner.next());
            System.out.print("\n");
        } catch (Exception e) {
            showFirstScreen(teacher);
        }
        switch (i) {
            case 1:
                displayTeachersTests(teacher);
                showFirstScreen(teacher);
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
                showFirstScreen(teacher);
        }
    }

    private static void displayTeachersTests(Teacher teacher) {
        TestController testController = new TestController();
        List<Test> tests = testController.getTeachersTests(teacher);
        Iterator<Test> iterator = tests.iterator();
        while (iterator.hasNext()) {
            Test test = iterator.next();
            System.out.print("Test - " + test.getName() + "\n");
            System.out.print(testController.getTestResults(test) + " \n");
        }
        System.out.println();
    }
}
