package Learning;

public class Learn {

    public static void main(String[] args) {
        Integer foo = 10;
        bar(foo);
        System.out.println(foo);
    }
    
    private static void bar(Integer x) {
        x = 20;
    }
}
