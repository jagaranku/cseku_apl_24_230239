/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectNo1;

import java.io.*;
import java.util.*;
public class  Arraylist_of_Student implements Serializable {
//     public  static void main(String[] args) {
          ArrayList<Student> stlist ;
          

          public Arraylist_of_Student()
          {
               stlist=new ArrayList<Student>();

          }
          public void addStudent(Student s)
          {
              stlist.add(s);
          }
          public void deleteStudent(int  index)
          {
              stlist.remove(index);
          }
          public void updateStudent(int in,Student s)
          {
              stlist.set(in,s);
          }
          public Student getStudent(int in)
          {
              return stlist.get(in);
          }
          public int getIndex(Student s)
          {
              return stlist.indexOf(s);
          }
              
          public boolean Contains (Student s)    
          {
              return stlist.contains(s);
          }
              
          public int numOfStudents()
                  {
                      return stlist.size();
                  }
          public   ArrayList<Student> getlist()
          {
              return stlist;
          }
          public void sortStudent()
          {
              Collections.sort(stlist);
          }
             
          public boolean isEmpty() {
                 return stlist.isEmpty();
            }
//          public String toString() {
//        StringBuilder sb = new StringBuilder("");
//        for (Student s : stlist) {
//            sb.append(s);
//        }
//      return sb.toString();
//    }
          

         


}
