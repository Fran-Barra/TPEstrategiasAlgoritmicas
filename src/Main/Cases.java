package Main;

import java.util.Map;

public class Cases {
    public Map<String, Integer> points;
    public String[] teams;
    public String[][] matches;
    public int matchesQty;
    public int teamsQty;

    public Cases(Map<String, Integer> points_aux, String[][] matches_aux) {
        points = points_aux;
        teams = points.keySet().toArray(new String[0]);
        matches = matches_aux;
        matchesQty = matches.length;
        teamsQty = teams.length;
    }
}
