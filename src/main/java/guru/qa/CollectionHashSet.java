package guru.qa;

import java.util.HashSet;
import java.util.Set;


public class CollectionHashSet {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Grom");
        set.add("Mol");
        set.add("Drozd");
        set.add("Man");
        set.add("Bol");

        set.add("Mol");
        System.out.println("Elements in set: " + set);

        set.remove("Bol");
        System.out.println("Elements in set: " + set);

        System.out.println("");
        getElements(set);

        System.out.println("");
        addedElement(set, "Volk");
        addedElement(set, "Mol");

        System.out.println("");
        removeElements(set, "Man");
        removeElements(set, "Cax");

    }

    public static void getElements(Set<String> set) {
        for (String value :
                set) {
            System.out.println("The table contains the following values: " + value);
        }
    }

    public static void addedElement (Set<String> set, String value){
        if(!set.contains(value)){
            set.add(value);
            System.out.println("A new value has been added: " + value);
        }else {
            System.out.println("A new value has been added");
        }
    }

    public static void removeElements (Set<String> set, String value){
        if(set.contains(value)){
            set.remove(value);
            System.out.println("Value removed: " + value);
        }else {
            System.out.println("The value was not found");
            System.out.println(set);
        }
    }

}
