
package assignment;

import java.util.ArrayList;
import java.io.Serializable;

public class Mark implements java.io.Serializable {
    
    //Association
    private int markid;
    private int testmark;
    private int exammark;
    private int assignmentmark;
    private int totalmark;
    private ArrayList<Mark> marklist;
    private String grade;
    private String comment;
    private double gpa;
    private double cgpa;
    private Module module;
    private Student student;
    private static final long serialVersionUID = 1L;
    

    public Mark(){}
    
    public Mark(Student student,Module module, int markid,int testmark,int exammark , int assignmentmark) {
        this.student = student;
        this.module = module;
        this.markid = markid;
        this.testmark = testmark;
        this.exammark = exammark;
        this.assignmentmark = assignmentmark;

    }
    
    public void setmarkid(int markid){
        this.markid = markid;
    }
    
    public int getmarkid(){
        return markid;
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
    
    public String grade(){
       if ( totalmark >= 0 & totalmark < 40){
           grade = "Fail";
       } else if ( totalmark >=40 & totalmark <50 ){
           grade = "D";
      } else if ( totalmark >=50 & totalmark <60 ){
           grade = "C";
      } else if ( totalmark >=60 & totalmark <70 ){
           grade = "B";
       } else if ( totalmark >=70 & totalmark <80 ){
           grade = "B+";
       }  else if ( totalmark >=80 & totalmark <90 ){
           grade = "A";
      } else if ( totalmark >=90 & totalmark <100 ){
           grade = "A+";
      }
       return grade;
    }
    
    public String comment(){
        if (grade.equals("Fail")){
            comment = "Bad.Try harder";
        } else if(grade.equals("D")){
            comment = "Try harder";
        } else if(grade.equals("C")){
            comment = "Average";
        }else if(grade.equals("B")){
            comment = "Satisfactory";
        }else if(grade.equals("B+")){
            comment = "Not bad";
        }else if(grade.equals("A")){
            comment = "Good";
        }else if(grade.equals("A+")){
            comment = "Excellent";
    }
        return comment;
    }
    
    public void setcomment(String comment){
        this.comment = comment;
    }
    
    public String getcomment(){
        return comment;
    }
    
    public void setgrade(String grade){
        this.grade = grade;
    }
          
    public String getgrade(){
        return grade;
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

    public double gpa(){
        if ( totalmark >= 0 & totalmark < 40){
           gpa = 2.0;
       } else if ( totalmark >=40 & totalmark <50 ){
           gpa = 2.5;
      } else if ( totalmark >=50 & totalmark <60 ){
           gpa = 2.75;
      } else if ( totalmark >=60 & totalmark <70 ){
           gpa = 3.00;
       } else if ( totalmark >=70 & totalmark <80 ){
           gpa = 3.30;
       }  else if ( totalmark >=80 & totalmark <90 ){
           gpa = 3.70;
      } else if ( totalmark >=90 & totalmark <100 ){
           gpa = 4.00;
      }
       return gpa;
    }
    
  public void setgpa(double gpa){
        this.gpa = gpa;
    }
    
    public double getgpa(){
        return gpa;
    }
    
    public double cgpa(){
             return cgpa;
        }


    
    public String toString(){
        return "\nStudent: " +getstudent() + "\nModule: " +getmodule() + "\nMark ID: " +getmarkid() +"\nTest Mark: " +gettestmark() + "\nExam Mark: " +getexammark() +"\nAssignment Mark: " +getassignmentmark() + "\nTotal Marks: " + findtotalmark() + "\nGrade: " +grade() +  "\nGrade Point: " +gpa() + "\nComment: " +comment() +"\n-------------------------------------------"; 
    }  

   
    
    

}
