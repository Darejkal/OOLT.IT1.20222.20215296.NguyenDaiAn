package hust.soict.it1.StudentManage;
import java.util.Scanner;
import hust.soict.it1.StudentManage.exceptions.*;
public class Student {
    private int studentID;
    private String studentName;
    private MyDate birthday = new MyDate();
    private float gpa;
    public Student() { }
    public Student(int studentID, String studentName) {
    	setStudentID(studentID);
    }
    public Student(int studentID, String studentName, String birthday) {
    	this(studentID, studentName);
	try {
	    setBirthday(birthday);
	} catch (IllegalBirthdayException e) {
	    e.printStackTrace();
	}
    }
    public Student(int studentID, String studentName, String birthday, float gpa) {
	this(studentID, studentName, birthday);
	try {
	    setGpa(gpa);
	} catch (IllegalGPAException e) {
	    e.printStackTrace();
	}
    }
    public void setStudentID(int studentID) { this.studentID = studentID; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public void setGpa(float gpa) throws IllegalGPAException {
    	if (gpa > 10.0 || gpa < 0.0)
    	    throw new IllegalGPAException();
	this.gpa = gpa;
    }
    public void setBirthday(String birthday) throws IllegalBirthdayException {
    	if (birthday == null)
    	    throw new IllegalBirthdayException();
    	this.birthday.setDateFromString(birthday);
    	if (!this.birthday.isValid())
    	    throw new IllegalBirthdayException();
    }
    public int getStudentID() { return this.studentID; }
    public String getStudentName() { return this.studentName; }
    public float getGpa() { return this.gpa; }
    public String getBirthday() {
    	String birthdayString = String.format("%d/%d/%d", birthday.getDay(), birthday.getMonth(), birthday.getYear());
    	return birthdayString;
    }
    public void printStudentManage() {
    	System.out.println("Student ID  : " + getStudentID());
    	System.out.println("Student Name: " + getStudentName());
    	System.out.println("Student Birthday: " + getBirthday());
    	System.out.println("Student GPA : " + getGpa());
    }
    public static void main(String[] args) {
    	Student a;
    	Scanner stdin = new Scanner(System.in);
    	try {
	    a = new Student();
	    System.out.print("Student ID: ");
	    a.setStudentID(stdin.nextInt());
	    stdin.skip("\n");
	    System.out.print("Student name: ");
	    a.setStudentName(stdin.nextLine());
	    System.out.print("Student birthday: ");
	    a.setBirthday(stdin.nextLine());
	    System.out.print("Student GPA: ");
	    a.setGpa(stdin.nextFloat());
	    a.printStudentManage();
	} catch (Exception e) { }
	stdin.close();
    }
}
