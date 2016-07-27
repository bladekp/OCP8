package advancedJavaClassDesign.nestedClasses.staticNestedClasses;

public class Enclosing {

    private static class Nested {

        private int price = 6;
    }

    public static void main(String[] args) {
        Nested nested = new Nested();
        System.out.println(nested.price);
    }
}

/*
 Line 6 instantiates the nested class. Since the class is static , you do not need an
instance of Enclosing in order to use it. You are allowed to access private instance
variables, which is shown on line 7.
*/