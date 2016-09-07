package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Animal implements Serializable{
    
    private String name;
    private int age;
    private char type;    
    private static final long serialVersionUID = 1L;
    
    public Animal(String n, int a, char t){
        this.name = n;
        this.age = a;
        this.type = t;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getType() {
        return type;
    }    
    
    @Override
    public String toString() {
        return "Animal [name=" + name + ", age=" + age + ", type=" + type + "]";
    }
}

class SerializableTest{
    
    public static List<Animal> getAnimals(File data) throws IOException, ClassNotFoundException{
        List<Animal> la = new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(data)))){
            Object an;
            while((an = in.readObject()) != null){ //nigdy nie spełnione
                if (an instanceof Animal) la.add((Animal) an);
                else throw new IOException("Niepoprawny obiekt w pliku.");
            }
        } catch (EOFException eof){}
        return la;
    }
    
    public static void createAnimalsFile(List<Animal> animals, File data) throws IOException{
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(data)))){
            for (Animal a:animals) out.writeObject(a);
        }
    }
    
    public static void main(String args[]) throws Exception{
        List<Animal> la = new ArrayList<>();
        la.add(new Animal("Koń", 22,'S'));
        la.add(new Animal("Piesek", 3,'S'));
        la.add(new Animal("Zółw", 210,'G'));
        File f = new File("zwierzęta");
        createAnimalsFile(la, f);
        List<Animal> lx = getAnimals(f);
        lx.stream().forEach(System.out::println);
    }
    
}
