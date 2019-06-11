package q3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
* Class student that that saves the student's name and enrollment date
* @author Cameron Anzola
* @class COP5339 001
* @data 2/17/2018
*/
public class Student {
	private String name; // last, first
	private Date enrollmentDate;
	
	/**
	*  Main method, demonstrates the use of Student class
	*  @precondition none
	*  @postcondition program will have executed
	*/
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// make list of students
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student("Obama, Barack", new Date(1961, 7, 4)));
		students.add(new Student("Trump, Donald", new Date(1946, 5, 14)));
		students.add(new Student("Biden, Joe", new Date(1942, 10, 20)));
		students.add(new Student("Pence, Mike", new Date(1959, 5, 7)));
		// print list
		System.out.println("Unsorted List");
		for (Student s : students)
			System.out.println(s.getName() + " enrolled on " + s.getEnrollmentDate());
		// sort by name and print
		Comparator<Student> comp = getCompByName();
		Collections.sort(students, comp);
		System.out.println("Sorted List by Name");
		for (Student s : students)
			System.out.println(s.getName() + " enrolled on " + s.getEnrollmentDate());
		// sort by date and print
		comp = getCompByDate();
		Collections.sort(students, comp);
		System.out.println("Sorted List by Date");
		for (Student s : students)
			System.out.println(s.getName() + " enrolled on " + s.getEnrollmentDate());
	}
	
	/**
	*  Constructor for Student object
	*  @precondition a string and a date
	*  @postcondition new instance of Student
	*/
	public Student(String name, Date whenEnrolled) {
		this.name =  name;
		enrollmentDate = whenEnrolled;
	}

	/**
	*  Get the name of student
	*  @precondition an instance of Student exist
	*  @return a string of the students name
	*/
	public String getName() {
		return this.name;
	}
	
	/**
	*  Get the date the student enrolled
	*  @precondition an instance of Student exist
	*  @return a date of the students enrollment
	*/
	public Date getEnrollmentDate() {
		return (Date) this.enrollmentDate.clone();
	}
	
	/**
	*  Anonymous classes that implement the Comparator interface.
	*  A static method that returns a new comparator object for Student 
	*  that compares 2 Students objects by their name.
	*  @precondition list of Students is greater then 0
	*  @return a Comparator object of students 
	*/
	public static Comparator<Student> getCompByName() {
		return new Comparator<Student>() {
		      public int compare(Student student1, Student student2) {
		    	  return student1.getName().compareTo(student2.getName());
		      }
		   };
	}
	
	/**
	*  Anonymous classes that implement the Comparator interface.
	*  A static method that returns a new comparator object for Student 
	*  that compares 2 Students objects by their enrollment date.
	*  @precondition list of Students is greater then 0
	*  @return a Comparator object of students 
	*/
	public static Comparator<Student> getCompByDate() {
		return new Comparator<Student>() {
		      public int compare(Student student1, Student student2) {
		    	  return student1.getEnrollmentDate().compareTo(student2.getEnrollmentDate());
		      }
		   };
	}
}
