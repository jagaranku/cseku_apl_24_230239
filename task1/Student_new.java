package ProjectNo1;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable, Comparable<Student> {
    
    private String name;
    private String studentId;
    private Address address;

    
   // Constructor to initialize the Student object with a name, student ID, and address.
     
    public Student(String name, String studentId, Address address) {
        this.name = name;
        this.studentId = studentId;
        this.address = address;
    }

    /*
      Overrides the equals method to compare two Student objects for equality.
      Two students are considered equal if they have the same name, student ID, and address.
    */
     
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student)) {
            return false;
        }
        Student otherStudent = (Student) obj;
        return this.name.equals(otherStudent.name) && 
               this.studentId.equals(otherStudent.studentId) && 
               this.address.equals(otherStudent.address);
    }

    // get student name
    
    public String getName() {
        return name;
    }

    // get student id
    
    public String getStudentId() {  
        return studentId;
    }

    // get address
    public Address getAddress() { 
        return address;
    }

   
    // Compares this student to another student based on their student IDs. 
    
    @Override
    public int compareTo(Student otherStudent) {
        return this.studentId.compareTo(otherStudent.studentId);
    }

   
}
