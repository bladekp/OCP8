package advancedJavaClassDesign.instanceOf;

public class InstanceOfTest {
    public static void main(String[] args){
        HeavyAnimal hippo = new Hippo();
        System.out.println(hippo instanceof Hippo); //true
        System.out.println(hippo instanceof HeavyAnimal); //true
        System.out.println(hippo instanceof Elephant); //false
        System.out.println(hippo instanceof Object); //true
        hippo = null;
        System.out.println(hippo instanceof Object); //false
        System.out.println(null instanceof Object); //false
        Hippo anotherHippo = new Hippo();
        System.out.println(anotherHippo instanceof Elephant); //nie kompiluje ię ponieważ kompilator wie że Hippo nie może wskazywać na Elephanta, dopóki Hippo nie rozszerza Elephanta
        System.out.println(anotherHippo instanceof Mother); //kompiluje się ponieważ kompilator nie jest w stanie stwierdzić w czasie kompilacji czy któraś z podklas nie implementuje interfejsu
    }
}
interface Mother {}
class HeavyAnimal{ }
class Hippo extends HeavyAnimal { }
class Elephant extends HeavyAnimal { }
