package client;

import client.backend.Controller;
import client.backend.Student;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by LU on 15/12/13.
 */
public class CommandLineMain {
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Add 1");
        for (int i = 1; i <= 20; i++) {
            Controller.addStudent(new Student(i, "Lulu", "/Users/LU/Desktop/SS/pic.jpg", Student.Gender.FEMALE));
        }
        System.out.println("Print List");
        List<Integer> list = Controller.getStudentList();
        if (list != null)
            for (Integer number : list) {
                System.out.println(number);
            }
        System.out.println("Add 2");
        Controller.addStudent(new Student(2, "LuluChao", "/Users/LU/Desktop/SS/pic.jpg", Student.Gender.MALE));
        System.out.println("Print List");
        list = Controller.getStudentList();
        if (list != null) {
            for (Integer number : list) {
                System.out.println(number);
            }
        }
        System.out.println("Print 1");
        Student student  = Controller.getStudentInformation(1);
        System.out.println(student);
        System.out.println("Print 2");
        student = Controller.getStudentInformation(2);
        System.out.println(student);
        System.out.println("Delete 1");
        Controller.deleteStudent(1);
        System.out.println("Print List");
        list = Controller.getStudentList();
        if (list != null) {
            for (Integer number : list) {
                System.out.println(number);
            }
        }
        System.out.println("Print 2");
        student = Controller.getStudentInformation(2);
        System.out.println(student);


//        while (true) {
//            System.out.println("Student Management System");
//            System.out.println("1. Student list");
//            System.out.println("2. Add student");
//            System.out.println("3. Delete student");
//            System.out.println("4. View a student's information");
//
//            String result;
//            Integer choice;
//            try {
//                while ((result = in.readLine()) == null && result.length() == 0) ;
//                choice = Integer.parseInt(result);
//            } catch (Exception e) {
//                System.out.println("Error occurs.");
//                return;
//            }
//            if (choice < 1 || choice > 4) continue;
//            switch (choice) {
//                case 1:
//
//            }
//        }
    }
}
