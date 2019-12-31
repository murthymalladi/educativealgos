package hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by dmalladi on 12/24/2019.
 */
public class PathOfJourney {

    public static String tracePath(Map< String, String > map) {
        Set<String> set = new HashSet<String>();
       for ( Map.Entry<String,String> entry: map.entrySet() ) {
           set.add(entry.getValue());
       }
       String startingPoint = "";
       int count = 0;
       for (Map.Entry<String,String> entry:map.entrySet()) {
           if (!set.contains(entry.getKey())) {
               startingPoint = entry.getKey();
               count++;
           }
       }
       //disconnected graph
       if (count > 1)
           return "";
       String result = "";
       for (int i = 0; i < map.size(); i++) {
            String arrival = map.get(startingPoint);
            result +=startingPoint+"->"+arrival+",";
            startingPoint = arrival;
       }
        return result;
    }

    public static void main(String[] args) {
        HashMap<String,String> hMap = new HashMap<String,String>();

        hMap.put("NewYork","Chicago");
        hMap.put("Boston","Texas");
        hMap.put("Missouri","NewYork");
        hMap.put("Texas","Missouri");

        String actual_output = PathOfJourney.tracePath(hMap);

        System.out.println(actual_output);
    }
}
