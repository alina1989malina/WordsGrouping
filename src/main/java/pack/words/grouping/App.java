package pack.words.grouping;


public class App {
    public static void main( String[] args ) {
        String s = "сапог сарай арбуз болт бокс биржа";
        System.out.println( new SortedWordGroup(s));
    }
}
