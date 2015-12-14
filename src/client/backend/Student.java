package client.backend;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

/**
 * Created by LU on 15/12/13.
 */

public class Student {
    public enum Gender {
        MALE, FEMALE
    }
    public static int ITEMS = 4;

    private String number;
    private String name;
    private String picturePath;
    private Gender gender;

    public Student() {
    }

    public Student(String number, String name, String picPath, Gender gender) {
        this.number = number;
        this.name = name;
        this.picturePath = picPath;
        this.gender = gender;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPicturePath(String path) {
        this.picturePath = path;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public String getPictureCode() {
        BASE64Encoder encoder = new BASE64Encoder();
        try {
            StringBuilder pictureBuffer = new StringBuilder();
            InputStream input = new FileInputStream(new File(picturePath));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] temp = new byte[1024];
            for(int len = input.read(temp); len != -1;len = input.read(temp)){
                out.write(temp, 0, len);
                pictureBuffer.append(encoder.encode(out.toByteArray()));
                out.reset();
            }
            return pictureBuffer.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
