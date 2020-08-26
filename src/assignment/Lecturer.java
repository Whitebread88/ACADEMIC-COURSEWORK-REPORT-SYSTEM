package assignment;

import java.util.ArrayList;
import java.util.Scanner;


public class Lecturer extends Users{

    public Lecturer() {}

    public Lecturer(String username, String password, String firstname, String lastname){
        super(username, password, firstname, lastname);
    }

    public String toString() {
        return "\nUsername: " + getusername() + "\nFirst name: " + getfirstname() + "\nLast name: " + getlastname();
    }

    public void login(){
        ArrayList<Lecturer> lecturer_list = LandingPage.ReadFromFile("Lecturer.txt");
        Scanner sc = new Scanner(System.in);
        Lecturer lect_login = new Lecturer();
        int flag = 1;
        String lect_username;
        if (flag != 0) {
            System.out.println("\nLecturer Login page\nEnter your username: ");
            lect_username = sc.nextLine();
            System.out.println("\nEnter your password: ");
            String lect_password = sc.nextLine();
            for (Lecturer lectinput : lecturer_list) {
                if (lectinput.getusername().equals(lect_username) && lectinput.getpassword().equals(lect_password)) { //Check if customer exists
                    lect_login = lectinput;
                    System.out.println("\nLogin Successfull\nGreetings " + lect_login.getfirstname() + " " + lect_login.getlastname());
                    flag = 0;
                    lecturer_function();
                }
            }
            if (flag == 1) {
                System.out.println("\nInvalid Username/Password");
            }
        
        System.out.println("\nDo you want to retry?\n >1.Retry \n >2.Exit");
        int ans = sc.nextInt();
        sc.nextLine();
        switch (ans) {
            case 1:
                login();
                break;

            case 2:
                System.out.println("\n< Thank you! >");
                break;
        }
    }
    }


    
    public void lecturer_function(){
        Scanner sc = new Scanner(System.in);
        int lecturerchoice;
        System.out.println("\nWelcome to lecturer page");
        System.out.println("\n Select function:\n 1.Manage Student Marks\n 2.Generate Report\n 3.Exit \n\n Selection:");
        lecturerchoice = sc.nextInt();
        sc.nextLine();
        switch (lecturerchoice) {
            case 1:
                //manage_mark();
                break;
            case 2:
                //generate_report();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("\nInvalid Option.\nPlease try again.");
                lecturer_function();
        }
    }
    

}
    
    
    