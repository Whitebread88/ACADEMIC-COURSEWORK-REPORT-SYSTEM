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

public abstract class Users implements java.io.Serializable {

    protected String username;
    protected String password;
    protected String firstname;
    protected String lastname;

    public Users(){};
    
    public Users(String username, String password, String firstname, String lastname) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }
    
    public void setusername(String username) {
        this.username = username;
    }
        
    public void setpassword(String password) {
        this.password = password;
    }

    public void setfirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setlastname(String lastname) {
        this.lastname = lastname;
    }
    
    public String getusername() {
        return username;
    }

    public String getpassword() {
        return password;
    }

    public String getfirstname() {
        return firstname;
    }

    public String getlastname() {
        return lastname;
    }



}