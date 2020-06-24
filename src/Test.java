import java.io.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {

        java.io.File file = new java.io.File("src/files/courses.txt");
        boolean makeFile = new java.io.File("src/files/" + "tubu"+"/courses.txt").mkdirs();
        if (makeFile) System.out.println("File created");
        else System.out.println("File not created");

        ObjectOutputStream obj = new java.io.ObjectOutputStream(new java.io.FileOutputStream("src/files/courses.txt"));


    }
}
