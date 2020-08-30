
package assignment;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;


public class Mark extends Student implements java.io.Serializable {
    
    //Association
    private int assignment_mark;
    private int test_mark;
    private int exam_mark;
    private int total_mark;
    

    public Mark(){}
    
    public Mark(int studentid, String studentname, String intake, String program, int assignment_mark,int test_mark,int exam_mark) {
        super(studentid, studentname, intake, program);
        this.assignment_mark=assignment_mark;
        this.test_mark=test_mark;
        this.exam_mark=exam_mark;
    }
    
    public void setassignment_mark(int assignment_mark) {
        this.assignment_mark=assignment_mark;
    }
    
    public void settest_mark(int test_mark){
        this.test_mark=test_mark;
    }
    
    public void setexam_mark(int exam_mark){
        this.exam_mark=exam_mark;
    }
    
    public int getassignment_mark(){
        return assignment_mark;
    }
    
    public int gettest_mark(){
        return test_mark;
    }
    
    public int getexam_mark(){
        return exam_mark;
    }
    
    public int findtotal_mark(){
        total_mark = assignment_mark + test_mark + exam_mark;
        return total_mark;
    }
    
    public void setstudent(Student student){
        this.studentid = student.getstudentid();
        this.studentname = student.getstudentname();
        this.intake = student.getintake();
        this.program = student.getprogram();
    }
    
    public String toString(){
        return "\nStudent: " +getstudentname() + "\nTotal Marks: " + findtotal_mark(); 
       
    }

}
