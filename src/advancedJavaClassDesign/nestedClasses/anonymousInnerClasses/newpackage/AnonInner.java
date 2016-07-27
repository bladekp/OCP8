package advancedJavaClassDesign.nestedClasses.anonymousInnerClasses.newpackage;

public class AnonInner {

    abstract class SaleTodayOnly {

        abstract int dollarsOff();
    }

    interface SaleTomorrowOnly {

        int dollarsOff();
    }
    
    public int admissionToday(int basePrice) {
        SaleTodayOnly sale = new SaleTodayOnly() {
            @Override
            int dollarsOff() {
                return 3;
            }
        };
        return basePrice - sale.dollarsOff();
    }

    public int admissionTomorrow(int basePrice) {
        SaleTomorrowOnly sale = new SaleTomorrowOnly() {
            @Override
            public int dollarsOff() {
                return 3;
            }
        };                // SaleTomorrowOnly sale2 = () -> 3; //można użyć lambdy
        
        return basePrice - sale.dollarsOff();
    }
}
