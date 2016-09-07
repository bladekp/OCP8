package localization;
import java.time.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class datetime {
    public static void main(String args[]){
        p(LocalDate.now());
        p(LocalTime.MIDNIGHT);
        p(LocalDateTime.MAX);
        p(ZonedDateTime.now());
        LocalDate date1 = LocalDate.of(2016, Month.MARCH, 22);
        LocalDate date2 = LocalDate.of(2016, 3, 22);
        p(Stream.of(Month.values())
                .map(m -> m.toString())
                .collect(Collectors.joining(", ")));
        
        LocalTime time1 = LocalTime.of(22,23,24,999999);
        
        LocalDateTime dt1 = LocalDateTime.of(date2, time1);
        
        ZoneId zone = ZoneId.of("US/Eastern");
        ZonedDateTime zdt1 = ZonedDateTime.of(dt1, zone);
        p(zdt1);
        
        ZoneId.getAvailableZoneIds().stream()
            .filter(z -> z.contains("Europe"))
            .sorted().forEach(System.out::println);
    }
    
    private static void p(Object o){
        System.out.println(o);
    }
}
