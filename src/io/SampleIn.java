package io;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.in;
import static java.lang.System.out;

public class SampleIn {
    
    public static void main(String args[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(in));
        String s = input.readLine();
        out.println(s);
        Console c = System.console();
        if (c != null){
            char[] pass = c.readPassword();
            for(char cr:pass){
                out.print(cr);
            }
        }
    }

}
