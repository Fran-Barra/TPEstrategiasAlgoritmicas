package Strategys;

import Main.Cases;

import java.util.HashMap;
import java.util.Map;

public class BruteForce implements Strategy{
    @Override
    public void solv(Cases cases) {
        while (!check(cases))
            add(cases.results, cases.matchesQty-1);
    }

    private void add(int[] results, int i){
        if (results[i] == 2){
            results[i] = 0;
            add(results, i-1);
        }
        else {
            results[i]++;
        }
    }

    private boolean check(Cases cases){
        Map<String, Integer> toCheckPoints = new HashMap<>();
        for (String team: cases.teams)
            toCheckPoints.put(team, 0);

        for (int i = 0; i<cases.matchesQty; i++){
            if (cases.results[i] == 0){
                toCheckPoints.put(cases.matches[i][0], toCheckPoints.get(cases.matches[i][0])+1);
                toCheckPoints.put(cases.matches[i][1], toCheckPoints.get(cases.matches[i][1])+1);
            }
            else if (cases.results[i] == 1){
                toCheckPoints.put(cases.matches[i][0], toCheckPoints.get(cases.matches[i][0])+3);
            }
            else {
                toCheckPoints.put(cases.matches[i][1], toCheckPoints.get(cases.matches[i][1])+3);
            }
        }

        return cases.points.equals(toCheckPoints);
    }

}
