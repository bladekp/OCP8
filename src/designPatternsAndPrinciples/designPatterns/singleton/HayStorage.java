package designPatternsAndPrinciples.designPatterns.singleton;

public class HayStorage {
    
    // lazy loading with Double‐Checked Locking
    /*private static volatile HayStorage instance;
    public static HayStorage getInstance() {
        if (instance == null) {
            synchronized (HayStorage.class) {
                if (instance == null) {
                    instance = new HayStorage();
                }
            }
        }
        return instance;
    }*/

    static {
        instance = new HayStorage();
        // Perform additional steps
    }

    private int quantity = 0;

    private HayStorage() {
    }

    private static final HayStorage instance;

    public static HayStorage getInstance() {
        return instance;
    }

    public synchronized void addHay(int amount) {
        quantity += amount;
    }

    public synchronized boolean removeHay(int amount) {
        if (quantity < amount) {
            return false;
        }
        quantity -= amount;
        return true;
    }

    public synchronized int getHayQuantity() {
        return quantity;
    }
}

/*
 By marking the constructors private, we have implicitly marked the class final. Recall
 that every class requires at least one constructor, with the default no‐argument constructor
 being added if none are provided. Furthermore, the first line of any constructor is a call to
 a parent constructor with the super() command. If all of the constructors are declared
 private in the singleton class, then it is impossible to create a subclass with a valid
 constructor; therefore, the singleton class is effectively final.
 */
