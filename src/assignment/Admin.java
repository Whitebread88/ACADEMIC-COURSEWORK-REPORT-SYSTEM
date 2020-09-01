package assignment;

import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Admin extends Users implements java.io.Serializable{

    private int stu_id; //no use
    
    public Admin(String username, String password, String firstname, String lastname){
        super(username, password, firstname, lastname);
    }
    
    public void login() {
        
        int flag = 0;
        while (flag == 0) {
            System.out.println(" \nWelcome to Admin login page\nEnter username:");
            Scanner sc = new Scanner(System.in);
            String admin_username = sc.nextLine();
            if (admin_username.equals("admin")) {
                System.out.println("\nEnter password:");
                String admin_password = sc.nextLine();
                if (admin_password.equals("admin")) {
                    flag = 1;
                } else {
                    System.out.println("\nIncorrect Password\nPlease try again");
                }
            } else {
                System.out.println("\nIncorrect Username\nPlease try again");
            }
        }
        System.out.println("Login Successful");
        admin_function();
    }
    
    public void admin_function() { 
        Scanner sc = new Scanner(System.in);
        int adminchoice;
        System.out.println("\nWelcome to Admin page");
        System.out.println("\n Select function:\n 1.Manage Module\n 2.Manage Student\n 3.Register Lecturer\n 4.Exit \n\n Selection:");
        adminchoice = sc.nextInt();
        sc.nextLine();
        switch (adminchoice) {
            case 1:
                manage_module();
                break;
            case 2:
                manage_student();
                break;
            case 3:
                lecturer_register();
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("\nInvalid Option.\nPlease try again.");
                admin_function();
        }
    }
    
    public void lecturer_register() {
        ArrayList<Lecturer> lecturer_list = new ArrayList<>();
        ArrayList<Lecturer> lecture_list = LandingPage.ReadFromFile("Lecturer.txt");
        Scanner sc = new Scanner(System.in);
        int username_flag = 0;
        int usernamefile = 0;
        String lect_username;
        System.out.println("\nRegister new lecturer");
        do {
            System.out.println("Enter new lecturer username: ");
            lect_username = sc.nextLine();
            for (Lecturer lectinput : lecture_list) {
                if (lectinput.getusername().equals(lect_username)) {
                    username_flag = 1;
                }
            }
            if (username_flag == 0) {
                usernamefile = 1;
            } else {
                username_flag = 0;
                System.out.println("Username already exists.\n");
            }
        } while (usernamefile == 0);

        int flag = 0;
        String lect_password = "";
        while (flag == 0) {
            System.out.println("\nEnter Password:");
            String password = sc.nextLine();
            System.out.println("\nRetype Password:");
            lect_password = sc.nextLine();
            if (password.equals(lect_password)) {
                flag = 1;
            } else {
                System.out.println("\nPassword does not match\nPlease try Again");
            }
        }

        System.out.println("\nEnter First Name:");
        String lect_firstname = sc.nextLine();
        System.out.println("\nEnter Last Name:");
        String lect_lastname = sc.nextLine();
        Lecturer new_lecturer = new Lecturer(lect_username, lect_password, lect_firstname, lect_lastname);
        lecture_list.add(new_lecturer);
        LandingPage.WriteIntoFile("Lecturer.txt", lecture_list);
        System.out.println("\nLecture registration successfull");
        System.out.println("\nDo you want to continue?\n >1.Main Menu \n >2.Exit");
        int ans = sc.nextInt();
        sc.nextLine();
        switch (ans) {
            case 1:
                admin_function();
                break;

            case 2:
                System.out.println("\n< Thank you! >");
                break;
        }
    }
    
    public void manage_module(){
        Scanner sc = new Scanner(System.in);
        int adminchoice;
        System.out.println("\nWelcome to Module page");
        System.out.println("\n Select function:\n 1.New intake\n 2.Add module\n 3.View module\n 4.Delete Module\n 5.Exit \n 6.Main Menu \n\n Selection:");
        adminchoice = sc.nextInt();
        sc.nextLine();
        switch (adminchoice) {
            case 1:
                new_intake();
                break;
            case 2:
                add_module();
                break;
            case 3:
                view_module();
                break;
            case 4:
                delete_module();
            case 5:
                System.exit(0);
                break;
            case 6:
                admin_function();
                break;
            default:
                System.out.println("\nInvalid Option.\nPlease try again.");
                manage_module();
        }  
    }
    
    
    public void new_intake(){
        ArrayList<Intake> intake_list = new ArrayList<>();
        intake_list = LandingPage.ReadFromFile("Intake.txt");
        Scanner sc = new Scanner(System.in);
        int intakechecker = 0;
        int ic_record = 0;
        String ic;
            
        //Check if studentID already exists
        System.out.print("----<Add new intake>----\n");

        do {
            System.out.print("\nPlease enter Intake Code:");
            ic = sc.nextLine();
            for (Intake intake_file: intake_list) {
                if (intake_file.getintakecode().equals(ic)) {    
                    System.out.print("\n---< Intake already existed >---\n");
                    intakechecker = 1;
                }
            }
            if (intakechecker == 0) {
                ic_record = 1;
            } else {
                intakechecker = 0;
            }
            }while (ic_record == 0);
                
        
        //Write information into the file
        Intake RegisteredIntake = new Intake(ic);
        intake_list.add(RegisteredIntake);
        LandingPage.WriteIntoFile("Intake.txt", intake_list);
        System.out.println("\n ----< New intake created successfully! >----");
        System.out.println("\nDo you want to continue?\n >1.Main Menu \n >2.Exit");
        int ans = sc.nextInt();
        sc.nextLine();
        switch (ans) {
            case 1:
                admin_function();
                break;

            case 2:
                System.out.println("\n< Thank you! >");
                 System.exit(0);
                break;
        }
  
    }
    
   public void add_module(){
       ArrayList<Module> module_list = LandingPage.ReadFromFile("Module.txt");
       ArrayList<Intake> intake_list = LandingPage.ReadFromFile("Intake.txt");
        Scanner sc = new Scanner(System.in);
        int intake_checker = 0;
        int intake_record = 0;
        int modname_checker =0;
        int modname_record =0;
        int modcode_checker =0;
        int modcode_record =0;

        //Check if intake already exists
        System.out.print("----<Add new module>----\n");
        do{
        System.out.println("\nPlease enter intake code: ");
        String intake_code = sc.nextLine();
        for (Intake intakefromfile : intake_list) {
                    if (intake_code.equals(intakefromfile.getintakecode())) { 
                        intake_checker = 1;   
                    }
                    }
            if (intake_checker == 1) {
                intake_record = 1;
            }else{
                intake_checker = 0;
                System.out.print("\n---< Intake does not exist,unable to add module >---\n");
                System.out.println("\nDo you want to try again?\n >1.Try again \n >2.Main Menu \n3.Exit");
                int ans = sc.nextInt();
                sc.nextLine();
                switch (ans) {
                case 1:
                    add_module();
                break;
                case 2:
                    admin_function();
                    break;
                case 3:
                     System.out.println("\n< Thank you! >");
                      System.exit(0);
                break;
            }
            }
        } while (intake_record == 0);
        
        //Write information into the file
        
        System.out.print("\nPlease enter Module Name:");
        String mod_name = sc.nextLine();
       for (Module  module_file: module_list) {
                if (module_file.getmodulename().equals(mod_name)) {        
                    modname_checker = 1;
                }
            }
            if (modname_checker == 0) {
                modname_record =0 ;
            } else {
                modname_checker = 1;
                System.out.print("\n---< Module name already exists >---\n"); //check if module name exists 
                System.out.println("\nDo you want to try again?\n >1.Try again \n >2.Main Menu \n3.Exit");
                int ans = sc.nextInt();
                sc.nextLine();
                switch (ans) {
                case 1:
                    add_module();
                break;
                case 2:
                    admin_function();
                    break;
                case 3:
                     System.out.println("\n< Thank you! >");
                      System.exit(0);
                break;
            }
            }

            do{

                         System.out.print("\nPlease enter Module Code:"); //check if module code exists 
                         int mod_code = sc.nextInt();
                        for (Module  module_file: module_list) {
                        if (module_file.getmodulecode() == mod_code) {        
                            modcode_checker = 1;
                        }
                    }
                    if (modcode_checker == 0) {
                        modcode_record =0 ;
                    } else {
                        modcode_checker = 1;
                        System.out.print("\n---< Module code already exists >---\n");
                        System.out.println("\nDo you want to try again?\n >1.Try again \n >2.Main Menu \n3.Exit");
                        int ans = sc.nextInt();
                        sc.nextLine();
                        switch (ans) {
                        case 1:
                            add_module();
                        break;
                        case 2:
                            admin_function();
                        break;
                        case 3:
                             System.out.println("\n< Thank you! >");
                              System.exit(0);
                        break;
                    }
                    }
                                 
                            System.out.println("\n ----< New module created successfully! >----");
                             Module RegisteredModule = new Module(mod_name,mod_code);
                            module_list.add(RegisteredModule);
                            System.out.println(RegisteredModule);
                            LandingPage.WriteIntoFile("Module.txt", module_list);
                            System.out.println("\nDo you want to continue?\n >1.Main Menu \n >2.Exit");
                             int ans1 = sc.nextInt();
                            sc.nextLine();
                            switch (ans1) {
                                case 1:
                                    admin_function();
                                    break;

                                case 2:
                                    System.out.println("\n< Thank you! >");
                                     System.exit(0);
                                    break;
                                     }
                                
                         } while (modname_record == 0);
   }
  



   public void delete_module() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n----< Delete Module>----");
        System.out.print("Please enter module code to delete: ");
        int moduleToDelete = sc.nextInt();
        int moduleExists = 0;
        sc.nextLine();
        ArrayList<Module> module_list = LandingPage.ReadFromFile("Module.txt");
        Iterator<Module> iter = module_list.iterator();        //Iterator to delete module
        while (iter.hasNext()) {
            Module moduleinfile = iter.next();
            if (moduleinfile.getmodulecode() == moduleToDelete) { //Check if module code exists
                iter.remove();
                moduleExists = 1;
                System.out.println("\nThe module : " + moduleToDelete + " has been deleted.");
            }
        }
        if (moduleExists == 0) {
                System.out.println("\n--No associated module exists in system--");
        }
        LandingPage.WriteIntoFile("Module.txt", module_list);
        System.out.println("\nDo you want to continue?\n >1.Main Menu \n >2.Try again \n>3.Exit");
        int ans = sc.nextInt();
        sc.nextLine();
        switch (ans) {
            case 1:
                admin_function();
                break;

            case 2:
                delete_module();
                break;
                
            case 3:
                System.out.println("\n< Thank you!>");
                 System.exit(0);
                break;
        }
   }

   
   public void view_module() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Module> module_list = LandingPage.ReadFromFile("Module.txt");
        int i = 1;
        System.out.println("\n----< Module Details >----\nBelows are the information of modules:\n");
        for (Module modulefromfile : module_list) {
            System.out.println("Module" + i + ":");
            System.out.println(modulefromfile);
            System.out.println("-------------------------");
            i++;
            }
        System.out.println("\nDo you want to continue?\n >1.Main Menu \n >2.Exit");
        int ans = sc.nextInt();
        sc.nextLine();
        switch (ans) {
            case 1:
                admin_function();
                break;

            case 2:
                System.out.println("\n< Thank you! >");
                 System.exit(0);
                break;
        }
        }
   
    
    public void manage_student(){
        Scanner sc = new Scanner(System.in);
        int adminchoice;
        System.out.println("\nWelcome to Student Management page");
        System.out.println("\n Select function:\n 1.Add student\n 2.Delete Student\n 3.Search Student\n 4.Edit student details\n 5.View student details \n 6.Manage Mark\n 7.Exit \n 8.Main Menu \n\n Selection:");
        adminchoice = sc.nextInt();
        sc.nextLine();
        switch (adminchoice) {
            case 1:
                add_student();
                break;
            case 2:
                delete_student();
                break;
            case 3:
                search_student();
                break;
            case 4:
                edit_student();
            case 5:
                view_student();
                break;
            case 6:
                manage_mark();
                break;
            case 7:
                System.exit(0);
                break;
            case 8:
                admin_function();
                break;
            default:
                System.out.println("\nInvalid Option.\nPlease try again.");
                manage_student();
        }  
    }
    
    public void manage_mark(){
        Scanner sc = new Scanner(System.in);
        int adminchoice;
        System.out.println("\nWelcome to Marks Management page");
        System.out.println("\n Select function:\n 1.View all marks\n 2.Generate report\n 3.Exit \n\n Selection:");
        adminchoice = sc.nextInt();
        sc.nextLine();
        switch (adminchoice) {
            case 1:
                view_mark();
                break;
            case 2:
                //generate_report();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("\nInvalid Option.\nPlease try again.");
                manage_mark();
        } 
       
    }
    
     public void view_mark() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Mark> mark_list = LandingPage.ReadFromFile("Mark.txt");
        int i = 1;
        System.out.println("\n----< Student Marks Details >----\nBelows are the information of students marks:\n");
        for (Mark mark : mark_list) {
            System.out.print("Student # " + i + " : " +mark.getstudent() + "\nModule: " +mark.getmodule() +"\nTotal Mark:" +mark.findtotalmark());
            System.out.println("\n-------------------------------");
            i++;
        }
            System.out.println("\nDo you want to continue?\n >1.Main Menu \n >2.Exit");
            int ans = sc.nextInt();
            sc.nextLine();
            switch (ans) {
            case 1:
                admin_function();
                break;

            case 2:
                System.out.println("\n< Thank you! >");
                 System.exit(0);
                break;
            }
     }
     
     
    public void add_student(){
        ArrayList<Student> student_list = LandingPage.ReadFromFile("Student.txt");
        ArrayList<Intake> intake_list = LandingPage.ReadFromFile("Intake.txt");
        Scanner sc = new Scanner(System.in);
        int idchecker = 0;
        int idrecord = 0;
        int stu_id;    
        int intake_checker =0;
        int intake_record =0;
        
        
        //Check if studentID already exists
        System.out.print("----<Register student>----\n");

        do {
            System.out.print("\nPlease enter student ID:");
            stu_id = sc.nextInt();
            sc.nextLine();
            for (Student student_file: student_list) {
                if (student_file.getstudentid() == stu_id) {        
                    idchecker = 1;
                }
            }
            if (idchecker == 0) {
                idrecord = 1;
            } else {
                idchecker = 0;
                System.out.print("\n---< ID already existed >---\n");
                System.out.println("\nDo you want to try again?\n >1.Try again \n >2.Main Menu \n>2.Exit");
                int ans = sc.nextInt();
                sc.nextLine();
                switch (ans) {
                case 1:
                    add_student();
                break;
                case 2:
                    admin_function();
                    break;
                case 3:
                     System.out.println("\n< Thank you! >");
                      System.exit(0);
                break;
            }
            }
        } while (idrecord == 0);
        //Input new student details
        //Record new student details
        System.out.print("\nName of student:");
        String newstudentname = sc.nextLine();

        System.out.print("\nIntake: "); 
        String newintake = sc.nextLine();
        for (Intake intake_file: intake_list) {
                if (intake_file.getintakecode().equals(newintake)) {        
                    intake_checker = 1;
                }
            }
            if (intake_checker == 1) {
                intake_record = 1;
            } else {
                intake_checker = 0;
                System.out.print("\n---< Intake does not exist >---\n");
                System.out.println("\nDo you want to try again?\n >1.Try again \n >2.Main Menu \n>3.Exit");
                int ans = sc.nextInt();
                sc.nextLine();
                switch (ans) {
                case 1:
                    add_student();
                break;
                case 2:
                    admin_function();
                    break;
                case 3:
                     System.out.println("\n< Thank you! >");
                      System.exit(0);
                break;
            }
            }
  
        do{
        System.out.print("\nProgram: ");
        String newprogram = sc.nextLine();
    

        //Write all the information into the file
         System.out.println("\n ----< New student created successfully! >----");
        Student RegisteredStudent = new Student(stu_id,newstudentname,newintake,newprogram);
        student_list.add(RegisteredStudent);
        System.out.println(RegisteredStudent);
        LandingPage.WriteIntoFile("Student.txt", student_list);
        System.out.println("\nDo you want to continue?\n >1.Main Menu \n >2.Exit");
        int ans = sc.nextInt();
        sc.nextLine();
        switch (ans) {
            case 1:
                admin_function();
                break;

            case 2:
                System.out.println("\n< Thank you! >");
                 System.exit(0);
                break;
        }
        }while (intake_record == 1);
        
    }
    
     public void delete_student() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" \n ----< Delete student >---- \nPlease enter ID number of student to delete: ");
        int idToDelete = sc.nextInt();
        int checkIdExists = 0;
        sc.nextLine();
        ArrayList student_list = LandingPage.ReadFromFile("Student.txt");
        Iterator<Student> iter = student_list.iterator();
        while (iter.hasNext()) {
            Student c = iter.next();
            if (c.getstudentid() == idToDelete) {
                iter.remove();
                checkIdExists = 1;
                System.out.println("\n--The student with the ID " + idToDelete + " has been deleted--");
            }
        }
        if (checkIdExists == 0) {
            System.out.println("\n --ID does not exist--");
        }
        LandingPage.WriteIntoFile("Student.txt", student_list);
        System.out.println("\nDo you want to continue?\n >1.Main Menu \n >2.Exit");
        int ans = sc.nextInt();
        sc.nextLine();
        switch (ans) {
            case 1:
                admin_function();
                break;

            case 2:
                System.out.println("\n< Thank you! >");
                 System.exit(0);
                break;
    }
}
      public void search_student() {
        ArrayList<Student> student_list = LandingPage.ReadFromFile("Student.txt");
        Scanner sc = new Scanner(System.in);
        System.out.print("\n----< Student Search >---- \nPlease enter Student ID to search: ");
        int idToSearch = sc.nextInt();
        sc.nextLine();
        int idExists = 0;
        for (Student student_file: student_list) {
                if (student_file.getstudentid() == idToSearch) {
                System.out.println("\nThe student details as below:");
                System.out.println(student_file);
                System.out.println("----------------------------------------");
                idExists = 1;
            }
        }
        if (idExists == 0) {
            System.out.println("\n--Student account not found--");
        }
        LandingPage.WriteIntoFile("Student.txt", student_list);
        System.out.println("\nDo you want to continue?\n >1.Main menu \n >2.Try again \n>3.Exit");
        int ans = sc.nextInt();
        sc.nextLine();
        switch (ans) {
            case 1:
                admin_function();
                break;

            case 2:
                search_student();
                break;
                
            case 3:
                System.out.println("\n<Thank you! >");
                 System.exit(0);
                break;
            }
        }
      
      public void edit_student() {
        System.out.println("\n----< Edit student details>----\n");
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> student_list = LandingPage.ReadFromFile("Student.txt");
        ArrayList<Intake> intake_list = LandingPage.ReadFromFile("Intake.txt");
        Student s1 = new Student();
        int intake_checker = 0;
        int intake_record =0;
        System.out.print("\nPlease enter ID number of student to edit: ");
        int idToEdit = sc.nextInt();
        sc.nextLine();
        int idExists = 0;
        for (Student studentfromfile : student_list) {
            if (studentfromfile.getstudentid() == idToEdit) {
                s1 = studentfromfile;
                idExists = 1;
            }
        }
        if (idExists != 1) {
            System.out.println("\n--Account not found--");
             System.out.println("\nDo you want to continue?\n >1.Main Menu \n >2.Try again \n>3.Exit");
            int ans = sc.nextInt();
            sc.nextLine();
            switch (ans) {
            case 1:
                admin_function();
                break;

            case 2:
                edit_student();
                
            case 3:
                System.out.println("\n< Thank you! >");
                 System.exit(0);
                break;
            }
        } else {
            System.out.println("\nAccount details as follows:" + s1 + "\n------------------------------");
            int editChoice;

            do { //Loop to repeat edit student menu
                System.out.println("\n Please select the information to update:\n >1.Name\n >2.Intake \n >3.Program\n \n >Enter 999 to finalise student details");
                editChoice = sc.nextInt();
                sc.nextLine();
                switch (editChoice) {
                    case 1: //Update first name
                        System.out.println("\nPlease enter new name:");
                        String newname = sc.nextLine();
                        s1.setstudentname(newname);
                        System.out.println("\nFirst name has been updated into: " + s1.getstudentname() + "\n------------------------------");
                        break;

                    case 2: //Update intake
                        System.out.println("\nPlease enter new intake code:");
                        String newintake = sc.nextLine();
                        for (Intake intake_file: intake_list) {
                        if (intake_file.getintakecode().equals(newintake)) {        
                        intake_checker = 1;
                      }
                        }
                        if (intake_checker == 1) {
                            intake_record = 1;
                        } else {
                            intake_checker = 0;
                            System.out.print("\n---< Intake does not exist >---\n");
                            System.out.println("\nDo you want to try again?\n >1.Try again \n >2.Exit");
                            int ans = sc.nextInt();
                            sc.nextLine();
                            switch (ans) {
                            case 1:
                               edit_student();
                            break;
                            case 2:
                                 System.out.println("\n< Thank you! >");
                                  System.exit(0);
                            break;
                        }
                        }
                
                        s1.setintake(newintake);
                        System.out.println("\nIntake has been updated into: " + s1.getintake() + "\n------------------------------");
                        break;
                     
                        
                    case 3: //Update program
                        System.out.println("\nPlease enter new program:");
                        String newprogram = sc.nextLine();
                        s1.setprogram(newprogram);
                        System.out.println("\nIntake has been updated into: " + s1.getprogram() + "\n------------------------------");
                        break;

                    case 999: //Display updated details
                        System.out.println("\nUpdated student details as below:\n" + s1 + "\n------------------------------");
                        break;

                    default:
                        break;
                            }
            } while (editChoice != 999);
            
            Iterator<Student> iter = student_list.iterator();        //Iterator to delete old student details
            while (iter.hasNext()) {
                Student s = iter.next();
                if (s.getstudentid() == s1.getstudentid()) {
                    iter.remove();
                }
            }
            student_list.add(s1);        //Add new details into the list
            LandingPage.WriteIntoFile("Student.txt", student_list);
            System.out.println("\nDo you want to continue?\n >1.Main Menu \n >2.Exit");
            int ans = sc.nextInt();
            sc.nextLine();
            switch (ans) {
            case 1:
                admin_function();
                break;

            case 2:
                System.out.println("\n< Thank you! >");
                 System.exit(0);
                break;
            }
        }
        }
      
      public void view_student() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> student_list = LandingPage.ReadFromFile("Student.txt");
        int i = 1;
        System.out.println("\n----< Student Details >----\nBelows are the information of students:\n");
        for (Student student : student_list) {
            System.out.print("Student " + i + " :");
            System.out.println(student);
            System.out.println("--------------------------");
            i++;
        }
        System.out.println("\nDo you want to continue?\n >1.Main Menu \n >2.Exit");
            int ans = sc.nextInt();
            sc.nextLine();
            switch (ans) {
            case 1:
                admin_function();
                break;

            case 2:
                System.out.println("\n< Thank you! >");
                 System.exit(0);
                break;
            }
    }
      
    public void add_Smodule(Student ArrayList){
        
        Scanner sc = new Scanner(System.in);
        Module newmodule = new Module();
        ArrayList<Mark> mark_list = new ArrayList<>();

        ArrayList<Module> module_list = LandingPage.ReadFromFile("Module.txt");
        int i = 1;
        System.out.println("\nModules are: ");
        for (Module modulefromfile : module_list) {
            System.out.println("Module" + i + ":");
            System.out.println(modulefromfile);
            System.out.println("-------------------------");
            i++;
        }
        
        System.out.print("\nPlease enter Module Code to add to student:");
        int module_code = sc.nextInt();
        sc.nextLine();


//        newmodule.setmodulecode(mod_code);
//        module_list.add(newmodule);
//
//        module_list.add(new Module(newmodule));
//        System.out.println("\nIntake has been updated into: " + s1.getmodule() + "\n------------------------------");
                        
    }


       
    }