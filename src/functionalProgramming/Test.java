package functionalProgramming;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Test {
    public static void main(String args[]){
        Supplier<LocalDate> s1 = LocalDate::now;
        Supplier<LocalDate> s2 = () -> LocalDate.now();
        
        LocalDate d1 = s1.get();
        LocalDate d2 = s2.get();
        
        System.out.println(d1);
        System.out.println(d2);
        
        Supplier<StringBuilder> sb1 = StringBuilder::new;
        Supplier<StringBuilder> sb2 = () -> new StringBuilder();
        
        System.out.println(sb1.get());
        System.out.println(sb2.get());
        
        Supplier<ArrayList<String>> als1 = ArrayList<String>::new;
        ArrayList<String> a1 = als1.get();
        System.out.println(a1);
        System.out.println(als1);
        
        Consumer<Object> cs = System.out::println;
        Consumer<String> cs2 = (string) -> System.out.println(string);
        cs.accept("ala");
        
        Map<String, Integer> map = new HashMap<>();
        BiConsumer<String, Integer> bc1 = map::put;
        BiConsumer<String, Integer> bc2 = (s, i) -> map.put(s,i);
        
        bc1.accept("sss", 121);
        bc2.accept("xxx", 444);
        
        cs.accept(map);
        
        BiConsumer<Map, String> bcm = (m, s) -> m.put(s, 1);
        bcm.accept(map, "ala");
        
        cs.accept(map);
        
        BiPredicate<String, String> startsWith = String::startsWith;
        cs.accept(startsWith.test("Ala","Alx"));
        
        BiFunction<String,String,String> concat = String::concat;
        cs.accept(concat.apply("ala ", "kot"));
        
        UnaryOperator<String> uo = String::toLowerCase;
        cs.accept(uo.apply("kotEK"));
    }
}
