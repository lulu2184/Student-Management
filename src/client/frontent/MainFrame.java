package client.frontent;

import javax.swing.*;
import java.awt.*;

/**
 * Created by LU on 15/12/13.
 */
public class MainFrame extends JFrame{
    private JPanel titlePanel;
    private ListPanel listPanel = new ListPanel(this);
    private ContentPanel contentPanel = new ContentPanel(this);
    private AddStudentFormFrame addFrame;

    public MainFrame() {
        this.setSize(400, 400);

        this.setLayout(new FlowLayout());
        this.add(listPanel);
        this.add(contentPanel);
//
//        this.setLayout(new GridBagLayout());
//        titlePanel = new JPanel();
//        titlePanel.setSize(400, 50);
//        GridBagConstraints constraints = new GridBagConstraints();
//        constraints.gridx = 0;
//        constraints.gridy = 0;
//        constraints.gridwidth = 0;
//        constraints.gridheight = 1;
//        constraints.fill = GridBagConstraints.HORIZONTAL;
//        constraints.insets = new Insets(3,3,3,3);
//        this.add(titlePanel, constraints);
//        titlePanel.setBackground(Color.BLUE);
//
//        this.setLayout(new GridBagLayout());
//        listPanel = new ListPanel();
//        listPanel.setSize(100, 350);
//        constraints = new GridBagConstraints();
//        constraints.gridx = 1;
//        constraints.gridy = 0;
//        constraints.gridwidth = 1;
//        constraints.gridheight = 0;
//        constraints.fill = GridBagConstraints.VERTICAL;
//        constraints.insets = new Insets(3,3,3,3);
//        this.add(listPanel, constraints);
//        listPanel.setBackground(Color.RED);
//
//        this.setLayout(new GridBagLayout());
//        contentPanel = new ContentPanel();
//        contentPanel.setSize(300, 350);
//        constraints = new GridBagConstraints();
//        constraints.gridx = 1;
//        constraints.gridy = 1;
//        constraints.gridwidth = 0;
//        constraints.gridheight = 0;
//        constraints.fill = GridBagConstraints.VERTICAL;
//        constraints.insets = new Insets(3,3,3,3);
//        this.add(contentPanel, constraints);
//        contentPanel.setBackground(Color.GREEN);
//
        this.setVisible(true);
    }

    public void setAddForm(AddStudentFormFrame frame) {
        this.addFrame = frame;
        frame.setVisible(true);
//        this.setEnabled(false);
    }

    public void refreshList() {
        listPanel.refresh();
    }

    public void refreshContent() {
        contentPanel.refresh();
    }

    public String getSelectedStudent() {
        return listPanel.getSelectedStudent();
    }
}
