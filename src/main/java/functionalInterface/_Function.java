package functionalInterface;

import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int increment = incrementByOne(0);
        System.out.println(increment);

        //Functional way of writing the method
        //<parameter, return>
        Function<Integer, Integer> incrementByOneFunction = number ->
        {number++;
        return number;};

        //I was experimenting with return in there, you can also simply do:
        // Function<Integer, Integer> incrementByOneFunction = number -> number +1;
        //For functional, think of it like in -> out


        //.apply(<parameter>) is how you use the function
        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multiplyby10.apply(2);
        System.out.println(multiply);

        Function<Integer, Integer> addBy1AndThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyby10);

        System.out.println(addBy1AndThenMultiplyBy10.apply(1));
    }

    Function<Integer, Integer> incrementByOneFunction = number -> number++;

    static int incrementByOne(int number){
        number++;
        return number;
    }

    static Function<Integer, Integer> multiplyby10 = number -> number * 10;
}
