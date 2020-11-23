package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int increment = incrementByOne(0);
        System.out.println(increment);

        //Functional way of writing the method
        //<parameter, return>
        Function<Integer, Integer> incrementByOneFunction = number -> {
                                                                            number++;
                                                                            return number;
                                                                        };

        //I was experimenting with return in there, you can also simply do:
        // Function<Integer, Integer> incrementByOneFunction = number -> number +1;
        //For lambda, think of it like in -> out


        //.apply(<parameter>) is how you use the function
        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multiplyby10.apply(2);
        System.out.println(multiply);
        //A new function is made by chaining two together, using the .andThen() method.
        Function<Integer, Integer> addBy1AndThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyby10);

        //This should also print 20, but its a chain of 2 functions
        System.out.println(addBy1AndThenMultiplyBy10.apply(1));

        //BiFunction - takes 2 arguments and produces 1 result
        System.out.println(incrementByOneAndMultiplyMethod(4, 100));

        System.out.println(incrementByOneAndMultiplyBiFunction.apply(4,100));

    }

    Function<Integer, Integer> incrementByOneFunction = number -> number++;

    static int incrementByOne(int number){
        number++;
        return number;
    }

    static Function<Integer, Integer> multiplyby10 = number -> number * 10;

    //normal way
    static int incrementByOneAndMultiplyMethod(int number, int numToMultiplyBy){
        return (number + 1) * numToMultiplyBy;
    }
    //<parameter1, parameter2, return type>
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy) -> (numberToIncrementByOne + 1) * numberToMultiplyBy;
}
