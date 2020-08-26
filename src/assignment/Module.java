package assignment;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Module implements java.io.Serializable{
    
    protected String modulename;
    protected int modulecode;

    
    public Module(String modulename, int modulecode) {
        
        this.modulename = modulename;
        this.modulecode = modulecode;
    }
    
    public Module(){}
    
    public void setmodulename(String modulename) {
        this.modulename = modulename;
    }
        
    public void setmodulecode(int modulecode) {
        this.modulecode = modulecode;
    }
    
    public String getmodulename() {
        return modulename;
    }

    public int getmodulecode() {
        return modulecode;
    }
    
    public String toString(){
        return "\tModule Name: " + getmodulename() + "\tModule Code: " + getmodulecode() +  "\n";
    }


}

