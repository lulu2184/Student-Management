package client.backend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LU on 15/12/13.
 */
public class Parser {

    public static Student stringToStudent(String str) {
        String[] strings = str.split("\\|", 4);
        if (strings.length != Student.ITEMS) {
            return null;
        }
        Student result = new Student();
        for (String string : strings) {
            String[] item = string.split(":", 2);
            if (item[0].equals("Number")) {
                result.setNumber(Integer.parseInt(item[1]));
            } else if (item[0].equals("Name")) {
                result.setName(item[1]);
            } else if (item[0].equals("Gender")) {
                if (item[1].equals("MALE")) {
                    result.setGender(Student.Gender.MALE);
                } else if (item[1].equals("FEMALE")) {
                    result.setGender(Student.Gender.FEMALE);
                } else {
                    return null;
                }
            } else if (item[0].equals("Picture")) {
                String path = savePicture(item[1]);
                result.setPicturePath(path);
            } else {
                return null;
            }
        }
        return result;
    }

    public static String studentToString(Student student) {
        return "Number:" + student.getName() + "|Name:" + student.getName() + "|Gender:"
                + student.getGender().toString() + "|Picture:" + student.getPictureCode();
    }

    public static List<Integer> stringToStudentList(String str) {
        List<Integer> studentList = new ArrayList<Integer>();
        String[] stringList = str.split("\\|");
        for (String number : stringList) {
            studentList.add(Integer.parseInt(number));
        }
        return studentList;
    }

    private static String savePicture(String pictureCode) {
        String path = "pic/tmp.jpg";

    }
}
