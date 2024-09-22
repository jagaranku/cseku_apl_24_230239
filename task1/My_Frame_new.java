package ProjectNo1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/*
   MyFrame class represents the main graphical user interface for managing a student database.
   It allows users to add, update, delete, sort, and navigate through student records.
 */

public class MyFrame extends JFrame implements ActionListener, Serializable {

    // GUI Components
    private JButton buttonAdd, buttonUpdate, buttonDelete, buttonSort;
    private JButton buttonFirstStudent, buttonPreviousStudent, buttonNextStudent, buttonLastStudent;
    private JTextField textFieldIndex, textFieldName, textFieldStudentId, textFieldDistrict, textFieldRoad, textFieldPostcode;
    private JLabel labelName, labelStudentId, labelRoad, labelPostcode, labelDistrict, labelAddress, labelTitle;

    // Student List
    private Arraylist_of_Student studentList = new Arraylist_of_Student();

  
    private int currentIndex = 0, totalStudents = 0;

    /*
      Constructor to initialize the MyFrame instance.
      Sets up the GUI and loads existing student data.
     */

    MyFrame() {
        setupGUI();
        loadStudentData();
        if (!studentList.isEmpty()) {
            populateTextFields(studentList.getStudent(currentIndex), currentIndex + 1);
        }
    }

    
  // Sets up the GUI components and layout.
    
    private void setupGUI() {
        initializeTextFields();
        initializeButtons();

        this.setLayout(null);
        this.setVisible(true);
        this.setSize(650, 500);
        this.setTitle("Student Database");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        // Adding components to the frame

        addComponentsToFrame();
    }

    
  // Loads student data from a serialized file.
    
    public void loadStudentData() {
        try {
            FileInputStream fileInputStream = new FileInputStream("stdatabase.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            studentList = (Arraylist_of_Student) objectInputStream.readObject();
            totalStudents = studentList.numOfStudents();
            objectInputStream.close();
            fileInputStream.close();
            JOptionPane.showMessageDialog(null, "Successfully read student data.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "File not found or error reading file.");
        }
    }


    // Saves the current student list to a serialized file.

    public void saveStudentData() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("stdatabase.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(studentList);
            objectOutputStream.close();
            fileOutputStream.close();
            JOptionPane.showMessageDialog(null, "Successfully saved student data.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error writing to file: " + e.getMessage());
        }
    }

    
    // Initializes the text fields used for student data input.
    
    private void initializeTextFields() {
        textFieldName = new JTextField();
        textFieldName.setBounds(150, 50, 440, 30);
        labelName = new JLabel("Student Name:");
        labelName.setBounds(50, 50, 100, 30);

        labelTitle = new JLabel("Data Manipulation Form");
        labelTitle.setBounds(250, 10, 150, 30);

        textFieldStudentId = new JTextField();
        textFieldStudentId.setBounds(150, 100, 440, 30);
        labelStudentId = new JLabel("Student ID:");
        labelStudentId.setBounds(50, 100, 100, 30);

        labelAddress = new JLabel("Address:");
        labelAddress.setBounds(50, 150, 100, 30);

        textFieldRoad = new JTextField();
        textFieldRoad.setBounds(250, 180, 340, 30);
        labelRoad = new JLabel("Road:");
        labelRoad.setBounds(150, 180, 100, 30);

        textFieldPostcode = new JTextField();
        textFieldPostcode.setBounds(250, 230, 340, 30);
        labelPostcode = new JLabel("Postcode:");
        labelPostcode.setBounds(150, 230, 100, 30);

        textFieldDistrict = new JTextField();
        textFieldDistrict.setBounds(250, 280, 340, 30);
        labelDistrict = new JLabel("District:");
        labelDistrict.setBounds(150, 280, 100, 30);

        textFieldIndex = new JTextField("0/0");
        textFieldIndex.setBounds(300, 330, 50, 30);
        textFieldIndex.setEditable(false);
        textFieldIndex.setBackground(Color.white);
    }

    
    // Initializes the navigation buttons.

    private void initializeButtons() {
        buttonFirstStudent = new JButton("|<");
        buttonFirstStudent.setBounds(50, 330, 60, 30);
        buttonFirstStudent.addActionListener(this);

        buttonPreviousStudent = new JButton("<<");
        buttonPreviousStudent.setBounds(110, 330, 65, 30);
        buttonPreviousStudent.addActionListener(this);

        buttonNextStudent = new JButton(">>");
        buttonNextStudent.setBounds(375, 330, 65, 30);
        buttonNextStudent.addActionListener(this);

        buttonLastStudent = new JButton(">|");
        buttonLastStudent.setBounds(540, 330, 60, 30);
        buttonLastStudent.addActionListener(this);

        buttonAdd = new JButton("Add");
        buttonAdd.setBounds(50, 385, 90, 30);
        buttonAdd.addActionListener(this);

        buttonUpdate = new JButton("Update");
        buttonUpdate.setBounds(200, 385, 100, 30);
        buttonUpdate.addActionListener(this);

        buttonDelete = new JButton("Delete");
        buttonDelete.setBounds(350, 385, 100, 30);
        buttonDelete.addActionListener(this);

        buttonSort = new JButton("Sort");
        buttonSort.setBounds(500, 385, 100, 30);
        buttonSort.addActionListener(this);
    }

    
    // Adds all components to the JFrame.
    
    private void addComponentsToFrame() {
        this.add(buttonAdd);
        this.add(buttonUpdate);
        this.add(buttonDelete);
        this.add(buttonSort);
        this.add(buttonFirstStudent);
        this.add(buttonPreviousStudent);
        this.add(buttonNextStudent);
        this.add(buttonLastStudent);
        this.add(labelName);
        this.add(textFieldName);
        this.add(labelStudentId);
        this.add(textFieldStudentId);
        this.add(labelAddress);
        this.add(labelRoad);
        this.add(textFieldRoad);
        this.add(labelPostcode);
        this.add(textFieldPostcode);
        this.add(labelDistrict);
        this.add(textFieldDistrict);
        this.add(textFieldIndex);
        this.add(labelTitle);
    }

    
    // Fills the text fields with the student's information.
    
    public void populateTextFields(Student student, int index) {
        textFieldName.setText(student.getName());
        textFieldStudentId.setText(student.getStudent_id());
        textFieldRoad.setText(student.getAdress().getRoad());
        textFieldPostcode.setText(student.getAdress().getPostcode());
        textFieldDistrict.setText(student.getAdress().getDistrict());
        textFieldIndex.setText(index + "/" + totalStudents);
    }

    
    // Clears all text fields.
    
    private void clearTextFields() {
        textFieldName.setText("");
        textFieldStudentId.setText("");
        textFieldRoad.setText("");
        textFieldPostcode.setText("");
        textFieldDistrict.setText("");
        textFieldIndex.setText("0/0");
    }

    
    // Creates a new Student object based on the input from the text fields.
   
    private Student createNewStudent() {
        if (textFieldName.getText().isEmpty() || textFieldStudentId.getText().isEmpty() ||
            textFieldRoad.getText().isEmpty() || textFieldPostcode.getText().isEmpty() ||
            textFieldDistrict.getText().isEmpty()) {
            return null;
        } else {
            return new Student(
                textFieldName.getText(),
                textFieldStudentId.getText(),
                new Address(
                    textFieldRoad.getText(),
                    textFieldPostcode.getText(),
                    textFieldDistrict.getText()
                )
            );
        }
    }

    
    // Handles button click events.
  
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonAdd) {
            Student newStudent = createNewStudent();
            if (newStudent == null) {
                JOptionPane.showMessageDialog(null, "Student is not properly created.");
            } else if (studentList.Contains(newStudent)) {
                JOptionPane.showMessageDialog(null, "Student already exists.");
            } else {
                studentList.addStudent(newStudent);
                totalStudents++;
                currentIndex = totalStudents - 1;
                saveStudentData();
                populateTextFields(studentList.getStudent(currentIndex), currentIndex + 1);
            }
        }

        if (e.getSource() == buttonUpdate) {
            Student updatedStudent = createNewStudent();
            if (studentList.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Student list is empty.");
            } else if (updatedStudent == null) {
                JOptionPane.showMessageDialog(null, "Student is not properly created.");
            } else {
                studentList.updateStudent(currentIndex, updatedStudent);
                saveStudentData();
                populateTextFields(studentList.getStudent(currentIndex), currentIndex + 1);
            }
        }

        if (e.getSource() == buttonDelete) {
            if (!studentList.isEmpty()) {
                Student studentToDelete = createNewStudent();
                if (studentList.Contains(studentToDelete)) {
                    currentIndex = studentList.getIndex(studentToDelete);
                    studentList.deleteStudent(currentIndex);
                    saveStudentData();
                    totalStudents--;
                    if (currentIndex == totalStudents) {
                        currentIndex--;
                    }
                    if (studentList.isEmpty()) {
                        clearTextFields();
                    } else {
                        populateTextFields(studentList.getStudent(currentIndex), currentIndex + 1);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Student doesn't exist.");
                }
            }
        }

        if (e.getSource() == buttonSort) {
            if (!studentList.isEmpty()) {
                studentList.sortStudent();
                saveStudentData();
                currentIndex = 0;
                populateTextFields(studentList.getStudent(currentIndex), currentIndex + 1);
            }
        }

        if (e.getSource() == buttonFirstStudent) {
            currentIndex = 0;
            if (!studentList.isEmpty()) {
                populateTextFields(studentList.getStudent(currentIndex), currentIndex + 1);
            }
        }

        if (e.getSource() == buttonPreviousStudent) {
            if (currentIndex > 0) {
                currentIndex--;
            } else {
                JOptionPane.showMessageDialog(null, "No previous students.");
            }
            if (!studentList.isEmpty()) {
                populateTextFields(studentList.getStudent(currentIndex), currentIndex + 1);
            }
        }

        if (e.getSource() == buttonNextStudent) {
            if (currentIndex < totalStudents - 1) {
                currentIndex++;
            } else {
                JOptionPane.showMessageDialog(null, "No next students.");
            }
            if (!studentList.isEmpty()) {
                populateTextFields(studentList.getStudent(currentIndex), currentIndex + 1);
            }
        }

        if (e.getSource() == buttonLastStudent) {
            currentIndex = totalStudents - 1;
            if (!studentList.isEmpty()) {
                populateTextFields(studentList.getStudent(currentIndex), currentIndex + 1);
            }
        }
    }
}
