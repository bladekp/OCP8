package functionalProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String args[]){
        Stream<String> emptyString = Stream.empty();
        Stream<String> oneString = Stream.of("Ala");
        Stream<String> manyString = Stream.of("Ala", "Ola", "Ela");
        Stream<String> infinityString = Stream.generate(()-> {return String.valueOf(new Random().nextDouble());});
        Stream<String> fromArrayString = Arrays.asList("S","R","T").stream();
        Stream<String> fromArrayStringPar = Arrays.asList("R","S","E").parallelStream();
        Stream<String> iterateString = Stream.iterate("a", a -> a.concat("a"));
        
        //iterateString.forEach(System.out::println);
        
        System.out.println(manyString.count());
        fromArrayString.min(String::compareTo).ifPresent(System.out::println);
        System.out.println(fromArrayStringPar.max(String::compareTo));
        System.out.println(infinityString.findAny());
        System.out.println(iterateString.findFirst());
        
        System.out.println(emptyString.anyMatch(val -> val.contains("kot")));
        System.out.println(oneString.allMatch(s -> s.equals("Ala")));
        
        Stream<Integer> intStream = Arrays.asList(2, 4, 6, 4, 2, 1, 4).stream();
        System.out.println(intStream.reduce(-1, (l,k) -> l*k));
        
        Stream<String> strStr = Stream.of("m","i","s","i","e","k");
        
        System.out.println(strStr.collect(() -> {return new StringBuilder("kaśka + ");}, StringBuilder::append, StringBuilder::append));
    
        Stream<String> strStr2 = Stream.of("m","i","s","i","e","k");
        
        System.out.println(strStr2.collect(Collectors.toCollection(TreeSet::new)));
        
        Stream<String> strStr3 = Stream.of("m","i","s","i","e","k");
        
        System.out.println(strStr3.collect(Collectors.toSet()));
    }
}
