package ProjectNo1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class StudentList implements Serializable { 

   
    private ArrayList<Student> studentList;


   // Constructor to initialize an empty StudentList.
     
    public StudentList() {
        studentList = new ArrayList<>();  // Initialize the ArrayList to store Student objects
    }

  // Adds a Student object to the list.
   
    public void addStudent(Student student) {
        studentList.add(student);
    }

    
  // Deletes a Student object from the list at a specified index.
    
    public void deleteStudent(int index) {
        studentList.remove(index);
    }

    
    // Updates the Student object at the specified index with a new Student object.
     
    public void updateStudent(int index, Student student) {
        studentList.set(index, student);
    }

    
    // Retrieves the Student object at a specified index.
    
    public Student getStudent(int index) {
        return studentList.get(index);
    }

    // Retrieves the index of a specified Student object in the list.
     
    public int getIndex(Student student) {
        return studentList.indexOf(student);
    }


  // Checks if the list contains a specific Student object.
    
    public boolean containsStudent(Student student) { 
        return studentList.contains(student);
    }

    
    //Returns the number of students currently in the list.
    
    public int getNumberOfStudents() { 
        return studentList.size();
    }

    
    // Retrieves the entire list of students.
    
    public ArrayList<Student> getStudentList() { 
        return studentList;
    }


   // Sorts the list of students by their natural ordering;
    
    public void sortStudents() {  
        Collections.sort(studentList);
    }

    
   // Checks if the student list is empty.
     
    public boolean isEmpty() {
        return studentList.isEmpty();
    }

}
