package assignment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Lecturer extends Users implements java.io.Serializable{

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
                manage_mark();
                break;
            case 2:
                generate_report();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("\nInvalid Option.\nPlease try again.");
                lecturer_function();
        }
    }
    

    public void manage_mark(){
        Scanner sc = new Scanner(System.in);
        int adminchoice;
        System.out.println("\nWelcome to Marks Management page");
        System.out.println("\n Select function:\n 1.View all students\n 2.Edit marks\n 3.Generate report\n 4.Exit \n\n Selection:");
        adminchoice = sc.nextInt();
        sc.nextLine();
        switch (adminchoice) {
            case 1:
                view_student();
                break;
            case 2:
                edit_mark();
                break;
            case 3:
                generate_report();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("\nInvalid Option.\nPlease try again.");
                manage_mark();
        } 
       
    }
    
    public void edit_mark(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n----<Edit Marks>----");
        ArrayList<Student> student_list = LandingPage.ReadFromFile("Student.txt");
        ArrayList<Mark> mark_list = LandingPage.ReadFromFile("Mark.txt");
        Student s = new Student();
        Mark newmark = new Mark();
        System.out.print("Please enter student ID: ");
        int studentToEdit= sc.nextInt();
        sc.nextLine();
                

        int idExists = 0;
        for (Student studentfromfile : student_list) {
            if (studentfromfile.getstudentid() == studentToEdit) {
                s = studentfromfile;
                idExists = 1;
            }
        }
        if (idExists != 1) {
            System.out.println("\n--Account not found--");
            System.out.println("\nDo you want to continue?\n >1.Main Menu \n >2.Try again \n>3.Exit");
            int ans = sc.nextInt();
            sc.nextLine();
            switch (ans) {
            case 1:
                manage_mark();
                break;

            case 2:
                edit_mark();
                
            case 3:
                System.out.println("\n< Thank you! >");
                 System.exit(0);
                break;
            }
        } else {
            ArrayList<Module> module_list = LandingPage.ReadFromFile("Module.txt");
            int checkIdExists = 0;
            Module m = new Module();
            System.out.println("Enter module code to edit marks: ");
            int modulecode = sc.nextInt();
            sc.nextLine();

            int idExists2 = 0;
            for (Module modulefromfile : module_list) {
                if (modulefromfile.getmodulecode() == modulecode) {
                    m = modulefromfile;
                    idExists2 = 1;
                }
            }
            if (idExists2 != 1){
                System.out.println("\n--Module not found--");
                System.out.println("\nDo you want to continue?\n >1.Main Menu \n >2.Try again \n>3.Exit");
                int ans = sc.nextInt();
                sc.nextLine();
                switch (ans) {
                case 1:
                    manage_mark();
                    break;

                case 2:
                    edit_mark();

                case 3:
                    System.out.println("\n< Thank you! >");
                     System.exit(0);
                    break;
                }
            } else {
                System.out.println("\nEnter marks: ");
                Module module = new Module();
                
                
                System.out.println("\nEnter Test Mark :  ");
                int mark1 = sc.nextInt();
                sc.nextLine();
                System.out.println("\nEnter Exam Mark :  ");
                int mark2 = sc.nextInt();
                sc.nextLine();
                System.out.println("\nEnter Assignment Mark :  ");
                int mark3 = sc.nextInt();
                sc.nextLine();

                Mark  marklist = new Mark(s,m,mark1,mark2,mark3);
                newmark.setstudent(s);
                newmark.settestmark(mark1);
                newmark.setexammark(mark2);
                newmark.setassignmentmark(mark3);
                newmark.settotalmark(newmark.findtotalmark());
                mark_list.add(marklist);
                module.setmarklist(mark_list);
                System.out.println("\n Updated student details: \n" + marklist);

                LandingPage.WriteIntoFile("Mark.txt", mark_list);
                 
                System.out.println("\nDo you want to continue?\n >1.Main Menu \n >2.Try again \n>3.Exit");
                int ans = sc.nextInt();
                sc.nextLine();
                switch (ans) {
                case 1:
                    manage_mark();
                    break;

                case 2:
                    edit_mark();

                case 3:
                    System.out.println("\n< Thank you! >");
                     System.exit(0);
                    break;
                }
                
                
            }
        }
    }
    
    
    public void view_student() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> student_list = LandingPage.ReadFromFile("Student.txt");
        int i = 1;
        System.out.println("\n----< Student Details >----\nBelows are the information of students:\n");
        for (Student student : student_list) {
            System.out.print("Student " + i + " :");
            System.out.println(student);
            System.out.println("--------------------------");
            i++;
        }
            System.out.println("\nDo you want to continue?\n >1.Main Menu \n >2.Exit");
            int ans = sc.nextInt();
            sc.nextLine();
            switch (ans) {
            case 1:
                manage_mark();
                break;

            case 2:
                System.out.println("\n< Thank you! >");
                 System.exit(0);
                break;
            }
    }
    
    public void generate_report() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Mark> mark_list = LandingPage.ReadFromFile("Mark.txt");
        int i = 1;
        System.out.println("\n----< Student Marks Details >----\nBelows are the information of students marks:\n");
        for (Mark mark : mark_list) {
            System.out.print("Student # " + i + " : " +mark.getstudent() + "\nModule: " +mark.getmodule() +"\nTotal Mark:" +mark.findtotalmark());
            System.out.println("\n-------------------------------");
            i++;
        }
            System.out.println("\nDo you want to continue?\n >1.Main Menu \n >2.Exit");
            int ans = sc.nextInt();
            sc.nextLine();
            switch (ans) {
            case 1:
                manage_mark();
                break;

            case 2:
                System.out.println("\n< Thank you! >");
                 System.exit(0);
                break;
            }
    }
    
}


    
    
    