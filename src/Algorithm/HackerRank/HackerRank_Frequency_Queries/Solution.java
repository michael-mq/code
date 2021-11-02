package Algorithm.HackerRank.HackerRank_Frequency_Queries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> databaseMap = new HashMap<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (List<Integer> query : queries) {
            int operation = query.get(0);
            int value = query.get(1);

            switch (operation) {
                case 1:
                    int currentFrequency = databaseMap.getOrDefault(value, 0);
                    int newFrequency = currentFrequency + 1;

                    databaseMap.put(value, newFrequency);

                    frequencyMap.put(newFrequency, frequencyMap.getOrDefault(newFrequency, 0) + 1);

                    if (frequencyMap.containsKey(currentFrequency) && frequencyMap.get(currentFrequency) > 0) {
                        frequencyMap.put(currentFrequency, frequencyMap.get(currentFrequency) - 1);
                    }

                    break;
                case 2:
                    if (databaseMap.containsKey(value) && databaseMap.get(value) > 0) {
                        int _currentFrequency = databaseMap.get(value);
                        int _newFrequency = _currentFrequency - 1;

                        databaseMap.put(value, _newFrequency);

                        frequencyMap.put(_newFrequency, frequencyMap.getOrDefault(_newFrequency, 0) + 1);

                        if (frequencyMap.containsKey(_currentFrequency) && frequencyMap.get(_currentFrequency) > 0) {
                            frequencyMap.put(_currentFrequency, frequencyMap.get(_currentFrequency) - 1);
                        }
                    }

                    break;
                case 3:
                    if (frequencyMap.containsKey(value) && frequencyMap.get(value) > 0) {
                        result.add(1);
                    } else {
                        result.add(0);
                    }
                    break;
            }
        }

        return result;
    }

}
