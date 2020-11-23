package finalsection;

import java.util.function.Function;

public class Lambdas {
    public static void main(String[] args) {

        //Wrapper classes can be null, primitives cannot
        Integer number = null;
        int counter = 0;

        //Lambdas are (parameter) -> return
        Function<String, String> upperCaseName = name -> name.toUpperCase();

        String uppercasedName = upperCaseName.apply("Alex");

        System.out.println(uppercasedName);
    }

    //When your return statement is more than one line, you need to use {} and the actual
    //return keyword, I experimented with this earlier
    //if you have more than one argument (bifunction, etc) you need to put them in ()
}
