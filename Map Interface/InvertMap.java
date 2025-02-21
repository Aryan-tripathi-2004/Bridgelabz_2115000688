import java.util.*;

public class InvertMap {
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> inputMap) {
        Map<V, List<K>> invertedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : inputMap.entrySet()) {
            invertedMap.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }

        return invertedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 1);
        inputMap.put("B", 2);
        inputMap.put("C", 1);

        System.out.println("Inverted Map: " + invertMap(inputMap));
    }
}
