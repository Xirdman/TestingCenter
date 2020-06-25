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
        System.out.println("2 - For complete test");
        System.out.print("3 - Log out \n");
        System.out.print("4 - Exit \n");
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        try {
            i = Integer.parseInt(scanner.next());
            System.out.print("\n");
        } catch (Exception e) {
            System.out.print("Waiting to choose an option from 1 to 4 \n");
        }
        switch (i) {
            case 1:
                printTests(student);
                showFirstScreen(student);
                break;
            case 2:
                startCompleteTest(student);
                break;
            case 3:
                Main.showWelcomeScreen();
                break;
            case 4:
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

    private static void startCompleteTest(Student student) {
        List<Test> list = new StudentContoller().getStudentTests(student);
        if (list.isEmpty()) {
            System.out.println("You dont have any tests to complete");
        } else {
            chooseTest(student, list);
        }
        showFirstScreen(student);
    }

    private static void chooseTest(Student student, List<Test> studentUncompletedTests) {
        Iterator<Test> iterator1 = studentUncompletedTests.iterator();
        System.out.println("Choose test to complete");
        int i = 1;
        while (iterator1.hasNext()) {
            Test test = iterator1.next();
            System.out.println(i + " - for complete " + test.getName());
            i++;
        }
        Scanner scanner = new Scanner(System.in);
        int choosenTestPosition = -1;
        try {
            choosenTestPosition = Integer.parseInt(scanner.next());
        } catch (Exception e) {
            System.out.println("Waiting for yourchoise from 1 to " + i + " or 0 to go to student screen");
        }
        if (choosenTestPosition > 0) {
            int k = 1;
            Iterator<Test> iterator2 = studentUncompletedTests.iterator();
            while (iterator2.hasNext()) {
                Test test = iterator2.next();
                if (k == choosenTestPosition) {
                    completeTest(student, test);
                }
                k++;
            }
        }
    }

    private static void completeTest(Student student, Test test) {

    }

}
