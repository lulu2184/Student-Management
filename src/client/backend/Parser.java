package client.backend;

import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
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
                result.setImage(getImage(item[1]));
            } else {
                return null;
            }
        }
        return result;
    }

    public static String studentToString(Student student) {
        return "Number:" + student.getNumber() + "|Name:" + student.getName() + "|Gender:"
                + student.getGender().toString() + "|Picture:" + student.getImageCode();
    }

    public static List<String> stringToStudentList(String str) {
        List<String> studentList = new ArrayList<String>();
        String[] stringList = str.split("\\|");
        for (String number : stringList) {
            studentList.add(number);
        }
        return studentList;
    }

    private static BufferedImage getImage(String pictureCode) {
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] decoderBytes = decoder.decodeBuffer(pictureCode);
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(decoderBytes));
            return image;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
