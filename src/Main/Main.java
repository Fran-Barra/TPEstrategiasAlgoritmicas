package Main;

public class Main {
    public static void main(String[] args) {
        String a = "adadcafaAAAasdaafa";
        String[] b = a.split("AAA");
        System.out.println(b[0]);
        System.out.println(b[1]);
        String string = "2 1\nBarcelona 1\nMadrid 1\nBarcelona Madrid\n\n4 4\nTigre 4\nRacing 4\nRiver 2\nBoca 0\nTigre Boca\nRacing River\nRiver Tigre\nBoca Racing\n\n-1";
        MatchesResultsCalculator.calculator(string);
    }
}
