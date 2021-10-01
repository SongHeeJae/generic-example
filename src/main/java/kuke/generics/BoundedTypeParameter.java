package kuke.generics;

import java.io.Closeable;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class BoundedTypeParameter{
    // <T extends List> : T는 List의 서브 타입만 가능

    // multiple bound. 여러 타입의 제약 조건을 만족시켜야함
    // 클래스 제약은 하나만 가능
    static <T extends List & Serializable & Comparable & Closeable> void print(T t) {}

    static <T extends Comparable<T>> long countGreaterThan(T[] arr, T elem) {
        return Arrays.stream(arr).filter(s -> s.compareTo(elem) > 0).count();
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[] {1,2,3,4,5,6,7};
        String[] arr2 = new String[] {"a", "b", "c", "d", "e"};
        System.out.println(countGreaterThan(arr, 4));
        System.out.println(countGreaterThan(arr2, "c"));
    }
}
