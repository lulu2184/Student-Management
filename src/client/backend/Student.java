package client.backend;

import org.omg.PortableInterceptor.IORInfoOperations;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
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
    private Gender gender;
    private BufferedImage image;

    public Student() {
    }

    public Student(String number, String name, BufferedImage image, Gender gender) {
        this.number = number;
        this.name = name;
        this.image = image;
        this.gender = gender;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
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

    public BufferedImage getImage() {
        return image;
    }

    public String getImageCode() {
        BASE64Encoder encoder = new BASE64Encoder();
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", out);
            return encoder.encode(out.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

//    public String getPictureCode() {
//        BASE64Encoder encoder = new BASE64Encoder();
//        try {
//            StringBuilder pictureBuffer = new StringBuilder();
//            InputStream input = new FileInputStream(new File(picturePath));
//            ByteArrayOutputStream out = new ByteArrayOutputStream();
//            byte[] temp = new byte[1024];
//            for(int len = input.read(temp); len != -1;len = input.read(temp)){
//                out.write(temp, 0, len);
//                pictureBuffer.append(encoder.encode(out.toByteArray()));
//                out.reset();
//            }
//            return pictureBuffer.toString();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            return null;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}
