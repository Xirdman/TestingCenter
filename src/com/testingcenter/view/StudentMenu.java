package com.testingcenter.view;

import com.testingcenter.Main;
import com.testingcenter.controller.StudentContoller;
import com.testingcenter.controller.TestController;
import com.testingcenter.model.Student;
import com.testingcenter.model.Test;
import com.testingcenter.model.TestQuestion;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * View class for admin menu
 *
 * @author Matveev Alexander
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
        System.out.println("2 - To complete test");
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
        for (Test test : studentTests) {
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
            System.out.println(i + " - to complete " + test.getName());
            i++;
        }
        Scanner scanner = new Scanner(System.in);
        int choosenTestPosition = -1;
        try {
            choosenTestPosition = Integer.parseInt(scanner.next());
        } catch (Exception e) {
            System.out.println("Waiting for your choice from 1 to " + i + " or 0 to go to student screen");
        }
        if (choosenTestPosition > 0) {
            completeTest(student, studentUncompletedTests.get(choosenTestPosition - 1));
        }
    }

    private static void completeTest(Student student, Test test) {
        List<TestQuestion> questions = new TestController().getQuestionsForStudentFromTest(test, student);
        for (TestQuestion question : questions) {
            System.out.println(question.getQuestionText());
        }
        System.out.println();
    }

}
