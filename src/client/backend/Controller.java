package client.backend;

/**
 * Created by LU on 15/12/13.
 */
public class Controller {
    private static final String WRONG_MSG = "Wrong response message.";

    public static ServerMessage addStudent(Student student) {
        String content = Parser.studentToString(student);
        content = "ADD\r\n" + content + "\r\nEND\r\n";
        String[] result = ClientTalker.request(content).split("\n");
        if (result.length == 0) {
            return new ServerMessage(false, WRONG_MSG);
        }
        if (result[0].equals("OK")) {
            return new ServerMessage(true);
        } else if (result[0].equals("FAILED")){
            if (result.length > 1) {
                return new ServerMessage(false, result[1]);
            } else {
                return new ServerMessage(false, WRONG_MSG);
            }
        } else {
            return new ServerMessage(false, WRONG_MSG);
        }
    }

    public static ServerMessage deleteStudent(String number) {
        String content = number + "\r\nEND\r\n";
        content = "DELETE\r\n" + "Number:" + content;
        String[] result = ClientTalker.request(content).split("\n");
        if (result.length == 0) {
            return new ServerMessage(false, WRONG_MSG);
        }
        if (result[0].equals("OK")) {
            return new ServerMessage(true);
        } else if (result[0].equals("FAILED")){
            if (result.length > 1) {
                return new ServerMessage(false, result[1]);
            } else {
                return new ServerMessage(false, WRONG_MSG);
            }
        } else {
            return new ServerMessage(false, WRONG_MSG);
        }
    }

    public static ServerMessage getStudentList() {
        String content = "GET_LIST\r\nEND\r\n";
        String[] result = ClientTalker.request(content).split("\n");
        if (result.length == 0) {
            return new ServerMessage(false, WRONG_MSG);
        }
        if (result[0].equals("OK")) {
            if (result.length == 1) {
                return new ServerMessage(true);
            } else {
                return new ServerMessage(true, result[1]);
            }
        } else if (result[0].equals("FAILED")){
            return new ServerMessage(false, result.length > 1?result[1]:"");
        } else {
            return new ServerMessage(false, WRONG_MSG);
        }
    }

    public static ServerMessage getStudentInformation(String number) {
        String content = "GET_INFO\r\n";
        content = content + "Number:" + number + "\r\nEND\r\n";
        String[] result = ClientTalker.request(content).split("\n", 2);
        if (result.length < 2) {
            return new ServerMessage(false, WRONG_MSG);
        }
        if (result[0].equals("OK")) {
            return new ServerMessage(true, result[1]);
        }
        if (result[0].equals("FAILED")) {
            return new ServerMessage(false, result[1]);
        }
        return new ServerMessage(false, WRONG_MSG);
    }
}
