package client.backend;

import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
                result.setNumber(item[1]);
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
        return "Number:" + student.getNumber() + "|Name:" + student.getName() + "|Gender:"
                + student.getGender().toString() + "|Picture:" + student.getPictureCode();
    }

    public static List<String> stringToStudentList(String str) {
        List<String> studentList = new ArrayList<String>();
        String[] stringList = str.split("\\|");
        for (String number : stringList) {
            studentList.add(number);
        }
        return studentList;
    }

    private static String savePicture(String pictureCode) {
        String path = "/Users/LU/Desktop/SS/tmp/tmp.jpg";
        File file = new File(path);
        try {
            file.createNewFile();
            BASE64Decoder decoder = new BASE64Decoder();
            FileOutputStream writer = new FileOutputStream(file);
            byte[] decoderBytes = decoder.decodeBuffer(pictureCode);
            writer.write(decoderBytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return path;
    }
}
