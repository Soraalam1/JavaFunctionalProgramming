package combinatorpattern;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "Alice@gmail.com",
                "+0242141515",
                LocalDate.of(2000, 1,1)
        );

//        CustomerValidatorService customerValidatorService = new CustomerValidatorService();
//        System.out.println(customerValidatorService.isValid(customer));

        //if valid we can store customer in db

        //Using combinator pattern
       CustomerRegistrationValidator.ValidationResult result = CustomerRegistrationValidator
                .IsEmailValid()
                .and(CustomerRegistrationValidator.isPhoneNumberValid())
                .and(CustomerRegistrationValidator.isAnAdult())
                .apply(customer);

        System.out.println(result);

        if(result != CustomerRegistrationValidator.ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }
    }
}
