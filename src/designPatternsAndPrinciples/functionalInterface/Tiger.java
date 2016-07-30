package designPatternsAndPrinciples.functionalInterface;

public class Tiger implements Sprint {

    @Override
    public void sprint() {
        System.out.println("Animal is sprinting fast!");
    }
}

@FunctionalInterface
interface Sprint {

    public void sprint();
}