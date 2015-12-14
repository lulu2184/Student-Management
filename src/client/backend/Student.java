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

    private Integer number;
    private String name;
    private String picturePath;
    private Gender gender;

    public Student() {

    }

    public void setNumber(Integer number) {
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

    public Integer getNumber() {
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
        String path = "pic/tmp.jpg";
        BASE64Encoder encoder = new BASE64Encoder();
        try {
            StringBuilder pictureBuffer = new StringBuilder();
            InputStream input = new FileInputStream(new File(path));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            File file = new File(path);
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
