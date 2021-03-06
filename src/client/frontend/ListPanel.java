package client.frontend;

import client.backend.Controller;
import client.backend.Parser;
import client.backend.ServerMessage;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by LU on 15/12/13.
 */
public class ListPanel extends JPanel{
    private JList<String> list;
    private JScrollPane scrollPane;
    private JButton addButton;
    private JButton deleteButton;
    private MainFrame father;

    public ListPanel(MainFrame father) {
        this.father = father;
        list = new JList<>();
        scrollPane = new JScrollPane(list);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(scrollPane);
        this.add(getAddButton());
        this.add(getDeleteButton());

        this.setBorder(BorderFactory.createTitledBorder("Student List"));
        refresh(false);
        if (list.getModel().getSize() > 0) {
            list.setSelectedIndex(0);
        }
        list.addListSelectionListener(new ListSelectionChangeAction());
    }

    public void refresh(boolean setLastSelected) {
        ServerMessage msg = Controller.getStudentList();
        if (!msg.success) {
            JOptionPane.showMessageDialog(null, msg.message);
            return;
        }
        List<String> studentList = Parser.stringToStudentList(msg.message);
        if (studentList != null) {
            list.setListData(studentList.toArray(new String[0]));
        }
        if (setLastSelected) {
            list.setSelectedIndex(studentList.size() - 1);
        }
    }

    public String getSelectedStudent() {
        return list.getSelectedValue();
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
            father.setAddForm(new AddStudentFormFrame(father));
        }
    }

    private class DeleteAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String item = list.getSelectedValue();
            Integer index = list.getSelectedIndex();
            if (item == null) {
                JOptionPane.showMessageDialog(null, "No selected student.", "error", JOptionPane.ERROR_MESSAGE);
            } else {
                ServerMessage msg = Controller.deleteStudent(item);
                if (msg.success) {
                    refresh(false);
                    if (index >= list.getModel().getSize()) {
                        index--;
                    }
                    list.setSelectedIndex(index);
                } else {
                    JOptionPane.showMessageDialog(null, "Fail: " + msg.message);
                }
            }
        }
    }

    private class ListSelectionChangeAction implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            father.refreshContent();
        }
    }
}
