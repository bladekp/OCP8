package advancedJavaClassDesign.enums;

public enum Season {

    WINTER("low") {
        public void printHours() { System. out .println("9am-3pm"); }
        public void isThereSnow(){ System. out .println("Yes it is."); }
    },
    SPRING("medium") {
        public void printHours() { System. out .println("9am-5pm"); }
    }, 
    SUMMER("high") {
        public void printHours() { System. out .println("9am-7pm"); }
    }, 
    FALL("medium") {
        public void printHours() { System. out .println("9am-5pm"); }
    };
    
    private String expectedVisitors;
    
    private Season(String expectedVisitors) {
        this.expectedVisitors = expectedVisitors;
    }
    
    public abstract void printHours();
    
    public void isThereSnow(){
        System.out.println("There isn't snow.");
    }
    
    public void printExpectedVisitors() {
        System.out.println(expectedVisitors);
    }
    
    public static void main(String[] args){
        Season s = Season.FALL;
        s.printExpectedVisitors();  //medium
        s.printHours();             //9am-5pm
        s.isThereSnow();            //There isn't snow.
    }

}
