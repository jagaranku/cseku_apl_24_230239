package ProjectNo1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.*;
//import java.util.*;

//import static Project_Frame.Arraylist_of_Student.cindex;
//import static Project_Frame.Arraylist_of_Student.totalstudents;
public class My_Frame extends JFrame implements ActionListener, Serializable {

    JButton bAdd, bUpdate, bDelete, bSort, bFirstStudent, bPreStudent, bNextStudent, bLastStudent;
    JTextField box, textfield_name, textfield_stid, textfield_dst, textfield_rd, textfield_pc;
    JLabel label_name, label_stid, label_rd, label_pc, label_dst, label_ad, label_title;

    Arraylist_of_Student as=new Arraylist_of_Student();

    private int cs = 0, totalstudents = 0;

    My_Frame() {
        // write();
        swing();
        read();
        if (as.isEmpty() == false) {
            fillup_textbox(as.getStudent(cs), cs + 1);
        }

    }

    private void swing() {
        Textfield();
        uButton();
        dButton();

        this.setLayout(null);
        this.setVisible(true);
        this.setSize(650, 500);
        this.setTitle("Student Database");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(bAdd);
        this.add(bUpdate);
        this.add(bDelete);
        this.add(bSort);
        this.add(bFirstStudent);
        this.add(bPreStudent);
        this.add(bNextStudent);
        this.add(bLastStudent);
        this.add(label_name);
        this.add(textfield_name);
        this.add(label_stid);
        this.add(textfield_stid);
        this.add(label_ad);
        this.add(label_rd);
        this.add(textfield_rd);
        this.add(label_pc);
        this.add(textfield_pc);
        this.add(label_dst);
        this.add(textfield_dst);
        this.add(box);
        this.add(label_title);
    }

    public void read() {

        try {

            FileInputStream flin = new FileInputStream("stdatabase.ser");
            ObjectInputStream ois = new ObjectInputStream(flin);

            as = (Arraylist_of_Student)ois.readObject();
            totalstudents = as.numOfStudents();
            ois.close();
            flin.close();
            //return item;
            JOptionPane.showMessageDialog(null, "Successfully read.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "File is not found");

        }
    }

    public void write() {

        try {

            FileOutputStream flout = new FileOutputStream("stdatabase.ser");
            ObjectOutputStream oos = new ObjectOutputStream(flout);

            oos.writeObject(as);
            oos.close();
            flout.close();
            JOptionPane.showMessageDialog(null, "Successfully write.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void Textfield() {
        textfield_name = new JTextField();
        textfield_name.setBounds(150, 50, 440, 30);

        label_name = new JLabel();
        label_name.setBounds(50, 50, 100, 30);
        label_name.setText("Student Name : ");
        label_title = new JLabel();
        label_title.setBounds(250, 10, 150, 30);
        label_title.setText("Data Manipulation Form");
        textfield_stid = new JTextField();
        textfield_stid.setBounds(150, 100, 440, 30);
        label_stid = new JLabel();
        label_stid.setBounds(50, 100, 100, 30);
        label_stid.setText("Student Id : ");

        label_ad = new JLabel();
        label_ad.setBounds(50, 150, 100, 30);
        label_ad.setText("Adress : ");

        textfield_rd = new JTextField();
        textfield_rd.setBounds(250, 180, 340, 30);
        label_rd = new JLabel();
        label_rd.setBounds(150, 180, 100, 30);
        label_rd.setText("Road : ");

        textfield_pc = new JTextField();
        textfield_pc.setBounds(250, 230, 340, 30);
        label_pc = new JLabel();
        label_pc.setBounds(150, 230, 100, 30);
        label_pc.setText("Postcode : ");

        textfield_dst = new JTextField();
        textfield_dst.setBounds(250, 280, 340, 30);
        label_dst = new JLabel();
        label_dst.setBounds(150, 280, 100, 30);
        label_dst.setText("District : ");

        box = new JTextField();
        box.setBounds(300, 330, 50, 30);
        box.setText("    " + cs + "/" + totalstudents);
        box.setEditable(false);
        box.setRequestFocusEnabled(false);
        box.setBackground(Color.white);

    }

    private void uButton() {
        bFirstStudent = new JButton();
        bFirstStudent.setBounds(50, 330, 60, 30);
        bPreStudent = new JButton();
        bPreStudent.setBounds(110 + 50, 330, 65, 30);
        bNextStudent = new JButton();
        bNextStudent.setBounds(375 + 50 - 10, 330, 65, 30);
        bLastStudent = new JButton();
        bLastStudent.setBounds(540 - 10, 330, 60, 30);
        bFirstStudent.addActionListener(this);
        bPreStudent.addActionListener(this);
        bNextStudent.addActionListener(this);
        bLastStudent.addActionListener(this);
        bFirstStudent.setText("|<");
        bPreStudent.setText("<<");
        bNextStudent.setText(">>");
        bLastStudent.setText(">|");
        bFirstStudent.setFocusable(false);

        bPreStudent.setFocusable(false);

        bNextStudent.setFocusable(false);
        bLastStudent.setFocusable(false);
    }

    private void dButton() {
        bAdd = new JButton();
        bAdd.setBounds(50, 385, 90, 30);
        bUpdate = new JButton();
        bUpdate.setBounds(200 - 10, 385, 100, 30);
        bDelete = new JButton();
        bDelete.setBounds(350 - 10, 385, 100, 30);
        bSort = new JButton();
        bSort.setBounds(500 - 10, 385, 100, 30);
        bAdd.addActionListener(this);
        bUpdate.addActionListener(this);
        bDelete.addActionListener(this);
        bSort.addActionListener(this);
        bAdd.setText("Add");
        bUpdate.setText("Update");
        bDelete.setText("Delete");
        bSort.setText("Sort");
        bAdd.setFocusable(false);

        bUpdate.setFocusable(false);

        bDelete.setFocusable(false);
        bSort.setFocusable(false);

    }

    public void fillup_textbox(Student s, int in) {
        this.textfield_name.setText(s.getName());
        this.textfield_stid.setText(s.getStudent_id());
        this.textfield_rd.setText(s.getAdress().getRoad());
        this.textfield_pc.setText(s.getAdress().getPostcode());
        this.textfield_dst.setText(s.getAdress().getDistrict());
        this.box.setText("    " + in + "/" + totalstudents);
    }

    private void clear_textbox() {
        textfield_name.setText("");
        textfield_stid.setText("");
        textfield_rd.setText("");
        textfield_pc.setText("");
        textfield_dst.setText("");
        box.setText("    " + 0 + "/" + 0);
    }

    private Student newStudent() {
        if (this.textfield_name.getText().isEmpty() || this.textfield_stid.getText().isEmpty() || this.textfield_rd.getText().isEmpty() || this.textfield_pc.getText().isEmpty() || this.textfield_dst.getText().isEmpty()) {
            return null;
        } else {
            return new Student(textfield_name.getText(), textfield_stid.getText(), new Adress(textfield_rd.getText(), textfield_pc.getText(), textfield_dst.getText()));
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bAdd) {
            Student s = newStudent();
            if (s == null) {
                JOptionPane.showMessageDialog(null, "Student is not properly created.");
            } else if (as.Contains(s)) {
                JOptionPane.showMessageDialog(null, "Student already exists.");
            } else {
                as.addStudent(s);
                totalstudents++;
                cs = totalstudents - 1;
                write();
             //   fillup_textbox(as.getStudent(cs), cs + 1);
            }
//            if(totalstudents>0)fillup_textbox(as.getStudent(cs),cs+1);
//           
            if(totalstudents>0)fillup_textbox(as.getStudent(cs),cs+1);
            else clear_textbox();

        }
        if (e.getSource() == bUpdate) {
            Student s = newStudent();
             if (as.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Student list is empty.");
             }
                else if (s == null) {
                JOptionPane.showMessageDialog(null, "Student is not properly created.");
            
            } else if (as.Contains(s)) {
                JOptionPane.showMessageDialog(null, "Student already exists.");
            } else {
                as.updateStudent(cs, s);

                write();
               // fillup_textbox(as.getStudent(cs), cs + 1);

            }
//            if(totalstudents>0)fillup_textbox(as.getStudent(cs),cs+1);
//           
            if(totalstudents>0)fillup_textbox(as.getStudent(cs),cs+1);
            else clear_textbox();

        }
        if (e.getSource() == bDelete) {
            if (as.isEmpty()==false) {
                Student s = newStudent();
                if (as.Contains(s)) {
                    cs = as.getIndex(s);
                    as.deleteStudent(cs);
                    write();
                    totalstudents--;
                }
                else  JOptionPane.showMessageDialog(null, "Student doesn'n exists.");
                if (cs == totalstudents) {
                    cs--;
                }
                if (as.isEmpty()) {
                    clear_textbox();
                } else {
                    fillup_textbox(as.getStudent(cs), cs + 1);
                }

            }
        }
        if (e.getSource() == bSort) {
            if (!as.isEmpty()) {
                as.sortStudent();
                write();
                cs = 0;
                fillup_textbox(as.getStudent(cs), cs + 1);
            }
        }
        if (e.getSource() == bFirstStudent) {
            cs = 0;
            if (as.isEmpty() == false) {
                fillup_textbox(as.getStudent(cs), cs + 1);
            }
        }
        if (e.getSource() == bPreStudent) {
            if (cs > 0) {
                cs--;
            }
            else JOptionPane.showMessageDialog(null, "There is no students in the previous.");
            if (as.isEmpty() == false) {
                fillup_textbox(as.getStudent(cs), cs + 1);
            }
        }
        if (e.getSource() == bNextStudent) {
            if (cs < totalstudents - 1) {
                cs++;
            }
            else JOptionPane.showMessageDialog(null, "There is no students in the next.");

            if (as.isEmpty() == false) {
                fillup_textbox(as.getStudent(cs), cs + 1);
            }
        }
        if (e.getSource() == bLastStudent) {
            cs = totalstudents - 1;
            if (as.isEmpty() == false) {
                fillup_textbox(as.getStudent(cs), cs + 1);
            }
        }
    }

}
