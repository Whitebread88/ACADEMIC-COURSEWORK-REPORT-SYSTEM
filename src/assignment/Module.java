package assignment;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Module implements java.io.Serializable{
    private String modulename;
    private String code;

    public Module(){};
    
    public Module(String modulename, String code) {
        this.modulename = modulename;
        this.code = code;
    }
    
    public void setmodulename(String modulename) {
        this.modulename = modulename;
    }
        
    public void setcode(String code) {
        this.code = code;
    }
    
    public String getmodulename() {
        return modulename;
    }

    public String getcode() {
        return code;
    }

}
