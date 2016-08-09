package genericsAndCollections.upperBoundWildcard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.Vector;

public class UpperTest {

    static class Sparrow extends Bird {
    }

    static class Bird {
    }

    public static void main(String[] args) {
        List<? super Object> birds = new ArrayList<Object>();
        birds.add(new Sparrow());   
        birds.add(new Bird());      
        birds.add(new Object());
        
        //List<? extends B> list4 = new ArrayList<A>();
        
        //List<? super B> list5 = new ArrayList<C>();
        
        Collection<String> list = new ArrayList<String>();
        System.out.println(list.add("Sparrow"));
        System.out.println(list.add("Sparrow"));
        
        Collection<String> set = new HashSet<String>();
        System.out.println(set.add("Sparrow"));
        System.out.println(set.add("Sparrow"));
        
        Collection<String> Llist = new LinkedList<String>();
        System.out.println(Llist.add("Sparrow"));
        System.out.println(Llist.add("Sparrow"));
        
        Collection<String> vector = new Vector<String>();
        System.out.println(vector.add("Sparrow"));
        System.out.println(vector.add("Sparrow"));
        
        Collection<String> treeset = new TreeSet<String>();
        System.out.println(vector.add("Sparrow"));
        System.out.println(vector.add("Sparrow"));
        
        Integer i;
    }
}

class A {}
class B extends A { }
class C extends B { }
