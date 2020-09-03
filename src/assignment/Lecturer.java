
  
package assignment;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Date;

public class Lecturer extends Users implements java.io.Serializable {

    public Lecturer() {}

    public Lecturer(String username, String password, String firstname, String lastname) {
        super(username, password, firstname, lastname);
    }

    public String toString() {
        return "\nUsername: " + getusername() + "\nFirst name: " + getfirstname() + "\nLast name: " + getlastname();
    }

    public void login() {
        ArrayList<Lecturer> lecturer_list = LandingPage.ReadFromFile("Lecturer.txt");
        Scanner sc = new Scanner(System.in);
        Lecturer lect_login = new Lecturer();
        int flag = 1;
        String lect_username;
        if (flag != 0) {
            System.out.println("\n----< Lecturer Login page >----\nEnter your username: ");
            lect_username = sc.nextLine();
            System.out.println("\nEnter your password: ");
            String lect_password = sc.nextLine();
            for (Lecturer lectinput : lecturer_list) {
                if (lectinput.getusername().equals(lect_username) && lectinput.getpassword().equals(lect_password)) { //Check if customer exists
                    lect_login = lectinput;
                    System.out.println("\n----< Login Successful >----\nGreetings " + lect_login.getfirstname() + " " + lect_login.getlastname());
                    flag = 0;
                    lecturer_function();
                }
            }
            if (flag == 1) {
                System.out.println("\nInvalid Username/Password");
            }

            System.out.println("\nDo you want to retry?\n >1.Retry \n >2.Exit");
            int ans = sc.nextInt();
            sc.nextLine();
            switch (ans) {
                case 1:
                    login();
                    break;

                case 2:
                    System.out.println("\n< Thank you! >");
                    System.exit(0);
                    break;
            }
        }
    }

    public void lecturer_function() {
        Scanner sc = new Scanner(System.in);
        int lecturerchoice;
        System.out.println("\n----< Welcome to Lecturer Page >----");
        System.out.println("\n Select function:\n 1.Manage Student Marks\n 2.Generate Report\n 3.Exit \n\n Selection:");
        lecturerchoice = sc.nextInt();
        sc.nextLine();
        switch (lecturerchoice) {
            case 1:
                manage_mark();
                break;
            case 2:
                generate_report();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("\nInvalid Option.\nPlease try again.");
                lecturer_function();
        }
    }

    public void manage_mark() {
        Scanner sc = new Scanner(System.in);
        int adminchoice;
        System.out.println("\n----< Welcome to Marks Management page >----");
        System.out.println("\n Select function:\n 1.View all students marks \n 2.Add Mark\n 3.Edit Mark \n 4.Delete Mark \n 5.Generate report \n 6.Exit \n\n Selection:");
        adminchoice = sc.nextInt();
        sc.nextLine();
        switch (adminchoice) {
            case 1:
                view_student();
                break;
            case 2:
                add_mark();
                break;
            case 3:
                edit_mark();
                break;
            case 4:
                delete_mark();
            case 5:
                generate_report();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("\nInvalid Option.\nPlease try again.");
                manage_mark();
        }

    }

    public void add_mark() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n----<Add Marks>----");
        ArrayList<Student> student_list = LandingPage.ReadFromFile("Student.txt");
        ArrayList<Mark> mark_list = LandingPage.ReadFromFile("Mark.txt");
        ArrayList<Module> module_list = LandingPage.ReadFromFile("Module.txt");
        Student s = new Student();
        int id_checker = 0;
        int id_record = 0;
        System.out.print("Please enter student ID: ");
        int studentToEdit = sc.nextInt();
        sc.nextLine();
        int idExists = 0;
        for (Student studentfromfile : student_list) {
            if (studentfromfile.getstudentid() == studentToEdit) {
                s = studentfromfile;
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
                    manage_mark();
                    break;

                case 2:
                    add_mark();

                case 3:
                    System.out.println("\n< Thank you! >");
                    System.exit(0);
                    break;
            }
        } else {
            
            Module m = new Module();
            System.out.println("Enter module code to edit marks: ");
            int modulecode = sc.nextInt();
            sc.nextLine();

            int idExists2 = 0;
            for (Module modulefromfile : module_list) {
                if (modulefromfile.getmodulecode() == modulecode) {
                    m = modulefromfile;
                    idExists2 = 1;
                }
            }
            if (idExists2 != 1) {
                System.out.println("\n--Module not found--");
                System.out.println("\nDo you want to continue?\n >1.Main Menu \n >2.Try again \n>3.Exit");
                int ans = sc.nextInt();
                sc.nextLine();
                switch (ans) {
                    case 1:
                        manage_mark();
                        break;

                    case 2:
                        add_mark();

                    case 3:
                        System.out.println("\n< Thank you! >");
                        System.exit(0);
                        break;
                }
            } else {
                
                System.out.println("\nEnter marks: ");
                Module module = new Module();

                System.out.println("Enter Mark ID:  ");
                int markid = sc.nextInt();
                for (Mark mark_file : mark_list) {
                    if (mark_file.getmarkid() == markid) {
                        id_checker = 1;
                    }
                }
                if (id_checker == 0) {
                    id_record = 0;
                } else {
                    id_checker = 1;
                    System.out.print("\n---< Mark ID  already exists >---\n");
                    System.out.println("\nDo you want to try again?\n >1.Try again \n >2.Main Menu \n3.Exit");
                    int ans = sc.nextInt();
                    sc.nextLine();
                    switch (ans) {
                        case 1:
                            add_mark();
                            break;
                        case 2:
                            manage_mark();
                            break;
                        case 3:
                            System.out.println("\n< Thank you! >");
                            System.exit(0);
                            break;
                    }
                }
                System.out.println("\nEnter Test Mark :  ");
                int mark1 = sc.nextInt();
       
                System.out.println("\nEnter Exam Mark :  ");
                int mark2 = sc.nextInt();
               
                System.out.println("\nEnter Assignment Mark :  ");
                int mark3 = sc.nextInt();
                

                Mark marklist = new Mark(s, m, markid, mark1, mark2, mark3);
                mark_list.add(marklist);
                module.setmarklist(mark_list);
                System.out.println("\n Updated student details: \n-----------------------------------------------\n" + marklist);
                
                LandingPage.WriteIntoFile("Mark.txt", mark_list);

                System.out.println("\nDo you want to continue?\n >1.Main Menu \n >2.Try again \n>3.Exit");
                int ans = sc.nextInt();
                sc.nextLine();
                switch (ans) {
                    case 1:
                        manage_mark();
                        break;

                    case 2:
                        add_mark();

                    case 3:
                        System.out.println("\n< Thank you! >");
                        System.exit(0);
                        break;
                }

            }
           
                        }
        }
    
        
    

    public void edit_mark() {
        System.out.println("\n----< Edit mark>----\n");
        Scanner sc = new Scanner(System.in);
        ArrayList<Mark> mark_list = LandingPage.ReadFromFile("Mark.txt");
        Mark m1 = new Mark();
        System.out.print("\nPlease enter ID number of mark to edit: ");
        int idToEdit = sc.nextInt();
        sc.nextLine();
        int idExists = 0;
        for (Mark mark_file : mark_list) {
            if (mark_file.getmarkid() == idToEdit) {
                m1 = mark_file;
                idExists = 1;
            }
        }
        if (idExists != 1) {
            System.out.println("\n--Mark ID not found--");
            System.out.println("\nDo you want to continue?\n >1.Main Menu \n >2.Try again \n>3.Exit");
            int ans = sc.nextInt();
            sc.nextLine();
            switch (ans) {
                case 1:
                    manage_mark();
                    break;

                case 2:
                    edit_mark();

                case 3:
                    System.out.println("\n< Thank you! >");
                    System.exit(0);
                    break;
            }
        } else {
            System.out.println("\nMark details as follows:" + m1);
            System.out.println("\n------------------");

        }
        System.out.println("\n Enter new test mark: ");
        int newtest = sc.nextInt();
        System.out.println("\n Enter new exam mark: ");
        int newexam = sc.nextInt();
        System.out.println("\n Enter new assignment mark: ");
        int newassign = sc.nextInt();

        m1.settestmark(newtest);
        m1.setexammark(newexam);
        m1.setassignmentmark(newassign);
        m1.settotalmark(m1.findtotalmark());
        m1.setgrade(m1.grade());
        m1.setcomment(m1.comment());
        m1.setgpa(m1.gpa());
        
        System.out.println("\nUpdated marks details are as below:\n" + m1);
        System.out.println("\n-------------------");

        Iterator<Mark> iter = mark_list.iterator();        //Iterator to delete old student details
        while (iter.hasNext()) {
            Mark m = iter.next();
            if (m.getmarkid() == m1.getmarkid()) {
                iter.remove();
            }
        }

        mark_list.add(m1);
        LandingPage.WriteIntoFile("Mark.txt", mark_list);
        System.out.println("\nDo you want to continue?\n >1.Main Menu \n >2.Exit");
        int ans = sc.nextInt();
        sc.nextLine();
        switch (ans) {
            case 1:
                manage_mark();
                break;

            case 2:
                System.out.println("\n< Thank you! >");
                System.exit(0);
                break;
        }
    }

    public void view_student() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Mark> mark_list = LandingPage.ReadFromFile("Mark.txt");
        ArrayList<Student> student_list = LandingPage.ReadFromFile("Student.txt");
        int studenthasmark = 0;
        int count = 1;
        System.out.println("\n----< Student Marks Details >----\nBelows are the information of students marks:\n");
        for (Student student : student_list) {
            int temp = student.getstudentid();

            for (Mark mark2 : mark_list) {
                if (temp == mark2.getstudent().getstudentid()) {
                    studenthasmark = 1;
                }
            }
            if (studenthasmark == 1) {
                System.out.print("Student record # " + count + " :" + student.toString() + "\n");
                System.out.println("\n-------------------------------\n");
                for (Mark mark3 : mark_list) {
                    if (temp == mark3.getstudent().getstudentid()) {
                        System.out.println(mark3.getmodule() + "\nMark ID: " + mark3.getmarkid() + "\nTest Mark: " + mark3.gettestmark() + "\nExam Mark: " + mark3.getexammark() + "\nAssignment Mark: " + mark3.getassignmentmark() + "\nTotal Mark: " + mark3.findtotalmark() +"\nGrade: " +mark3.getgrade() +"\nGrade Point: " +mark3.getgpa() +"\nComment: " +mark3.getcomment());
                        System.out.println("\n");
                    }
                }
                studenthasmark = 0;
                count++;
                System.out.println("\n=======================================================");
            }
        }
        System.out.println("\nDo you want to continue?\n >1.Main Menu \n >2.Exit");
        int ans = sc.nextInt();
        sc.nextLine();
        switch (ans) {
            case 1:
                manage_mark();
                break;

            case 2:
                System.out.println("\n< Thank you! >");
                System.exit(0);
                break;
        }
    }

    public void delete_mark() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Mark> mark_list = LandingPage.ReadFromFile("Mark.txt");
        System.out.println(" \n ----< Delete mark >---- \nPlease enter mark ID to delete mark: ");
        int idToDelete = sc.nextInt();
        sc.nextLine();
        Iterator<Mark> markiter = mark_list.iterator();
        int checkIdExists = 0;
        while (markiter.hasNext()) {
            Mark m = markiter.next();
            if (m.getmarkid() == idToDelete) {
                markiter.remove();
                checkIdExists = 1;
                System.out.println("\nThe Mark with ID " + idToDelete + " has been deleted from the mark list.");
            }
        }
        if (checkIdExists == 0) {
            System.out.println("\nMark ID does not exist in mark list.");
        }
        LandingPage.WriteIntoFile("Mark.txt", mark_list);
        System.out.println("\nDo you want to continue?\n >1.Main Menu \n >2.Try again \n>3.Exit");
        int ans = sc.nextInt();
        sc.nextLine();
        switch (ans) {
            case 1:
                manage_mark();
                break;

            case 2:
                delete_mark();
                break;

            case 3:
                System.out.println("\n< Thank you! >");
                System.exit(0);
                break;
        }
    }

    public void generate_report() {
        Document document = new Document();

        try {
            
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Report.pdf"));
            document.open();
            Paragraph p1 = new Paragraph();
            p1.setSpacingBefore(25);
            
            Font font1 = FontFactory.getFont(FontFactory.HELVETICA, 22, Font.BOLD, BaseColor.BLUE);
            Font font2 = FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.ITALIC);
            Font font3 = FontFactory.getFont(FontFactory.TIMES_ROMAN,16,Font.BOLD);
            Font font4 = FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.NORMAL);
    
            
            document.add(new Paragraph("Student Report", font1));
            document.add(new Paragraph("Report generated on " + new Date(), font2));
            p1.setSpacingBefore(25);
           
            ArrayList<Mark> mark_list = LandingPage.ReadFromFile("Mark.txt");
            ArrayList<Student> student_list = LandingPage.ReadFromFile("Student.txt");

            int studenthasmark = 0;
            int count = 1;
            int recordexist =0;
            for (Student student : student_list) {
                int temp = student.getstudentid();

                for (Mark mark2 : mark_list) {
                    if (temp == mark2.getstudent().getstudentid()) {
                        studenthasmark = 1;
                    }
                }
                if (studenthasmark == 1) {
                    document.add(new Paragraph("Student record # "+ count + " :",font3));
                    document.add(new Paragraph(student.toString() + "\n---------------------------------------------------", font4));
                    p1.setSpacingBefore(25);
                    for (Mark mark3 : mark_list) {
                        if (temp == mark3.getstudent().getstudentid()) {
                            recordexist = 1;
                            
                            
                            document.add(new Paragraph(mark3.getmodule() + "\nMark ID: " + mark3.getmarkid() + "\nTest Mark: " + mark3.gettestmark() + "\nExam Mark: " + mark3.getexammark() + "\nAssignment Mark: " + mark3.getassignmentmark() + "\nTotal Mark: " + mark3.findtotalmark() +"\nGrade: " +mark3.grade() + "\nGrade Point: " +mark3.gpa() +"\nComment: " +mark3.comment()));
                            document.add(p1);
                            
                       
                        }
                    }
                    studenthasmark = 0;
                    count++;
                    document.newPage();
                }
            }

            
            
            
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException EX) {
        }
    }

}

