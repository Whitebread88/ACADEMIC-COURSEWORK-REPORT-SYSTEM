
package assignment;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Mark implements java.io.Serializable {
    
    //Association
    private int module_code;
    private Student student;
    private ArrayList<Mark> marklist;
    private int total_mark;
    

    public Mark(){
        module_code = findmodulecode();
    }
    
    
    public Mark(Student student,String intakecode,String modulename, int modulecode,int assignment_mark,int test_mark,int exam_mark) {
        module_code = findmodulecode();
        this.student = student;
        this.marklist = marklist;
        total_mark = findtotal_mark();
    }
    
    public void setmodule_code(int module_code) {
        this.module_code = module_code;
    }
    
    public int getmodule_code(){
        return module_code;
    }
    
    
    public int findmodulecode(){
        Random code = new Random();
        int checkduplicate;
        ArrayList<Module> module_list = LandingPage.ReadFromFile("Module.txt");
        int mod;
        do{
            checkduplicate = 0;
            mod = code.nextInt(99999999) + 1;
            
            for (Module module : module_list){
                if (module.getmodulecode() == mod){
                    checkduplicate = 1;
                }
            }
        } while (checkduplicate == 1);
        return mod;
    }
    
    public void settotal_mark(int total_mark){
        this.total_mark = total_mark;
    }
    
    public int gettotal_mark(){
        return total_mark;
    }
    
    public int findtotal_mark(){
        int total = 0;
        for (Mark m : marklist){
            total += m.gettotal_mark();
        }
        return total;
    }
    
    public void setstudent(Student student){
        this.student = student;
    }
      
      public Student getstudent(){
          return student;
      }
      
    public void setmarklist(ArrayList marklist){
        this.marklist = marklist;
    }
    
    public ArrayList getmarklist(){
        return marklist;
    }
    public String toString(){
        return "\nStudent: " +getstudent() + "\nModule Code: " + "\nTotal Marks: " +gettotal_mark(); 
       
    }

}
