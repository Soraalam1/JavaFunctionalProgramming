package functionalInterface;

import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println(getDBConnectionUrl());

        //For suppliers, you use the .get() method
        System.out.println(getDBConnectionUrlSupplier.get());
    }

    static String getDBConnectionUrl(){
        return "jdbc://localhost:5432/users";
    }

    //Supplier<return type>
    // the () is lamda for no parameter given
    static Supplier<String> getDBConnectionUrlSupplier = () -> "jdbc://localhost:5432/users";
}
