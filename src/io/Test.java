package io;

import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.Charset;

public class Test {
 public static void main(String args[]){
     System.out.println(System.getProperty("file.separator"));
     System.out.println(java.io.File.separator);
     
     File file = new File("/home/bladek");
     System.out.println(file.exists());
     
     File file2 = new File("/home/bladekp");
     System.out.println(file2.exists());
     
     File file3 = new File("io");
     System.out.println(file3.exists());
     
     File parent = new File("/home/bladekp");
     File child = new File(parent,"pliczek");
     System.out.println(child.getAbsoluteFile() + " " +
                        child.getName() + " " +
                        child.exists() + " " +
                        child.isDirectory() + " " +
                        child.isFile() + " " +
                        child.length() + " ");
     child.mkdir();
     System.out.println(child.getAbsoluteFile() + " " +
                        child.getName() + " " +
                        child.exists() + " " +
                        child.isDirectory() + " " +
                        child.isFile() + " " +
                        child.length() + " ");
     child.delete();
     
     Charset utf8 = Charset.forName("UTF-8");
     System.out.print(System.getProperty("line.separator"));
     
    // PrintWriter pw = new PrintWriter(null);
 }
}
