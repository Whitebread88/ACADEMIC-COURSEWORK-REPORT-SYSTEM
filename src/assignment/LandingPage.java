package assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class LandingPage {

    public static void main(String[] args) {
        ArrayList<Lecturer> lecturer_list = new ArrayList<Lecturer>();
        lecturer_list = ReadFromFile("Lecturer.txt");
        ArrayList<Module> module_list = new ArrayList<Module>();
        module_list = ReadFromFile("Module.txt");
        ArrayList<Student> student_list = new ArrayList<Student>();
        student_list = ReadFromFile("Student.txt");
        ArrayList<Intake> intake_list = new ArrayList<Intake>();
        intake_list = ReadFromFile("Intake.txt");
        ArrayList<Mark> mark_list = new ArrayList<Mark>();
        mark_list = ReadFromFile("Mark.txt");
        Lecturer L = new Lecturer();
        Admin A = new Admin("admin", "admin", "First", "Last");
        Student s1 = new Student(123, "ali", "uc2f2006", "CS");

        System.out.print("\n\n Academic Coursework Report System \n Select number to log in:\n 1.Admin\n 2.Lecturer\n 3.Exit\n\n Selection:");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                A.login(); //Overriding
                break;

            case 2:
                L.login();
                break;

            case 3: //Registration
                System.exit(0);
                break;

            default:
                System.out.println("Invalid Option.\nPlease try again.");
                break;
        }
    }

    public static ArrayList ReadFromFile(String filename) {
        ArrayList<Object> listfromfile = new ArrayList<>();
        try {
            File fr = new File(filename);
            FileInputStream fis = new FileInputStream(fr);
            ObjectInputStream ois = new ObjectInputStream(fis);
            listfromfile = (ArrayList) ois.readObject();
            ois.close();
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
        return listfromfile;
    }

    //Method to serialize arraylist into file
    public static void WriteIntoFile(String filename, ArrayList new_data) {
        ArrayList<Object> listintofile = new_data;
        try {
            File fw = new File(filename);
            FileOutputStream fos = new FileOutputStream(fw);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listintofile);
            oos.close();
        } catch (IOException ex) {
        }
    }
}
