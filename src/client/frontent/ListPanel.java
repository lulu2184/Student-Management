package client.frontent;

import client.backend.Controller;
import com.sun.codemodel.internal.JOp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by LU on 15/12/13.
 */
public class ListPanel extends JPanel{
    private static final Dimension size = new Dimension(100, 300);
    private JList<Integer> list;
    private JScrollPane scrollPane;
    private JButton addButton;
    private JButton deleteButton;
    private MainFrame father;

    public ListPanel(MainFrame father) {
        this.father = father;
        List<Integer> intList = Controller.getStudentList();
        if (intList != null) {
            list = new JList<>(intList.toArray(new Integer[0]));
        }
        scrollPane = new JScrollPane(list);
        this.add(scrollPane);
        this.add(getAddButton());
        this.add(getDeleteButton());
    }

    public void refresh() {
        List<Integer> intList = Controller.getStudentList();
        if (intList != null) {
            list.setListData(intList.toArray(new Integer[0]));
        }
    }

    private JButton getAddButton() {
        if (addButton == null) {
            addButton = new JButton();
            addButton.setText("add");
            addButton.addActionListener(new AddAction());
            addButton.setSize(50, 50);
        }
        return addButton;
    }

    private JButton getDeleteButton() {
        if (deleteButton == null) {
            deleteButton = new JButton();
            deleteButton.setText("delete");
            deleteButton.addActionListener(new DeleteAction());
            deleteButton.setSize(50, 50);
        }
        return deleteButton;
    }

    private class AddAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            father.setAddFrame(new AddStudentFormFrame());
        }
    }

    private class DeleteAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Integer item = list.getSelectedValue();
            if (item == null) {
                JOptionPane.showMessageDialog(null, "No selected student.", "error", JOptionPane.ERROR_MESSAGE);
            } else {
                Controller.deleteStudent(item);
                refresh();
            }
        }
    }
}
