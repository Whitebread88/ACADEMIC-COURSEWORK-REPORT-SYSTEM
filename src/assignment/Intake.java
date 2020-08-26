
package assignment;

import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Intake implements java.io.Serializable{
    
    protected String intakecode;
    
    public Intake(){};
    
    public Intake(String intakecode){
        this.intakecode = intakecode;
    }
    
    public void setintakecode(String intakecode){
        this.intakecode=intakecode;
    }
    
    public String getintakecode(){
        return intakecode;
    }
    
    public String toString(){
        return "\nIntake Code: " +getintakecode();
    }
}
