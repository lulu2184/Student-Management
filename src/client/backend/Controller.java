package client.backend;

import java.util.ArrayList;
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

    public static Integer deleteStudent(String number) {
        String content = number + "\r\nEND\r\n";
        content = "DELETE\r\n" + "Number:" + content;
        String[] result = ClientTalker.request(content).split("\n");
        if (result.length > 0 && result[0].equals("OK")) {
            return 0;
        } else {
            return 1;
        }
    }

    public static List<String> getStudentList() {
        String content = "GET_LIST\r\nEND\r\n";
        String[] result = ClientTalker.request(content).split("\n");
        if (result.length > 0 && result[0].equals("OK")) {
            if (result.length == 1) {
                return new ArrayList<>();
            } else {
                return Parser.stringToStudentList(result[1]);
            }
        } else {
            return null;
        }
    }

    public static Student getStudentInformation(String number) {
        String content = "GET_INFO\r\n";
        content = content + "Number:" + number + "\r\nEND\r\n";
        String[] result = ClientTalker.request(content).split("\n", 2);
        if (result.length > 0 && result[0].equals("OK")) {
            return Parser.stringToStudent(result[1]);
        } else {
            return null;
        }
    }
}
