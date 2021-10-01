package kuke.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Wildcard2 {

    static <T> void method1(List<T> list) {

    }
    static void method2(List<?> list) {
//        list.add(null); // wildcard 타입의 원소는 널만 넣을 수 있다
//        list.size(); // 원소와 관련없는 list의 연산만 사용 가능
        Iterator<?> it = list.iterator();
    }


    // 두 개의 isEmpty 는 동일하게 사용 가능
    // 타입 파라미터 T로 정의되어있는 원소에 대해서 관심이 있을 때 제너릭 사용
    // 순수하게 타입 상관 없이 List에 대해서 사용하려면 와일드카드만 사용 가능
    static <T> boolean isEmpty1(List<T> list) {
        return list.size() == 0;
    }

    static boolean isEmpty2 (List<?> list) {
        return list.size() == 0;
    }

    static <T> long frequency1(List<T> list, T elem) {
        return list.stream().filter(s -> s.equals(elem)).count();
    }

    static long frequency2(List<?> list, Object elem) {
        return list.stream().filter(s -> s.equals(elem)).count();
    }

    // 기능적으로 generic과 wildcard가 동일하다면 wildcard로 쓰는게 맞다.
    // T를 쓰면 내부 구현에서 T 타입을 이용한 작업을 하겠다는 의미로 해석되어서 내부 구현이 노출
    // 의도를 바르게 드러내지 못함.
    // <? extends Comparable> 처럼 Comparable의 기능만 사용하겠다면 그대로 wildcard 사용
    // T에 관심있는 경우에 제너릭 메소드 사용

    static <T extends Comparable<T>> T max1(List<T> list) {
        return list.stream().reduce((a, b) -> a.compareTo(b) > 0 ? a : b)
                .get();
    }

    static <T extends Comparable<? super T>> T max2(List<? extends T> list) {
        return list.stream().reduce((a, b) -> a.compareTo(b) > 0 ? a : b)
                .get();
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 3, 2);
        method1(list);
        method2(list); // List<Object>는 안된다.

        System.out.println(isEmpty1(list));
        System.out.println(isEmpty2(list));

        System.out.println(frequency1(list, 3));
        System.out.println(frequency2(list, 3));

        System.out.println(max1(list));
        System.out.println(max2(list));

    }
}
