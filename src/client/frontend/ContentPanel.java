package client.frontend;

import client.backend.Controller;
import client.backend.Student;

import javax.swing.*;
import java.awt.*;

/**
 * Created by LU on 15/12/13.
 */
public class ContentPanel extends JPanel{
    private static final Dimension rigidSize = new Dimension(40, 40);
    private MainFrame father;
    private JLabel numberLabel;
    private JLabel nameLabel;
    private JLabel genderLabel;
    private ImageIcon photoIcon;
    private Student student;
    private JLabel photoLabel;

    public ContentPanel(MainFrame father) {
        this.father = father;
        this.setBorder(BorderFactory.createTitledBorder("Student Information"));

        this.setSize(300, 300);

        numberLabel = new JLabel();
        nameLabel = new JLabel();
        genderLabel = new JLabel();
        photoIcon = new ImageIcon();
        photoLabel = new JLabel(photoIcon);
        photoLabel.setSize(20, 20);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.add(Box.createRigidArea(rigidSize));

        JPanel numberPanel = new JPanel();
        numberPanel.setLayout(new BoxLayout(numberPanel, BoxLayout.X_AXIS));
        numberPanel.add(new JLabel("Number: "));
        numberPanel.add(numberLabel);
        infoPanel.add(numberPanel);
        infoPanel.add(Box.createRigidArea(rigidSize));

        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
        namePanel.add(new JLabel("Name: "));
        namePanel.add(nameLabel);
        infoPanel.add(namePanel);
        infoPanel.add(Box.createRigidArea(rigidSize));

        JPanel genderPanel = new JPanel();
        genderPanel.setLayout(new BoxLayout(genderPanel, BoxLayout.X_AXIS));
        genderPanel.add(new JLabel("Gender: "));
        genderPanel.add(genderLabel);
        infoPanel.add(genderPanel);
        infoPanel.add(Box.createRigidArea(rigidSize));

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(Box.createRigidArea(new Dimension(20, 20)));
        this.add(photoLabel);
        this.add(Box.createRigidArea(new Dimension(20, 20)));
        this.add(infoPanel);
        this.add(Box.createRigidArea(new Dimension(20, 20)));

        refresh();
    }

    public void refresh() {
        String studentNumber = father.getSelectedStudent();
        if (studentNumber != null) {
            student = Controller.getStudentInformation(studentNumber);
            numberLabel.setText(student.getNumber());
            nameLabel.setText(student.getName());
            genderLabel.setText(student.getGender().toString());
            photoIcon.setImage(student.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
            photoLabel.updateUI();
        } else {
            numberLabel.setText("");
            numberLabel.setText("");
            genderLabel.setText("");
        }
    }

}
