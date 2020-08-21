package assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    
    private int studentid;    
    private String studentname;
    private String intake;
    private String program;
    
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
}

