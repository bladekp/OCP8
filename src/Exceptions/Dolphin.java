package Exceptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Dolphin {
    public static void swim() throws CannotSwimException  {
        throw new CannotSwimException(new RuntimeException("Tragedia."));
    }
    
    public static void main(String args[]){
        /*try {
            swim();
        } catch (CannotSwimException ex) {
            System.out.println(ex.getMessage());
        }
        
        try {
            Path path = Paths.get("xyz.tt");
            String text = new String(Files.readAllBytes(path));
            LocalDate date = LocalDate.parse(text);
            System.out.println(date);
        } catch (DateTimeParseException e){
            e.printStackTrace();
            throw new RuntimeException();
        } catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException();
        }*/
        
        try(Misio m = new Misio();){
            //Piesio p = new Piesio()){ //Piesio nie implementuje AutoCloseable
            System.out.println("Try");
        } catch (Exception e){
            System.out.println("Catch");
        } finally {
            System.out.println("Finnally");
        }
        
        int x = -5;
        assert 1<0:"konik";
        System.out.println(x);
    }
    
    public void tryWithResources(Path p1, Path p2) throws IOException {
        try(BufferedReader in = Files.newBufferedReader(p1);
            BufferedWriter out = Files.newBufferedWriter(p2)){
            out.write(in.readLine());
        }
    }
}

class CannotSwimException extends Exception{ //checked
    
    public CannotSwimException(){}
    
    public CannotSwimException(Exception e){
        super(e);
    }
    
    public CannotSwimException(String message){
        super(message);
    }

}                       
class DangerInTheWaterException extends RuntimeException{}          //unchecked
class SharkInTheWaterException extends DangerInTheWaterException{}  //unchecked

class Misio implements AutoCloseable {

    @Override
    public void close() {
        System.out.println("Closing misio");
    }
    
}

class Piesio{

}