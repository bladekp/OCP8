package functionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.LongUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
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
        
        
        System.out.println(
                Stream.of(1,4,-4,2,-56, 2, 3, 8, 2, 5, 6, 3, 2)
                        .skip(5)
                        .limit(2)
                        .filter(e -> e > 0)
                        .distinct()
                        .map((e) -> e*2.71)
                        .reduce(1.0, (x,y) -> x*y)
        );
                
        Stream.of(
                    Arrays.asList(), 
                    Arrays.asList("X"), 
                    Arrays.asList("A","B","C","D","E","F")
                )
                .flatMap( e -> e.stream())
                .limit(6)
                .skip(0)
                .sorted()
                .forEach(System.out::println);
        
        Stream<String> s = Stream.of("brown bear-", "grizzly-");
            s.peek(System.out::print)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::print); // grizzly-brown bear-
            
        Stream<Integer> infinity = Stream.iterate(1, x -> x+1);
        infinity.limit(5)
                .peek(System.out::print)
                .filter(x -> x % 2 == 1)
                .forEach(System.out::print);
        
        Stream<Integer> integerStream = Stream.of(1,2,3);
        System.out.println(integerStream.mapToInt(x -> x).sum());
        
        IntStream integerStream2 = IntStream.of(1,2,3);
        System.out.println(integerStream2.average().getAsDouble());
        
        IntStream randomInts = new Random().ints(11,15);
        
        randomInts.limit(20).forEach(System.out::println);
        
        DoubleStream ds = DoubleStream.of(1.1, 2);
        
        Stream dsAsObj = ds.mapToObj(sx -> (Double.toHexString(sx)));
        LongUnaryOperator fff;
        Function ffff;
        dsAsObj.forEach(System.out::println);
        
        IntStream xyz = IntStream.of(4,8,11,-9,4);
        System.out.println(xyz.summaryStatistics().getCount());
        
        List<String> ls = new ArrayList<>();
        ls.add("s");
        ls.add("a");
        Stream<String> ss = ls.stream();
        ls.add("x");
        System.out.println(ss.count());
        
        Optional<Integer> xxx = Optional.of(123);
        
        xxx.map(x -> Integer.toString(x))
                .filter(x -> x.length() == 3)
                .ifPresent(System.out::println);
        
        Stream<String> asas = Stream.of("Bear", "Horse", "Monkey");
        
        System.out.println(asas.collect(Collectors.joining(", ")));
    
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        
        System.out.println(ohMy.collect(Collectors.averagingInt(x -> x.length())));
        
        Stream<String> ohMy2 = Stream.of("lions", "tigers", "bears");
        
        Map<Integer, Set<String>> xyz2 = ohMy2.collect(
            Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet())
        );
        
        System.out.println(xyz2);
        
        Stream<String> ohMy3 = Stream.of("lions", "tigers", "bears");
        
        Map<Boolean, List<String>> xyz3 = ohMy3.collect(Collectors
                .partitioningBy(sx -> sx.length() < 6)
        );
        
        System.out.println(xyz3);
    }
}
