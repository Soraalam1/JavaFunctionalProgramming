package functionalInterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {

        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("09000000000000"));

        //Use .test() for Predciate(boolean) functions
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("09000000000300"));

        //Chaining, acts like the && with .and(), acts like || with .or()
        System.out.println(isPhoneNumberValidPredicate.or(containsNumber3).test("09000000000300"));
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("07000000300"));


    }

    //Normal Method
    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    //Predicate<Parameter>
    static Predicate<String> isPhoneNumberValidPredicate =
            phoneNumber -> phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");

}
