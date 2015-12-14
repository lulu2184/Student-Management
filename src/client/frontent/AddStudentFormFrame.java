package client.frontent;

import client.backend.Controller;
import client.backend.Student;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by LU on 15/12/14.
 */
public class AddStudentFormFrame extends JFrame{
    private MainFrame father;
    private JTextField numberField;
    private JTextField nameField;
    private ButtonGroup genderButtonGroup;
    private JRadioButton maleButton;
    private JRadioButton femaleButton;
    private JButton submitButton;
    private JButton addFileButton;
    private String path = null;

    private static FileFilter jpgFileFilter = new FileFilter() {
        @Override
        public boolean accept(File f) {
            return f.isDirectory() || f.getName().toLowerCase().endsWith(".jpg");
        }

        @Override
        public String getDescription() {
            return "*.jpg";
        }
    };

    public AddStudentFormFrame(MainFrame father) {
        this.father = father;

        this.setSize(246, 190);
        this.setResizable(false);
        this.setLayout(new FlowLayout());

        this.add(new JLabel("Number: "));
        this.add(getNumberField());
        this.add(new JLabel("Name:    "));
        this.add(getNameField());
        this.add(new JLabel("Gender: "));
        getGenderButtonGroup();
        this.add(maleButton);
        this.add(femaleButton);
        this.add(new JLabel("Photo: "));
        this.add(getAddFileButton());
        this.add(getSubmitButton());
    }

    private JTextField getNameField() {
        if (nameField == null) {
            nameField = new JTextField();
            nameField.setSize(50, 20);
            nameField.setColumns(10);
        }
        return nameField;
    }

    private JTextField getNumberField() {
        if (numberField == null) {
            numberField = new JTextField();
            numberField.setSize(50, 20);
            numberField.setColumns(10);
        }
        return numberField;
    }

    private void getGenderButtonGroup() {
        if (genderButtonGroup == null) {
            genderButtonGroup = new ButtonGroup();
            maleButton = new JRadioButton("male");
            femaleButton = new JRadioButton("female");
            genderButtonGroup.add(maleButton);
            genderButtonGroup.add(femaleButton);
        }
    }

    private JButton getAddFileButton() {
        if (addFileButton == null) {
            addFileButton = new JButton();
            addFileButton.setText("choose file..");
            addFileButton.setSize(50, 20);
            addFileButton.addActionListener(new AddFileAction());
        }
        return addFileButton;
    }

    private JButton getSubmitButton() {
        if (submitButton == null) {
            submitButton = new JButton();
            submitButton.setText("submit");
            submitButton.addActionListener(new SubmitAction());
        }
        return submitButton;
    }

    private class SubmitAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String number = numberField.getText();
            String name = nameField.getText();
            if (number == null || number.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Number field is empty.");
                return;
            }
            if (!number.matches("^[0-9]+$")) {
                JOptionPane.showMessageDialog(null, "Number field must be numbers.");
                return;
            }
            if (name == null || name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name field is empty");
                return;
            }
            if (path == null) {
                JOptionPane.showMessageDialog(null, "No selected photo image.");
                return;
            }
            if (!femaleButton.isSelected() && !maleButton.isSelected()) {
                JOptionPane.showMessageDialog(null, "Not seleted gender.");
                return;
            }
            Student.Gender gender;
            if (femaleButton.isSelected()) gender = Student.Gender.FEMALE;
            else gender = Student.Gender.MALE;
            Controller.addStudent(new Student(number, name, path, gender));
            father.refresh();
            dispose();
        }
    }

    private class AddFileAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser fd = new JFileChooser();
            fd.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            fd.setAcceptAllFileFilterUsed(false);
            fd.setFileFilter(jpgFileFilter);
            fd.showOpenDialog(null);
            File file = fd.getSelectedFile();
            if (file != null) {
                path = file.getPath();
            }
        }
    }
}
