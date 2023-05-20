package hust.soict.it1.garbage;

import java.io.FileInputStream;
import java.io.InputStream;

public class GarbageCreator {
    static public void main(String[] args){
        byte[] buffer = new byte[4096];
        String s="";
        try {
            InputStream file = GarbageCreator.class.getResourceAsStream("file.txt");
            while (file.read(buffer) > 0)
                s += new String(buffer);
            file.close();
            System.out.println("Read big file");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Read success!");
    }
}
