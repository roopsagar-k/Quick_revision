import java.util.HashMap;
import java.util.Map;

public class HashMaps {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("china", 120);
        map.put("india", 140);
        map.put("australia", 3);
        map.put("china", 130);

        System.out.println(map);
        if(map.containsKey("china")) {
            System.out.println("china exists in the map with population of " + map.get("china"));
        } else {
            System.out.println("china does not exists in the map");
        }

        for(Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
            
        }
    }
}
