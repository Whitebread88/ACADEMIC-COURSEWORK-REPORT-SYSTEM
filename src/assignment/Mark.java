
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
    private int mark;
    private static final long serialVersionUID = 1L;
    

    public Mark(){}
    
    public Mark(int mark) {
        this.mark = mark;
    }
    
    public void setmark(int mark) {
        this.mark = mark;
    }
    
    public int getmark(){
        return mark;
    }

    public String toString(){
        return "\nTotal Marks: " + getmark(); 
       
    }

}
