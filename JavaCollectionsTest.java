import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class JavaCollectionsTest {
    public static HashMap<String, String> hashMap = new HashMap<>();
    public static TreeMap<String, String> treeMap = new TreeMap<>();

    // TreeMap operations are O(log n)
    // HashMap operations are O (1)
    // HashMap is always faster than TreeMap

    public static ArrayList<String> list = new ArrayList<>(); // list of values for map entries

    static {
        for (int i = 0; i < 10000; i++) {
            list.add(Integer.toString(i, 16));
        }
    }

    private static final int REPETITIONS = 1000;

    public static void main(String[] args) {
        // warmup
        for (int i = 0; i < 1000; i++) {
            putIntoMap(hashMap);
            putIntoMap(treeMap);
        }

        System.out.println("\nput():");
        long timeToPopulateHashMap = timeToPopulateMap(hashMap, "HashMap", REPETITIONS);
        long timeToPopulateTreeMap = timeToPopulateMap(treeMap, "TreeMap", REPETITIONS);
        assert  timeToPopulateTreeMap > timeToPopulateHashMap;

        // warmup
        for (int i = 0; i < 1000; i++) {
            getFromMap(hashMap);
            getFromMap(treeMap);
        }

        System.out.println("\nget():");
        long timeToGetValueFromHashMap = timeToGetValueFromMap(hashMap, "HashMap", REPETITIONS);
        long timeToGetValueFromTreeMap = timeToGetValueFromMap(treeMap, "TreeMap", REPETITIONS);
        assert  timeToGetValueFromTreeMap > timeToGetValueFromHashMap;

        // warmup
        for (int i = 0; i < 1000; i++) {
            containedInMap(hashMap);
            containedInMap(treeMap);
        }

        System.out.println("\ncontainsKey():");
        long timeToCheckIfHashMapContainsKey = timeToCheckIfMapContainsKey(hashMap, "HashMap", REPETITIONS);
        long timeToCheckIfTreeMapContainsKey = timeToCheckIfMapContainsKey(treeMap, "TreeMap", REPETITIONS);
        assert  timeToCheckIfTreeMapContainsKey > timeToCheckIfHashMapContainsKey;

        System.out.println("\nremove():");
        long timeToRemoveKeyFromHashMap = timeToRemoveKeyFromMap(hashMap, "HashMap");
        long timeToRemoveKeyFromTreeMap = timeToRemoveKeyFromMap(treeMap, "TreeMap");
        assert  timeToRemoveKeyFromTreeMap > timeToRemoveKeyFromHashMap;
    }

    //put items into map
    private static void putIntoMap(Map<String, String> map) {
        map.clear();
        for (String s : list) {
            map.put(s, s);
        }
    }

    //get values from map
    private static void getFromMap(Map<String, String> map) {
        for (String s : list) {
            map.get(s);
        }
    }

    //check is map contains key
    private static void containedInMap(Map<String, String> map) {
        for (String s : list) {
            map.containsKey(s);
        }
    }

    //remove keys from map
    private static void removeFromMap(Map<String, String> map) {
        for (String s : list) {
            map.remove(s);
        }
    }

    private static long timeToPopulateMap(Map<String, String> map, String setName, int reps) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < reps; i++) {
            putIntoMap(map);
        }
        long finish = System.currentTimeMillis();
        System.out.println("Time to populate " + (reps * map.size()) + " entries in a "
                + setName + ": " + (finish - start) + " ms");

        return finish - start;
    }

    private static long timeToGetValueFromMap(Map<String, String> map, String setName, int reps) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < reps; i++) {
            getFromMap(map);
        }
        long finish = System.currentTimeMillis();
        System.out.println("Time to get() " + (reps * map.size()) + " entries in a "
                + setName + ": " + (finish - start) + " ms");

        return finish - start;
    }

    private static long timeToCheckIfMapContainsKey(Map<String, String> map, String setName, int reps) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < reps; i++) {
            containedInMap(map);
        }
        long finish = System.currentTimeMillis();
        System.out.println("Time to containsKey() " + (reps * map.size()) + " entries in a "
                + setName + ": " + (finish - start) + " ms");

        return finish - start;
    }

    private static long timeToRemoveKeyFromMap(Map<String, String> map, String setName) {
        long start = System.currentTimeMillis();
        long size = map.size();

        removeFromMap(map);

        long finish = System.currentTimeMillis();
        System.out.println("Time to remove() " + (size) + " entries in a "
                + setName + ": " + (finish - start) + " ms");

        return finish - start;
    }
}
