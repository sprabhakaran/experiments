import java.util.*;
public class Main { 
 
    @FunctionalInterface 
    interface Function3 <A, B, C, R> { 
        public R apply (A a, B b, C c); 
    } 
 
    public static void main(String[] args) { 
        BiFunction<Integer, Integer, Integer> add = Math::addExact; 
        BiFunction<Integer, Integer, Integer> subtract = Math::subtractExact; 
        BiFunction<Integer, Integer, Integer> multiply = Math::multiplyExact; 
 
        Function3<BiFunction<Integer, Integer, Integer>, Integer, Integer, Integer> execute = (callback, x, y) -> callback.apply(x, y); 
 
        System.out.println("Add:      " + execute.apply(add, 3, 4)); 
        System.out.println("Subtract: " + execute.apply(subtract, 3, 4)); 
        System.out.println("Multiply: " + execute.apply(multiply, 3, 4)); 
    } 
}
