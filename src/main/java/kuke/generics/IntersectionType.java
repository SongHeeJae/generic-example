package kuke.generics;

import java.io.Serializable;
import java.util.function.Consumer;
import java.util.function.Function;

public class IntersectionType {

    interface Hello extends Function {
        default void hello() {
            System.out.println("Hello");
        }
    }

    interface Hi extends Function{
        default void hi() {
            System.out.println("Hi");
        }
    }

    interface Printer {
        default void print(String str) {
            System.out.println(str);
        }
    }
    
    public static void main(String[] args) {
        // 메소드가 하나도 없는 인터페이스(marker interface)를 추가로 intersection 할 수 있음
        // 조합했을 때의 최종적인 메소드 개수가 총 1개면 됨.
        // 이 세 가지를 다 구현한 익명 클래스를 만들어버림
        // 새로운 타입을 만들어내는 것과 같은 효과
        // default 메소드나 static 메소드는 제외됨.
        hello((Function & Hello & Hi) s -> s);

        // 이렇게 하면, 일일이 정의하지 않아도 타입 추론을 해줌
        // 첫 번째 람다식은, 두 번째 람다식에서 타입을 사용하기 위한 것 외에는 의미 없음
        run((Function & Hello & Hi & Printer) s -> s, o -> {
            o.hello();
            o.hi();
            o.print("lambda");
        });
    }

    private static <T extends Function & Hello & Hi> void hello(T t) {
        t.hello();
        t.hi();
    }

    static <T extends Function> void run(T t, Consumer<T> consumer) {
        consumer.accept(t);
    }
}
