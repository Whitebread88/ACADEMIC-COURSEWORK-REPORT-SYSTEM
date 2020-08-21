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
        System.out.println("\n Select function:\n 1.Manage Module\n 2.Manage Student\n 3.Register Lecturer\n 4.Exit \n\n Selection:");
        adminchoice = sc.nextInt();
        sc.nextLine();
        switch (adminchoice) {
            case 1:
                manage_module();
                break;
            case 2:
                manage_student();
                break;
            case 3:
                lecturer_register();
            case 4:
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
        System.out.println("\n Select function:\n 1.New intake\n 2.Add module\n 3.View module\n 4.Delete Module\n 5.Exit \n\n Selection:");
        adminchoice = sc.nextInt();
        sc.nextLine();
        switch (adminchoice) {
            case 1:
                //new_intake();
                break;
            case 2:
                add_module();
                break;
            case 3:
                //view_module();
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
    
    public void add_module(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Module> module_list = new ArrayList<>();
        module_list = LandingPage.ReadFromFile("Module.txt");
        int flag = 0;
        int record = 0;
        String new_modulename;
        System.out.print("\nModule addition Page");
        do {
            System.out.print("\nEnter New Module Name: ");
            new_modulename = sc.nextLine();
            for (Module mn : module_list) {
                if (mn.getmodulename().equals(new_modulename)) {
                    System.out.print("\nModule already exist\n");
                    flag = 1;
                }
            }
            if (flag == 0) {
                record = 1;
            } else {
                flag = 0;
            }
        } while (record == 0);

        System.out.print("\nEnter Module Code: ");
        String new_code = sc.nextLine();

        //Write all the information into the file
        Module new_module = new Module(new_modulename, new_code);
        module_list.add(new_module);
        LandingPage.WriteIntoFile("Module.txt", module_list);
        System.out.println("\nNew Module Added");
    }
    
    public void manage_student(){
        Scanner sc = new Scanner(System.in);
        int adminchoice;
        System.out.println("\nWelcome to Student Management page");
        System.out.println("\n Select function:\n 1.Add student\n 2.Delete Student\n 3.Search Student\n 4.Edit student details\n 5.Edit Marks\n 6.Generate report\n 7.Exit \n\n Selection:");
        adminchoice = sc.nextInt();
        sc.nextLine();
        switch (adminchoice) {
            case 1:
                //add_student();
                break;
            case 2:
                //delete_student();
                break;
            case 3:
                //search_student();
                break;
            case 4:
                //edit_student();
            case 5:
                //generate_report();
                break;
            case 6:
                manage_mark();
                break;
            case 7:
                System.exit(0);
            default:
                System.out.println("\nInvalid Option.\nPlease try again.");
                manage_student();
        }  
    }
    
    public void manage_mark(){
        Scanner sc = new Scanner(System.in);
        int adminchoice;
        System.out.println("\nWelcome to Marks Management page");
        System.out.println("\n Select function:\n 1.View all marks\n 2.Edit marks\n 3.Generate report\n 4.Exit \n\n Selection:");
        adminchoice = sc.nextInt();
        sc.nextLine();
        switch (adminchoice) {
            case 1:
                //view_mark();
                break;
            case 2:
                //edit_mark();
                break;
            case 3:
                //generate_report();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("\nInvalid Option.\nPlease try again.");
                manage_mark();
        } 
       
    }
}

