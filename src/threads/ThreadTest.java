package threads;

import java.util.Arrays;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThreadTest {
    
   
    
    public static void main(String args[]) throws InterruptedException, ExecutionException, TimeoutException{
        /*System.out.println(Thread.MAX_PRIORITY);
        System.out.println(Thread.NORM_PRIORITY);
        System.out.println(Thread.MIN_PRIORITY);
        
        Thread t = new Thread(() -> {
            for (int i=0;i<500;i++) ++liczba;
        });
        t.setPriority(1);
        t.start();
        
        while (liczba<500){
            System.out.println("Jestem misiem");
            Thread.sleep(1000);
        }
        
        ExecutorService service = null;
        try{
            service = Executors.newSingleThreadExecutor();
            System.out.println("Begin");
            service.execute(() -> System.out.println("Task 1"));
            
            service.execute(() -> {for (int i=1; i<10; i++) System.out.println("Kocham pysię  x" + i  );});
            service.execute(() -> System.out.println("Task 1"));
            
            System.out.println("End");
        } finally {
            if (service != null) service.shutdown();
        }
        
        ExecutorService service2 = null;
        try{
            service2 = Executors.newSingleThreadExecutor();
            Future<Integer> res = service2.submit(() -> {return 22;});
            System.out.println(res.get(1000, TimeUnit.MILLISECONDS));
            System.out.println("finish");
        } finally {
            if (service2 != null) service2.shutdown();
        }*/
        
        /*ScheduledExecutorService service = null;
        try{
            service = Executors.newSingleThreadScheduledExecutor(); 
            service.scheduleAtFixedRate(() -> {System.out.println("x");}, 1, 5, TimeUnit.SECONDS);
            
        } finally {
            if (service != null) service.shutdown();
        }*/
        ExecutorService service = null;
        try{
            service = Executors.newFixedThreadPool(20);
            
            for (int i =0; i<20;i++){
                synchronized(service){
                    service.submit(() -> incrementAndReport());
                }
            }
        } finally {
            if (service != null) service.shutdown();
        }
        
        Arrays.asList(1,2,3,4,5,6)
                .parallelStream()
                .forEach(System.out::println);
        
         Arrays.asList(1,2,3,4,5,6)
                .parallelStream()
                .forEachOrdered(System.out::println);
         
         System.out.println("\n" +Arrays.asList(1,2,3,4,7,5,3,2)
                 .parallelStream()
                 .reduce(2, (x,y) -> x+y));
         
          System.out.println("\n" +Arrays.asList("w","o","l","f")
                 .parallelStream()
                 .reduce("X",String::concat));
          
          Stream<String> stream = Stream.of("w","o","l","f").parallel();
          SortedSet<String> set = stream.collect(ConcurrentSkipListSet::new, Set::add, Set::addAll);
          System.out.println(set);
          
          Stream<String> stream2 = Stream.of("w","o","l","f").parallel();
          Set<String> set2 = stream2.collect(Collectors.toSet());
          System.out.println(set);
    }
    
    public static int liczba = 0;
    private static AtomicInteger sheepCount = new AtomicInteger(0);
    private static void incrementAndReport(){
        System.out.println((sheepCount.incrementAndGet()) + "");
    }
}
