package assignment;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Module implements java.io.Serializable{
    
    private String modulename;
    private int modulecode;
    private Student student;
    private ArrayList<Mark> mark_list;

        
    public Module(){}
    
    public Module(String modulename, int modulecode) {
        
        this.modulename = modulename;
        this.modulecode = modulecode;
    }
    
    public Module(Student student, ArrayList mark_list){
        this.student = student;
        this.mark_list = mark_list;
    }
    
    public void setmodulename(String modulename) {
        this.modulename = modulename;
    }
        
    public void setmodulecode(int modulecode) {
        this.modulecode = modulecode;
    }
    
    public void setstudent(Student student){
        this.student = student;
    }
    
    public void setmarklist(ArrayList mark_list){
        this.mark_list = mark_list;
    }
    
    public String getmodulename() {
        return modulename;
    }

    public int getmodulecode() {
        return modulecode;
    }
    
    public Student getstudent(){
        return student;
    }
    
    public ArrayList getmark(){
        return mark_list;
    }
    
    public String toString(){
        return "\tModule Name: " + getmodulename() + "\tModule Code: " + getmodulecode();
    }

  

}

