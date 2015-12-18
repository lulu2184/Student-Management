package client.frontend;

import javax.swing.*;
import java.awt.*;

/**
 * Created by LU on 15/12/13.
 */
public class MainFrame extends JFrame{
    private ListPanel listPanel = new ListPanel(this);
    private ContentPanel contentPanel = new ContentPanel(this);
    private AddStudentFormFrame addFrame;

    public MainFrame() {
        this.setSize(400, 400);

        this.setLayout(new GridBagLayout());

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        bottomPanel.add(listPanel);
        bottomPanel.add(contentPanel);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 0;
        constraints.gridheight = 0;
        this.add(bottomPanel, constraints);

        this.setVisible(true);
    }

    public void setAddForm(AddStudentFormFrame frame) {
        this.addFrame = frame;
        frame.setVisible(true);
    }

    public void refreshList(boolean setLastSelected) {
        listPanel.refresh(setLastSelected);
        contentPanel.refresh();
    }

    public void refreshContent() {
        contentPanel.refresh();
    }

    public String getSelectedStudent() {
        return listPanel.getSelectedStudent();
    }
}
