package designPatternsAndPrinciples.polymorphism;

class Primate {
    
    private int omg = 101;

    public int getOmg(){
        return omg;
    }
    
    public boolean hasHair() {
        return true;
    }
}

interface HasTail {

    public boolean isTailStriped();
}

public class Lemur extends Primate implements HasTail {

    public int age = 10;

    public boolean isTailStriped() {
        return false;
    }

    public static void main(String[] args) {
        Lemur lemur = new Lemur();
        System.out.println(lemur.getOmg());
        System.out.println(lemur.hasHair());
        System.out.println(lemur.isTailStriped());

        HasTail hasTail = lemur;
        //System.out.println(hasTail.age);        //nie kompiluje się bo interfejs HasTail (ani jemu nadrzędny) nie ma pola age
        //System.out.println(hasTail.hasHair());  //nie kompiluje się bo interfejs HasTail (ani jemu nadrzędny) nie ma metody hasHair
        System.out.println(hasTail.isTailStriped());

        Primate primate = lemur;
        //System.out.println(primate.age);        //nie kompiluje się bo klasa Primate (ani jej nadrzędna) nie ma pola age
        System.out.println(primate.hasHair());
        //System.out.println(primate.isTailStriped()); //nie kompiluje się bo klasa Primate (ani jej nadrzędna) nie ma metody isTailStriped
    
        //rzutowanie
        Lemur lemur3 = (Lemur)primate;
        System.out.println(lemur3.age);
    }
}
