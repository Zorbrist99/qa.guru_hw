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


        int a = 25;
        int b = 104;
        int c;

        c = a + b;
        System.out.println(c);

        short aa = 30000;
        short ad = 2768;
        short ac;

        //Не понятно почему выводится отрицательное значение в консоль
        ac = (short) (aa + ad);
        System.out.println(ac);

        int as = 10;
        int bg = 20;

        System.out.println(as>bg);

        int ah = 10;
        int bh = 20;
        int rt;

        rt= (ah>bh)?50:25;
        System.out.println(rt);

        int ry = 15;
        double ed = 13.2;
        int sc ;

        sc = (int) (ry + ed);

        System.out.println(sc);



        double sk ;

        sk = ry + ed;

        System.out.println(sk);

        System.out.println( );

        System.out.println(ry + ed);

        boolean i;
        boolean v = true;
        boolean p = false;

        i = v&p;
        System.out.println(i);
        System.out.println( );
        i = v||p;
        System.out.println(i);
        System.out.println();
        i = !(v&p);
        System.out.println(i);

    }
}
