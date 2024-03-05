package guru.qa;

import java.util.ArrayList;
import java.util.List;

public class CollectionList {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();

        list1.add("Serg");
        list1.add("Gari");
        list1.add("Bobi");
        list1.add("Drag");

        String name = list1.get(2);

        System.out.println("My favorite name: " + name);

        list1.remove(2);
        System.out.println(list1);
        System.out.println("My favorite name: " + list1);


        addedNewValue(list1, "Addi");
        System.out.println("The sheet contains the following values: " + list1);
        addedNewValue(list1, "GarriBagKonstanta");

        System.out.println(" ");

        getElements(list1);

        System.out.println(" ");

        removeElements(list1);

    }

    private static void addedNewValue(List<String> list1, String name) {

        if (name.length() < 10) {
            list1.add(name);
        } else
            System.out.println("The name exceeds the value");
    }

    private static void getElements(List<String> list1) {
        for (String name : list1) {
            System.out.println("Name in list: " + name);
        }
        //с DO WILE можно попробовать сделать метод записи имени, пока длинна не станет больше какого-то значения
    }
    private static void removeElements (List < String > list1){
        for (int i=3; i >0; i--) {
            list1.remove(i);
            System.out.println(list1);
        }
        System.out.println("The list has been cleared");

    }

}
