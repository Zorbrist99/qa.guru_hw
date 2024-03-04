package guru.qa;

import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        //Примитивные типы данных
//        //Целочисленные значения
//        byte aByte = 0; //8b  -128 +127 (-2^7) ... (+2^7 - 1)
//        short aShort = 0; //16 -32768 +32767  (-2^15) ... (+2^15 - 1)
//        int aInt = 0; //32b -14 mln (-2^31) ... (+2^31 - 1)
//        long aLong = 0; //64b  .... (-2^63) ... (+2^63 - 1)
//
//        //Типы с плавающей точкой
//        float aFloat = 0.0F;
//        double aDouble = 0.0;
//
//        //Символьный
//        char aChar = 'a';
//
//        //Логический тип
//        boolean aBoolean = true;
//
//        //Объектные/ссылочные типы данных, которых бесконечноть
//        String toBePrint = "Hello world!";
//
//
//        System.out.println("Hello world!");
//
//
//        int a = 25;
//        int b = 104;
//        int c;
//
//        c = a + b;
//        System.out.println(c);
//
//        short aa = 30000;
//        short ad = 2768;
//        short ac;
//
//        //Не понятно почему выводится отрицательное значение в консоль
//        ac = (short) (aa + ad);
//        System.out.println(ac);
//
//        int as = 10;
//        int bg = 20;
//
//        System.out.println(as>bg);
//
//        int ah = 10;
//        int bh = 20;
//        int rt;
//
//        rt= (ah>bh)?50:25;
//        System.out.println(rt);
//
//        int ry = 15;
//        double ed = 13.2;
//        int sc ;
//
//        sc = (int) (ry + ed);
//
//        System.out.println(sc);
//
//
//
//        double sk ;
//
//        sk = ry + ed;
//
//        System.out.println(sk);
//
//        System.out.println( );
//
//        System.out.println(ry + ed);
//
//        boolean i;
//        boolean v = true;
//        boolean p = false;
//
//        i = v&p;
//        System.out.println(i);
//        System.out.println( );
//        i = v||p;
//        System.out.println(i);
//        System.out.println();
//        i = !(v&p);
//        System.out.println(i);
//
//        System.out.println(" ");
//
//        String name [] = new String[] {"Galla", "Sveta", "Petya"};
//
//        for (String bodyName : name){
//            System.out.println(bodyName);
//        }

//// Создание очереди
//        Queue<String> queue = new LinkedList<>();
//
//// Добавление элементов в очередь
//        queue.add("apple");
//        queue.add("banana");
//        queue.add("orange");
//// Печатаем очередь
//        System.out.println("Queue: " + queue);
//// Удаляем элемент из очереди
//        String element = queue.remove();
//        System.out.println("Removed element: " + element);
//// Печатаем обновленную очередь
//        System.out.println("Queue: " + queue);
//
//        System.out.println(" ");
//
//
//// Создаем Map
//        Map<String, Integer> map = new HashMap<>();
//// Добавляем элементы в Map
//        map.put("apple", 1);
//        map.put("banana", 2);
//        map.put("orange", 3);
//// Печать Map
//        System.out.println("Map: " + map);
//// Получаем значение для определенного ключа
//        int  value  = map.get( "banana" );
//        System.out.println("Value for 'banana': " + value);
//// Удаляем элемент из Map
//        map.remove("orange");
//// Печать обновленной карты
//        System.out.println( "Map: " + map);
//
//        System.out.println(" ");
//
//         Создаем array list
//        List<String> list = new ArrayList<>();
//// Добавляем элементы в array list
//        list.add("qa");
//        list.add("devops");
//        list.add("dev");
//// Печатаем array list
//        System.out.println("Array list: " + list);
//        list.add(0, "java");
//// Доступ к элементу по определенному индексу
//        String element1 = list.get(0);
//        System.out.println("Element at index 0: " + element1);
//// Удаление элемента из the array list
//        list.remove(0);
//// Print the updated array list
//        System.out.println("Array list: " + list);

//        // Создаем linked list
//        List<String> list1 = new LinkedList<>();
//// Добавляем элементы в linked list
//        list.add("selenium");
//        list.add("cypress");
//        list.add("playwright");
//// Печатаем linked list
//        System.out.println("Linked list: " + list1);
//// Добавляем элемент в начало списка
//        list.add(0, "webdriver.io");
//// Печатаем обновленный linked list
//        System.out.println("Linked list: " + list1);
//// Удаляем первый элемент в списке
//        list.remove(0);
//// Еще раз печатаем обновленный linked list
//        System.out.println("Linked list: " + list1);

        // Создаем hash set
//        Set<String> set = new HashSet<>();
//
//// Добавляем элементы в hash set
//        set.add("rose");
//        set.add("lily");
//        set.add("lotus");
//// Попытка добавить повторяющийся элемент
//        set.add("rose");
//// Печатаем hash set
//        System.out.println("Hash set: " + set);
//// Удаляем элемент из hash set
//        set.remove("lily");
//// Печать обновленного hash set
//        System.out.println("Hash set: " + set);

        // Создаем tree set
//        Set<String> set = new TreeSet<>();
//
//// Добавляем элементы в tree set
//        set.add("apple");
//        set.add("banana");
//        set.add("orange");
//// Попытка добавить повторяющийся элемент
//        set.add("apple");
//// Печатаем tree set
//        System.out.println("Tree set: " + set);
//// Удаляем элемент из tree set
//        set.remove("banana");
//// Печатаем обновленный tree set
//        System.out.println("Tree set: " + set);

        // Создаем hash map
        Map<String, Integer> map = new HashMap<>();

// Добавляем элементы в hash map
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("orange", 3);
// Печатаем hash map
        System.out.println("Hash map: " + map);
// Получаем значение для определенного ключа
        int value = map.get("banana");
        System.out.println("Value for 'banana': " + value);
// Удаляем элемент из hash map
        map.remove("orange");
// Печатаем обновленный hash map
        System.out.println("Hash map: " + map);
    }
//    public class Cat {
//
//        public String name;
//        public int age;
//        public int weight;
//
//        public Cat(String name, int age, int weight) {
//            this.name = name;
//            this.age = age;
//            this.weight = weight;
//        }
//
//        public Cat() {
//        }
//
//        public void sayMeow() {
//            System.out.println("Мяу!");
//        }
//    }
//
//    public class Cat1 {
//
//        public static void main(String[] args) {
//
//            Cat cat = new Cat();
//            cat.name = "";
//            cat.age = -1000;
//            cat.weight = 0;

//        }
    }

