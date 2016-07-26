package advancedJavaClassDesign.abstractClasses;

abstract class Animal {
    public void careFor() {
        play();
    }
    public void play() {
        System.out.println("pet animal");
    } 
}
class Lion extends Animal {
    public void play() {
        System.out.println("toss in meat"); 
    } 
}
public class PlayWithAnimal {
    public static void main(String... args) {
        Animal animal = new Lion();
        animal.careFor();
    } 
}

/*
The correct answer is toss in meat . The main method creates a new Lion and calls
careFor . Since only the Animal superclass has a careFor method, it executes. That method
calls play . Java looks for overridden methods, and it sees that Lion implements play .
Even though the call is from the Animal class, Java still looks at subclasses, which is good
because you don’t want to pet a Lion !
*/