package org.example.functionalinterfaces;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.behpar.BehParExample;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.IntStream;

public class PredicateTest {
    public static void main(String[] args) {

        int[] array = {5, 4, 8, -3, -4, 10};
        Predicate<Integer> odd = (number) -> number % 2 != 0;
        System.out.println(filter(array, odd));

        Predicate<Integer> even = (number) -> number % 2 == 0;
        System.out.println(filter(array, even));

        Predicate<Integer> negative = (number) -> number < 0;
        System.out.println(filter(array, negative));

        Predicate<Integer> negativeAndEven = negative.and(even);
        System.out.println(filter(array, negativeAndEven));

        Predicate<Integer> negativeOrOdd = negative.or(odd);
        System.out.println(filter(array, negativeOrOdd));
    }

    public static List<Integer> filter(int[] array, Predicate<Integer> predicate) {
        List<Integer> numbers = new ArrayList<>();
        for (int i : array) {
            if (predicate.test(i))
                numbers.add(i);
        }
        return numbers;
    }
}

class ConsumerTest {
    public static void main(String[] args) {
        List<Employee> empList = List.of(
                new Employee("Javohir Elmurodov", "UZB", "SOFTWARE ENGINEER", 28),
                new Employee("John Doe", "US", "MANAGER ", 108),
                new Employee("Akmal Turdiyev", "UZB", "SALES_MANAGER", 29),
                new Employee("John Leg", "GER", "MANAGER", 25),
                new Employee("Akbar Akbarov", "US", "SOFTWARE ENGINEER", 17)
        );

        Consumer<Employee> printOnConsole = e -> System.out.println(e);
        Consumer<Employee> storeInDB = (e -> System.out.println(e.toString() + " saving database"));
        Consumer<Employee> printConsumerThenStoreInDB = printOnConsole.andThen(storeInDB);
        // forEach(empList, printOnConsole);
        // forEach(empList, storeInDB);
        forEach(empList, printConsumerThenStoreInDB);
    }

    static <T> void forEach(List<T> list, Consumer<T> consumer) {
        int nullCount = 0;
        for (T t : list) {
            if (t != null) {
                consumer.accept(t);
            } else {
                nullCount++;
            }
        }
        System.out.printf("%d null entries count  in the list.\n", nullCount);
    }
}

@AllArgsConstructor
@Data
class Employee {
    private String name;
    private String country;
    private String position;
    private int age;
}


class FunctionTest {
    public static void main(String[] args) {
        Function<String, Integer> charsCount = (str) -> str.length();
        Integer helloPdp = charsCount.apply("Hello PDP");
        System.out.println(helloPdp);
    }
}



class PrimitiveFunctionalInterface {

    public static void main(String[] args) {
        int[] arr = IntStream.rangeClosed(1, 10000000).toArray();
        BinaryOperator<Integer> f1 = (a, b) -> Integer.sum(a, b);
        IntBinaryOperator f2 = (a, b) -> Integer.sum(a, b);
        RunningTime.calculate(v -> reduceWrapper(arr, f1));
        RunningTime.calculate(v -> reducePrimitive(arr, f2));
    }

    static int reduceWrapper(int[] arr, BinaryOperator<Integer> operator) {
        Integer result = arr[0];
        for ( int i = 1; i < arr.length; i++ ) {
            result = operator.apply(result, arr[i]);  // Boxing and Unboxing here
        }
        return result;
    }

    static int reducePrimitive(int[] arr, IntBinaryOperator operator) {
        int result = arr[0];
        for ( int i = 1; i < arr.length; i++ ) {
            result = operator.applyAsInt(result, arr[i]);
        }
        return result;
    }
}

class RunningTime {
    public static void calculate(Consumer<Void> consumer) {
        long begin = System.currentTimeMillis();
        consumer.accept(null);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }
}