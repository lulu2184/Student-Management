package client.frontent;

import client.backend.Controller;
import client.backend.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by LU on 15/12/13.
 */
public class ContentPanel extends JPanel{
    private MainFrame father;
    private JLabel numberLabel;
    private JLabel nameLabel;
    private JLabel genderLabel;
    private ImageIcon photoIcon;
    private Student student;

    public ContentPanel(MainFrame father) {
        this.father = father;
        this.setBorder(BorderFactory.createTitledBorder("Student Information"));

        this.setSize(300, 300);

        numberLabel = new JLabel();
        nameLabel = new JLabel();
        genderLabel = new JLabel();
        photoIcon = new ImageIcon();
        JLabel photoLabel = new JLabel(photoIcon);
        photoLabel.setSize(50, 50);
        this.add(new JLabel("Number: "));
        this.add(numberLabel);
        this.add(new JLabel("Name: "));
        this.add(nameLabel);
        this.add(new JLabel("Gender: "));
        this.add(genderLabel);
        this.add(photoLabel);
        refresh();
    }

    public void refresh() {
        String studentNumber = father.getSelectedStudent();
        if (studentNumber != null) {
            student = Controller.getStudentInformation(studentNumber);
            numberLabel.setText(student.getNumber());
            nameLabel.setText(student.getName());
            genderLabel.setText(student.getGender().toString());
            photoIcon.setImage(student.getImage());
        } else {
            numberLabel.setText("");
            numberLabel.setText("");
            genderLabel.setText("");
        }
    }

}
