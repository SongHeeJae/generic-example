package kuke.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generics<G> {
    // type parameter - type argument
    static class Hello<T> { // -> type parameter
        T t;
        T method(T value){
            return null;
        }
    }

    public Generics() { }
    public <S> Generics(S s) { }

    <T> void print(T t) { // static 이라면 클래스 레벨의 타입 파라미터는 사용할 수 없음
        System.out.println("t = " + t.toString());
    }

    <S, G> void print2(S t) { // 클래스 레벨의 타입 파라미터 G와 함께 메소드 레벨 사용 가능
    }

    public static void main(String[] args) {
        new Hello<String>(); // -> type argument

        // Raw type : 제너릭 타입이면서 인자 값을 주지 않고 선언부를 생략한 경우
        List list = new ArrayList<>();

        List<Integer> ints = Arrays.asList(1, 2, 3);
        List rawInts = ints;
        List<Integer> ints2 = rawInts; // warnings
        List<String> strs = rawInts; // 컴파일 된다.
//        String str = strs.get(0); // exception

        new Generics().print(1);
        new Generics().print("hello");
    }



}
