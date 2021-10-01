package kuke.generics;

import java.util.function.Consumer;

public class IntersectionType2 {
    interface DelegateTo<T> {
        T delegate();
    }

    interface Hello extends DelegateTo<String> {
        default void hello() {
            System.out.println("Hello " + delegate());
        }
    }

    interface UpperCase extends DelegateTo<String> {
        default void upperCase() {
            System.out.println(delegate().toUpperCase());
        }
    }

    static <T extends DelegateTo<S>, S> void run(T t, Consumer<T> consumer) {
        consumer.accept(t);
    }

    public static void main(String[] args) {
        // 여기에서는 첫 번째 람다가 의미가 있음
        run((DelegateTo<String> & Hello & UpperCase)() -> "delegate", o->{
            o.hello();
            o.upperCase();
        });
    }
}
