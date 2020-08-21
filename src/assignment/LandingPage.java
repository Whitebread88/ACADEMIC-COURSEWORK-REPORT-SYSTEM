package assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
       
public class LandingPage {

   
    public static void main(String[] args) {
        ArrayList<Lecturer> lecturer_list = new ArrayList<Lecturer>();
        lecturer_list = ReadFromFile("Lecturer.txt");
        Lecturer L = new Lecturer();
        Admin A = new Admin("admin", "admin", "First", "Last");
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
        } catch (IOException ex) {} 
        catch (ClassNotFoundException ex) {}
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
        } catch (IOException ex) {}
    }
}