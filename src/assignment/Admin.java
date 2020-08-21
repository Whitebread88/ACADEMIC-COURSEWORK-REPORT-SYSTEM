package assignment;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Admin extends Users{
    
    public Admin(String username, String password, String firstname, String lastname){
        super(username, password, firstname, lastname);
    }
    
    public void login() {
        int flag = 0;
        while (flag == 0) {
            System.out.println(" \nWelcome to Admin login page\nEnter username:");
            Scanner sc = new Scanner(System.in);
            String admin_username = sc.nextLine();
            if (admin_username.equals("admin")) {
                System.out.println("\nEnter password:");
                String admin_password = sc.nextLine();
                if (admin_password.equals("admin")) {
                    flag = 1;
                } else {
                    System.out.println("\nIncorrect Password\nPlease try again");
                }
            } else {
                System.out.println("\nIncorrect Username\nPlease try again");
            }
        }
        System.out.println("Login Successfull");
        admin_function();
    }
    
    
    public void admin_function() { 
        Scanner sc = new Scanner(System.in);
        int adminchoice;
        System.out.println("\nWelcome to Admin page");
        System.out.println("\n Select function:\n 1.Manage Module\n 2.Manage Student\n 3.Manage Grade\n 4.Register Lecturer\n 5.Exit \n\n Selection:");
        adminchoice = sc.nextInt();
        sc.nextLine();
        switch (adminchoice) {
            case 1:
                manage_module();
                break;
            case 2:
                //manage_student();
                break;
            case 3:
                //manage_grade();
                break;
            case 4:
                lecturer_register();
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("\nInvalid Option.\nPlease try again.");
                admin_function();
        }
    }
    
    public void lecturer_register() {
        ArrayList<Lecturer> lecture_list = LandingPage.ReadFromFile("Lecturer.txt");
        Scanner sc = new Scanner(System.in);
        int username_flag = 0;
        int usernamefile = 0;
        String lect_username;
        System.out.println("\nRegister new lecturer");
        do {
            System.out.println("Enter new lecturer username: ");
            lect_username = sc.nextLine();
            for (Lecturer lectinput : lecture_list) {
                if (lectinput.getusername().equals(lect_username)) {
                    username_flag = 1;
                }
            }
            if (username_flag == 0) {
                usernamefile = 1;
            } else {
                username_flag = 0;
                System.out.println("Username already exists.\n");
            }
        } while (usernamefile == 0);

        int flag = 0;
        String lect_password = "";
        while (flag == 0) {
            System.out.println("\nEnter Password:");
            String password = sc.nextLine();
            System.out.println("\nRetype Password:");
            lect_password = sc.nextLine();
            if (password.equals(lect_password)) {
                flag = 1;
            } else {
                System.out.println("\nPassword does not match\nPlease try Again");
            }
        }

        System.out.println("\nEnter First Name:");
        String lect_firstname = sc.nextLine();
        System.out.println("\nEnter Last Name:");
        String lect_lastname = sc.nextLine();
        Lecturer new_lecturer = new Lecturer(lect_username, lect_password, lect_firstname, lect_lastname);
        lecture_list.add(new_lecturer);
        LandingPage.WriteIntoFile("Lecturer.txt", lecture_list);
        System.out.println("\nLecture registration successfull");
    }
    
    public void manage_module(){
        Scanner sc = new Scanner(System.in);
        int adminchoice;
        System.out.println("\nWelcome to Module page");
        System.out.println("\n Select function:\n 1.New intake\n 2.Add module\n 3.Search module\n 4.Delete Module\n 5.Exit \n\n Selection:");
        adminchoice = sc.nextInt();
        sc.nextLine();
        switch (adminchoice) {
            case 1:
                //new_intake();
                break;
            case 2:
                //add_module();
                break;
            case 3:
                //search_module();
                break;
            case 4:
                //delete_module();
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("\nInvalid Option.\nPlease try again.");
                manage_module();
        }  
    }
    
    public void manage_student(){
        
    }
}

