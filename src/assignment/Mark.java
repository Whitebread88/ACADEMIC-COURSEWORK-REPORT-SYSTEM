
package assignment;

import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.io.Serializable;


public class Mark implements java.io.Serializable {
    
    //Association
    private int testmark;
    private int exammark;
    private int assignmentmark;
    private int totalmark;
    private ArrayList<Mark> marklist;
    private Module module;
    private Student student;
    private static final long serialVersionUID = 1L;
    

    public Mark(){}
    
    public Mark(Student student,Module module, int testmark,int exammark , int assignmentmark) {
        this.student = student;
        this.module = module;
        this.testmark = testmark;
        this.exammark = exammark;
        this.assignmentmark = assignmentmark;

    }
    
    public void settestmark(int testmark) {
        this.testmark = testmark;
    }
    
    public int gettestmark(){
        return testmark;
    }
    
    public void setexammark(int exammark) {
        this.exammark = exammark;
    }
    
    public int getexammark(){
        return exammark;
    }
    
     public void setassignmentmark(int assignmentmark) {
        this.assignmentmark = assignmentmark;
    }
    
    public int getassignmentmark(){
        return assignmentmark;
    }
    
    public int findtotalmark(){
        totalmark = gettestmark() + getexammark() +getassignmentmark();
        return totalmark;
    }
    
    public void settotalmark(int totalmark){
        this.totalmark = totalmark;
    }
    
    public int gettotalmark(){
        return totalmark;
    }
    
    public void setmarklist(ArrayList marklist){
        this.marklist = marklist;
    }

    public ArrayList getmarklist(){
        return marklist;
    }
    
    public void setmodule(Module module){
        this.module = module;
    }
    
    public Module getmodule(){
        return module;
    }
    
    public void setstudent(Student student){
        this.student = student;
    }
    
    public Student getstudent(){
        return student;
    }

    public String toString(){
        return "\nStudent: " +getstudent() + "\nModule: " +getmodule() + "\nTest Mark: " +gettestmark() + "\nExam Mark: " +getexammark() +"\nAssignment Mark: " +getassignmentmark() + "\nTotal Marks: \n" + findtotalmark() + "\n-------------------------------------------"; 
        
       
    }

}
