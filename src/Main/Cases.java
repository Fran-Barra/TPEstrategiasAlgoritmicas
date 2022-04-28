package Main;

import java.util.Map;

public class Cases {
    Map<String, Integer> points;
    String[] teams;
    String[][] matches;
    int matchesQty;
    int teamsQty;

    public Cases(Map<String, Integer> points_aux, String[][] matches_aux) {
        points = points_aux;
        teams = points.keySet().toArray(new String[0]);
        matches = matches_aux;
        matchesQty = matches.length;
        teamsQty = teams.length;
    }
}
