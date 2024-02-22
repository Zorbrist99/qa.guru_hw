package guru.qa;

public class Main {

    public static void main(String[] args) {
        //Примитивные типы данных
        //Целочисленные значения
        byte aByte = 0; //8b  -128 +127 (-2^7) ... (+2^7 - 1)
        short aShort = 0; //16 -32768 +32767  (-2^15) ... (+2^15 - 1)
        int aInt = 0; //32b -14 mln (-2^31) ... (+2^31 - 1)
        long aLong = 0; //64b  .... (-2^63) ... (+2^63 - 1)

        //Типы с плавающей точкой
        float aFloat = 0.0F;
        double aDouble = 0.0;

        //Символьный
        char aChar = 'a';

        //Логический тип
        boolean aBoolean = true;

        //Объектные/ссылочные типы данных, которых бесконечноть
        String toBePrint = "Hello world!";


        System.out.println("Hello world!");


    }
}
