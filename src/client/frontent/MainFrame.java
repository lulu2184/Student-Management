package client.frontent;

import javax.swing.*;
import java.awt.*;

/**
 * Created by LU on 15/12/13.
 */
public class MainFrame extends JFrame{
    JPanel titlePanel;
    ListPanel listPanel;
    ContentPanel contentPanel;

    public MainFrame() {
        this.setSize(400, 400);

        this.setLayout(new GridBagLayout());
        titlePanel = new JPanel();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 0;
        constraints.gridheight = 10;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(3,3,3,3);
        this.add(titlePanel, constraints);
        titlePanel.setBackground(Color.BLUE);

        this.setLayout(new GridBagLayout());
        listPanel = new ListPanel();
        constraints = new GridBagConstraints();
        constraints.gridx = 10;
        constraints.gridy = 0;
        constraints.gridwidth = 10;
        constraints.gridheight = 0;
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.insets = new Insets(3,3,3,3);
        this.add(listPanel, constraints);
        listPanel.setBackground(Color.RED);

        this.setLayout(new GridBagLayout());
        contentPanel = new ContentPanel();
        constraints = new GridBagConstraints();
        constraints.gridx = 10;
        constraints.gridy = 10;
        constraints.gridwidth = 0;
        constraints.gridheight = 0;
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.insets = new Insets(3,3,3,3);
        this.add(contentPanel, constraints);
        contentPanel.setBackground(Color.GREEN);

        this.setVisible(true);
    }


}
