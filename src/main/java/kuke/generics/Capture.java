package kuke.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Capture {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 3, 2);
        reverse(list);
        System.out.println("list = " + list);
    }

    // 타입과 관련이 없으므로 wildcard
    // capture : 필요에 따라서 타입이 무엇인지 추론을 해야하는 상황이 필요
    // 강제로 capture 하는 헬퍼 메소드를 만들어서
    // 제너릭으로 변환하는 방법으로 해결하는 방법이 있음
    // T 를 바깥에 노출하면 외부 구현에 대한 오해를 일으킬 수 있기 때문.
    // raw type으로 바꿔서 해결하는 방법도 있음
    static void reverse(List<?> list) {
        reverseHelper(list);
    }

    private static <T> void reverseHelper(List<T> list) {
        List<T> temp = new ArrayList<>(list);
        for(int i=0;i<list.size(); i++) {
            list.set(i, temp.get(list.size() - i - 1));
        }
    }
}
