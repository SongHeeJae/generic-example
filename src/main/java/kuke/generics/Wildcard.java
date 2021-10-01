package kuke.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Wildcard {
//    List<?> list; // ? : wildcard. 타입을 모른다.
//    List<T> list2; // 이 타입이 정해지면 뭔지 알고 사용하겠다.

    static void printList(List<Object> list) {
        list.forEach(s-> System.out.println("s = " + s));
    }

    static void printList2(List<? extends Comparable> list) {
        list.forEach(s-> System.out.println("s = " + s));
    }

    static class A { }
    static class B extends A {}

    public static void main(String[] args) {
        printList(Arrays.asList(1, 2, 3));
        printList2(Arrays.asList(1, 2, 3));

        List<Integer> list = Arrays.asList(1, 2, 3);
//        printList(list); // compile error
        printList2(list);

        List<B> listB = new ArrayList<>();
//        List<A> la = listB; // compile error
        List<? extends A> la = listB;
        List<? super B> l2 = listB; // B의 수퍼타입이어야 한다.
//        List<? super A> l3 = listB; // compile error
//        la.add(new B()); // compile error
        la.add(null);
        listB.add(new B());
    }



}
