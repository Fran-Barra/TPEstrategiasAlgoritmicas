package Main;

import java.util.HashMap;
import java.util.Map;

public class Cases {
    public Cases(Map<String, String> points_aux, int mathches_aux) {
        Map<String, String> points = points_aux;
        String[] teams = points.values().toArray(new String[0]);
        int matches = mathches_aux;
        int teamsQty = teams.length;
    }
}
