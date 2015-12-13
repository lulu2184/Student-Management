package client.backend;

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

    }
}
