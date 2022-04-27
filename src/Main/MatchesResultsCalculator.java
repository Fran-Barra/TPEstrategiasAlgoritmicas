package Main;

import Strategys.Strategy;

import java.util.HashMap;
import java.util.Map;


public class MatchesResultsCalculator {
//    private Cases[] cases;
//    private Strategy[] strategys = new Strategy[3];

//    public MatchesResultsCalculator(Cases[] cases, Strategy[] strategys) {
//        this.cases = cases;
//        this.strategys = strategys;
//    }

    private static Cases[] generateCases(String data){
        String[] stringOfCases = data.split("\n\n");
        Cases[] cases = new Cases[stringOfCases.length - 1];
        for (int j = 0; j < stringOfCases.length - 1; j++) {
            String[] lines = stringOfCases[j].split("\n");
            int teamsQty = Integer.parseInt(lines[0].split(" ")[0]);
            int matchesQty = Integer.parseInt(lines[0].split(" ")[1]);
            Map<String, Integer> points = new HashMap<>();
            for (int i = 1; i <= teamsQty; i++) {
                String[] pointsArray = lines[i].split(" ");
                points.put(pointsArray[0], Integer.parseInt(pointsArray[1]));
            }
            String[][] matches = new String[matchesQty][2];
            for (int i = 0; i < matchesQty; i++){
                matches[i][0] = lines[i + teamsQty + 1].split(" ")[0];
                matches[i][1] = lines[i + teamsQty + 1].split(" ")[1];
            }
            cases[j] = new Cases(points, matches);
        }
    return cases;
    }

    // antes de descomentar, crear las clases de las strategies.
//    private static Strategy selectStrategy(){
//        //criterio de seleccion de la estrategia
//    }

    public static void calculator(String data){
        Cases[] cases = generateCases(data);
//        Strategy strategy = selectStrategy();
        // calcular con strategy.method(cases)
    }

}
