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

public class Module implements java.io.Serializable{
    
    protected String modulename;
    protected int modulecode;
    protected Student student;
    protected ArrayList<Mark> mark_list;
    protected static final long serialVersionUID = 1L;
        
    public Module(){}
    
    public Module(String modulename, int modulecode) {
        
        this.modulename = modulename;
        this.modulecode = modulecode;
    }
    
    public Module(String modulename, int modulecode, Student student, ArrayList mark_list){
        this.modulename = modulename;
        this.modulecode = modulecode;
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
    
    public ArrayList getmarks(){
        return mark_list;
    }
    
    public String toString(){
        return "\tModule Name: " + getmodulename() + "\tModule Code: " + getmodulecode();
    }

  

}

