package Strategys;

import Main.Cases;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Backtracking /*implements Strategy*/{
//    Map<String, Integer> check_points = new HashMap<>();
//    @Override
    public boolean solv(Cases cases, int n, Map<String, Integer> points) {
        if (n < cases.matchesQty) {
            for (int i = 0; i <=2; i++){
                cases.results[n] = i;
                Map<String, Integer> check_points = new HashMap<>(points);
                if (check(cases, n, check_points)) {
                    if (solv(cases, n+1, new HashMap<>(check_points))) {
                        return true;
                    }
                }
            }
            cases.results[n] = -1;
        }
        return isFinish(points);
    }//resuelve pero cuando llega al final intenta con n=9 y por el primer if da false

    private boolean check (Cases cases, int i, Map<String, Integer> check_points){
        String home = cases.matches[i][0];
        String away = cases.matches[i][1];
        switch (cases.results[i]){
            case 1 -> {
                int points = check_points.getOrDefault(home, 0);
                check_points.put(home, points - 3);
                return check_points.get(home) >= 0;
            }
            case 2 -> {
                int points = check_points.getOrDefault(away, 0);
                check_points.put(away, points - 3);
                return check_points.get(away) >= 0;
            }
            case 0 -> {
                int homePoints = check_points.getOrDefault(home, 0);
                check_points.put(home, homePoints - 1);
                int awayPoints = check_points.getOrDefault(away, 0);
                check_points.put(away, awayPoints - 1);
                return check_points.get(home) >= 0 &&
                        check_points.get(away) >= 0;
            }
        }
        return false;
    }

    private boolean isFinish(Map<String, Integer> points){
        Collection<Integer> values = points.values();
        for (Integer value: values){
            if (value != 0)
                return false;
        }
        return true;
    }
}
