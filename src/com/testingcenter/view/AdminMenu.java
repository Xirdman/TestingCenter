package com.testingcenter.view;

import com.testingcenter.Main;
import com.testingcenter.controller.AdminController;
import com.testingcenter.model.Admin;
import com.testingcenter.model.User;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * View class for admin menu
 */
public class AdminMenu {
    /**
     * First Screen of admin menu after log in
     *
     * @param admin Admin to display menu
     */
    public static void showFirstScreen(Admin admin) {
        System.out.print("Choose options you want to do \n");
        System.out.print("1 - Watch users list \n");
        System.out.print("2 - Log out \n");
        System.out.print("3 - Exit \n");
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        try {
            i = Integer.parseInt(scanner.next());
            System.out.print("\n");
        } catch (Exception e) {
            System.out.print("Waiting to choose an option from 1 to 3 \n");
            showFirstScreen(admin);
        }
        switch (i) {
            case 1:
                showUsersList();
                showFirstScreen(admin);
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
                showFirstScreen(admin);
        }
    }

    private static void showUsersList() {
        List<User> users = AdminController.getUsers();
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            System.out.println(user.getFirstName() + " " + user.getLastName() + " " + user.getClass().getSimpleName());
        }
    }
}
