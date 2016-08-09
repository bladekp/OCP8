package genericsAndCollections.java8additions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Duck {
    private int weight;
    private String name;
    
    public Duck(String n, int w){
        this.weight = w;
        this.name = n;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public static void main(String args[]){
        Comparator<Duck> byWeight = (d1, d2) -> DuckHelper.compareByWeight(d1, d2);
        Comparator<Duck> byWeight2 = DuckHelper::compareByWeight;
        /* 
         * DuckHelper::compareByWeight returns a functional interface and not an
         * int . Remember that :: is like lambdas, and it is typically used for deferred
         * execution.
         */
        
        Consumer<List<Integer>> methodRef1 = Collections::sort;
        Consumer<List<Integer>> lambda1 = l -> Collections.sort(l);
        
        List<Integer> li = new ArrayList<>();
        li.add(2);
        li.add(1);
        li.add(2);
        methodRef1.accept(li);
        System.out.println(li);
        lambda1.accept(li);
        System.out.println(li);
        
        String str = "abc";
        Predicate<String> methodRef2 = str::startsWith;
        Predicate<String> lambda2 = s -> str.startsWith(s);
        
        System.out.println(lambda2.test("b"));
        System.out.println(methodRef2.test("a"));
        
        Predicate<String> methodRef3 = String::isEmpty;
        Predicate<String> lambda3 = s -> s.isEmpty();
        
        System.out.println(methodRef3.test(""));
        
        Supplier<DuckHelper> s = DuckHelper::new;
        Supplier<DuckHelper> s2 = () -> new DuckHelper();
        DuckHelper d = s.get();
        
        li.removeIf((x) -> x==1);
        System.out.println(li);
        
        li.add(4);
        li.add(-5);
        
        li.replaceAll((x) -> -Math.abs(x));
        li.forEach(System.out::print);
        li.forEach((x) -> {System.out.print(","+ x);});
        
        Map<String, String> m = new HashMap<>();
        m.put("ala", "kot");
        m.put("ola", "pies");
        m.put("robert", null);
        
        m.putIfAbsent("robert", "baran");
        m.putIfAbsent("łukasz", "koń");
        
        m.forEach((x,y) -> System.out.println(x + " " + y));
        System.out.println(m);
        
        BiFunction<String, String, String> mapper = (v1,v2) -> v1.length()>v2.length() ? v1 : v2;
        
        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", "Tram");
        favorites.merge("Sam", "Skyride", mapper);
        String jenny = favorites.merge("Jenny", "Skyride", mapper);
        String tom = favorites.merge("Tom", "Skyride", mapper);
        System.out.println(favorites);
        System.out.println(jenny);
        System.out.println(tom);
    }
    
}
