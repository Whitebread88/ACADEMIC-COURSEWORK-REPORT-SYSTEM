package assignment;

import java.util.Scanner;
import java.util.*;
import java.io.*;


public class Student implements java.io.Serializable{
    
    protected int studentid;    
    protected String studentname;
    protected String intake;
    protected String program;
    private ArrayList<Module> module_list;
    protected static final long serialVersionUID = 1L;
    
    public Student(){};
    
    public Student(int studentid, String studentname, String intake, String program) {
        this.studentid = studentid;
        this.studentname = studentname;
        this.intake = intake;
        this.program = program;
    }
    
    public void setstudentid(int studentid) {
        this.studentid = studentid;
    }

    public void setstudentname(String studentname) {
        this.studentname = studentname;
    }

    public void setintake(String intake) {
        this.intake = intake;
    }
    
    public void setprogram(String program) {
        this.program = program;
    }
    
    public void setmodule(ArrayList module_list){
        this.module_list = module_list;
    }
    
    public int getstudentid(){
        return studentid;
    }

    public String getstudentname() {
        return studentname;
    }

    public String getintake() {
        return intake;
    }
    
    public String getprogram(){
        return program;
    }
    
    public ArrayList getmodule(){
        return module_list;
    }
    
    public String toString() {
        return "\nID: " + getstudentid() + "\nStudent name: " + getstudentname() + "\nIntake: " + getintake() + "\nProgram: " +getprogram();
    }
    
 }

 
