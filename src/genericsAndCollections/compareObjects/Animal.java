package genericsAndCollections.compareObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Animal implements Comparable<Animal> {
    private int id;
    private String name;
    
    public Animal(int i, String n){
        this.id = i;
        this.name = n;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
    
    
    @Override
    public int compareTo(Animal a){
        return id - a.id;
    }

    public static void main(String args[]){
        Animal a1 = new Animal(1, "zebra");
        Animal a2 = new Animal(2, "bear");
        System.out.println(a1.compareTo(a2));
        System.out.println(a1.compareTo(a1));
        System.out.println(a2.compareTo(a1));
        
        ArrayList<Animal> al = new ArrayList<>();
        al.add(a1);
        al.add(a2);
        Comparator<Animal> byName = (animal1,animal2) -> animal1.name.compareTo(animal2.name);
        
        Collections.sort(al);
        System.out.println(al);
        Collections.sort(al, byName);
        System.out.println(al);
        
        List<String> names = Arrays.asList("Fluffy", "Hoppy");
        Comparator<String> c = Comparator.reverseOrder();
        int index = Collections.binarySearch(names, "Hoppy", c);
        System.out.println(index);
        
        Set<Animal> tsa = new TreeSet<>();
        tsa.add(a2);
        
        Set<Duck> tsd = new TreeSet<>((d1,d2) -> d1.id - d2.id);
        tsd.add(new Duck());
        tsd.add(new Duck());
    }
    
    public static class Duck{
        int id;
    }
}
