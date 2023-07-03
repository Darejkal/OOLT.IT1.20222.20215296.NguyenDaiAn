package hust.soict.it1.garbage;

import java.io.InputStream;

public class NoGarbage {
    public static void main(String[] args){
        byte[] buffer = new byte[4096];
        StringBuilder s=new StringBuilder();
        try {
            InputStream file = GarbageCreator.class.getResourceAsStream("file.txt");
            while (file.read(buffer) > 0)
                s.append(buffer);
            file.close();
            System.out.println("Read big file");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Read success!");
    }
}
