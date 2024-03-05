package guru.qa;

import java.util.HashMap;
import java.util.Map;

public class CollectionMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap();

        map.put(0, "Luk");
        map.put(1, "Mor");
        map.put(2, "Kap");
        map.put(3, "Blin");

        String value = map.get(2);
        System.out.println(value);

        map.remove(3);
        System.out.println(map);

        System.out.println("");
        getElements(map);

        System.out.println("");
        addedNewElements(map, "Namad");

        System.out.println("");
        removeElements(map);
    }

    public static void getElements(Map<Integer, String> map){
        for (int i = 0; i < map.size() ; i++) {
            System.out.println(map.get(i));
        }
        System.out.println("There are no more values");
    }

    public static void addedNewElements(Map<Integer, String> map, String value){
        if(!map.containsValue(value)){
            map.put(map.size()+1, value );
            System.out.println(map);
        }
        System.out.println("This value already exists");
    }

    public static void removeElements(Map<Integer, String> map){
        for (int i=3; i >0; i--) {
            map.remove(i);
            System.out.println(map);
        }
        System.out.println("The list has been cleared");
    }
}
