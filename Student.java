/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectNo1;


import java.util.Objects;
import java.io.Serializable;

public class Student implements Serializable,Comparable<Student> {
    private String name,student_id;
    private  Adress adress;
    public Student(String name, String stid, Adress ad)
    {
        this.name=name;
        student_id=stid;
        adress=ad;
    }

    public boolean equals(Object obj)
    {
        Student s=(Student) obj;
        return this.name.equals(s.name) && this.student_id.equals(s.student_id) && this.adress.equals(s.adress);
    }
//    public  String toString()
//    {
//        return "Student Name : "+name+"\nStudent Id : "+student_id+"\n"+adress;
//    }
    public  String getName()
    {
        return name;
    }
    public  String getStudent_id()
    {
        return student_id;
    }
    public Adress getAdress()
    {
        return adress;
    }

    @Override
    public int compareTo(Student s) {
        return this.student_id.compareTo(s.student_id);
    }
}
