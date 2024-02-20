package guru.qa;

public class MyProgram {

    public static void main(){
        //Примитивные
        //Целочисленные значения
        byte aByte = 0; //8b  -128 +127
        short aShort = 0; //16 -32768 +32767
        int aInt = 0; //32b -14 mln (-2^32) ... (+2^32 - 1)
        long aLong = 0; //64b  .... (-2^64) ... (+2^64 - 1)

        //Типы с плавающей точкой
        float aFloat = 0.0F;
        double aDouble = 0.0;

        //Символьный
        char aChar = 'a';

        //Логический тип
        boolean aBoolean = true;

        //Объектные/ссылочные типы данных, которых бесконечноть
        String toBePrint = "Hello world!";


        System.out.println(toBePrint);




    }
}
