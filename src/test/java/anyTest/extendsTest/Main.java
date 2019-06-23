package anyTest.extendsTest;

import java.util.HashMap;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-05-17 10:14
 **/
public class Main {

    public static void main(String[] args) {
        Father father = new Father();
        HashMap map = new HashMap();
        father.f(map);

        Son son = new Son();
        son.f(map);
    }

}
