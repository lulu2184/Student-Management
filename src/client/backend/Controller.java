package client.backend;

import java.util.List;

/**
 * Created by LU on 15/12/13.
 */
public class Controller {
    public static Integer addStudent(Student student) {
        String content = Parser.studentToString(student);
        content = "ADD\r\n" + content + "\r\nEND\r\n";
        String[] result = ClientTalker.request(content).split("\n");
        if (result.length > 0 && result[0].equals("OK")) {
            return 0;
        } else {
            return 1;
        }
    }

    public static Integer deleteStudent(Integer number) {
        String content = number.toString() + "\r\nEND\r\n";
        content = "DELETE\r\n" + content;
        String[] result = ClientTalker.request(content).split("\n");
        if (result.length > 0 && result[0].equals("OK")) {
            return 0;
        } else {
            return 1;
        }
    }

    public static List<Integer> getStudentList() {
        String content = "GET_LIST\r\nEND\r\n";
        String[] result = ClientTalker.request(content).split("\n");
        if (result.length > 0 && result[0].equals("OK")) {
            return Parser.stringToStudentList(result[1]);
        } else {
            return null;
        }
    }

    public static Student getStudentInformation(Integer number) {
        String content = "GET_INFO\r\nEND\r\n";
        content = content + "Student Number: " + number.toString();
        String[] result = ClientTalker.request(content).split("\n");
        if (result.length > 0 && result[0].equals("OK")) {
            return Parser.stringToStudent(result[1]);
        } else {
            return null;
        }
    }
}
