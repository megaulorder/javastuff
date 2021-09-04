import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class JavaCollectionsTest {
    public static HashMap<String, String> hashMap = new HashMap<String, String>();
    public static TreeMap<String, String> treeMap = new TreeMap<String, String>();

    public static ArrayList<String> list = new ArrayList<String>();

    static {
        for (int i = 0; i < 10000; i++) {
            list.add(Integer.toString(i, 16));
        }
    }

    private static final int REPS = 1000;

    public static void main(String[] args) {
        // warmup
        for (int i = 0; i < 1000; i++) {
            putIntoMap(hashMap);
            putIntoMap(treeMap);
        }

        System.out.println("\nput():");
        measureTimeToPopulate(hashMap, "HashMap", REPS);
        measureTimeToPopulate(treeMap, "TreeMap", REPS);

        // warmup
        for (int i = 0; i < 1000; i++) {
            getFromMap(hashMap);
            getFromMap(treeMap);
        }

        System.out.println("\nget():");
        measureTimeToGet(hashMap, "HashMap", REPS);
        measureTimeToGet(treeMap, "TreeMap", REPS);

        // warmup
        for (int i = 0; i < 1000; i++) {
            containedInMap(hashMap);
            containedInMap(treeMap);
        }

        System.out.println("\ncontainsKey():");
        measureTimeToContain(hashMap, "HashMap", REPS);
        measureTimeToContain(treeMap, "TreeMap", REPS);

        System.out.println("\nremove():");
        measureTimeToRemove(hashMap, "HashMap");
        measureTimeToRemove(treeMap, "TreeMap");
    }

    private static void putIntoMap(Map<String, String> map) {
        map.clear();
        for (String s : list) {
            map.put(s, s);
        }
    }

    private static void getFromMap(Map<String, String> map) {
        for (String s : list) {
            map.get(s);
        }
    }

    private static void containedInMap(Map<String, String> map) {
        for (String s : list) {
            map.containsKey(s);
        }
    }

    private static void removeFromMap(Map<String, String> map) {
        for (String s : list) {
            map.remove(s);
        }
    }

    private static void measureTimeToPopulate(Map<String, String> map, String setName, int reps) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < reps; i++) {
            putIntoMap(map);
        }
        long finish = System.currentTimeMillis();
        System.out.println("Time to populate " + (reps * map.size()) + " entries in a "
                + setName + ": " + (finish - start) + " ms");
    }

    private static void measureTimeToGet(Map<String, String> map, String setName, int reps) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < reps; i++) {
            getFromMap(map);
        }
        long finish = System.currentTimeMillis();
        System.out.println("Time to get() " + (reps * map.size()) + " entries in a "
                + setName + ": " + (finish - start) + " ms");
    }

    private static void measureTimeToContain(Map<String, String> map, String setName, int reps) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < reps; i++) {
            containedInMap(map);
        }
        long finish = System.currentTimeMillis();
        System.out.println("Time to containsKey() " + (reps * map.size()) + " entries in a "
                + setName + ": " + (finish - start) + " ms");
    }

    private static void measureTimeToRemove(Map<String, String> map, String setName) {
        long start = System.currentTimeMillis();
        long size = map.size();

        removeFromMap(map);

        long finish = System.currentTimeMillis();
        System.out.println("Time to remove() " + (size) + " entries in a "
                + setName + ": " + (finish - start) + " ms");
    }
}
