package Strategys;

import Main.Cases;

import java.util.Map;

public class DismissLosers{
    public void solv(Cases cases) {
        for (Map.Entry<String, Integer> entry: cases.points.entrySet()){
            if (entry.getValue() == 0){
                for (int i = 0; i< cases.matchesQty; i++){
                    if (cases.matches[i][0].equals(entry.getKey())){
                        cases.results[i] = 2;
                    }
                    else if (cases.matches[i][1].equals(entry.getKey())){
                        cases.results[i] = 1;
                    }
                }
            }
        }
    }
}
