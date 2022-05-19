package Strategys;

import Main.Cases;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BackTrackingF implements Strategy{
    @Override
    public void solv(Cases cases) {
        for (int i = 0; i< cases.matchesQty; i++){
            cases.results[i] = -1;
        }
        solution(cases);
    }

    private boolean solution(Cases cases){
        for (int i = 0; i< cases.matchesQty; i++) {
            if (cases.results[i] == -1) {
                for (int k = 0; k < 3; k++) {
                    if (posible(cases, i, k)) {
                        cases.results[i] = k;
                        if (solution(cases))
                            return true;
                        cases.results[i] = -1;
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean posible(Cases cases, int i, int k) {
        Map<String, Integer> toCheckPoints = new HashMap<>();
        for (String team : cases.teams)
            toCheckPoints.put(team, 0);

        for (int j = 0; j < cases.matchesQty; j++) {
            if (j == i) {
                if (k == 0) {
                    toCheckPoints.put(cases.matches[j][0], toCheckPoints.get(cases.matches[j][0]) + 1);
                    toCheckPoints.put(cases.matches[j][1], toCheckPoints.get(cases.matches[j][1]) + 1);
                } else if (k == 1) {
                    toCheckPoints.put(cases.matches[j][0], toCheckPoints.get(cases.matches[j][0]) + 3);
                } else if (k == 2){
                    toCheckPoints.put(cases.matches[j][1], toCheckPoints.get(cases.matches[j][1]) + 3);
                }

            } else {
                if (cases.results[j] == 0) {
                    toCheckPoints.put(cases.matches[j][0], toCheckPoints.get(cases.matches[j][0]) + 1);
                    toCheckPoints.put(cases.matches[j][1], toCheckPoints.get(cases.matches[j][1]) + 1);
                } else if (cases.results[j] == 1) {
                    toCheckPoints.put(cases.matches[j][0], toCheckPoints.get(cases.matches[j][0]) + 3);
                } else if (cases.results[j] == 2){
                    toCheckPoints.put(cases.matches[j][1], toCheckPoints.get(cases.matches[j][1]) + 3);
                }
            }

        }
        for (String team : cases.teams){
            if (i == cases.matchesQty - 1) {
                if (!Objects.equals(toCheckPoints.get(team), cases.points.get(team)))
                    return false;
            }else{
                if (toCheckPoints.get(team) > cases.points.get(team))
                    return false;
            }
        }
        return true;
    }



}
