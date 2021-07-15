package control;

import java.io.*;
import java.util.Scanner;

public class FileOperator {
    static File file;
    static Writer writer;

    static String reading(String name ){
        file = new File(name);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        String result="";

        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                result += sc.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        //System.out.println(result);
        return result;

    }

    static void Writing(String SerializedText,String name){

        file = new File(name);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            writer = new FileWriter(file);
            writer.write(SerializedText);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}

