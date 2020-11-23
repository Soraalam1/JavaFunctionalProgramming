package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {

        Customer maria = new Customer("Maria", "9999999");
        //Normal Method
        greetCustomer(maria);

        greetCustomerV2(maria, false);

        //Functional interface way, we use Consumer if its void(?)
        greetCustomerConsumer.accept(maria);

        //BiFunctional interface way, same thing with 2 arguments
        greetCustomerConsumerV2.accept(maria, false);

    }

    //Consumers are basically void Functions. If there's no return, use Consumer.
    //Consumer<parameter>
    static Consumer<Customer> greetCustomerConsumer = customer ->  System.out.println("Hello " + customer.customerName + ", thanks for registering phone number " +
            customer.customerPhoneNumber);

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber)
            ->  System.out.println("Hello " + customer.customerName + ", thanks for registering phone number " +
            //This ? is like an if statement based on the boolean value to the left of it, if true its the first one, if false,
            //the second one
            (showPhoneNumber ? customer.customerPhoneNumber : "*******"));

    static void greetCustomer(Customer customer){
        System.out.println("Hello " + customer.customerName + ", thanks for registering phone number " +
                customer.customerPhoneNumber);
    }

    static void greetCustomerV2(Customer customer, boolean showPhoneNumber){
        if(showPhoneNumber){
            System.out.println("Hello " + customer.customerName + ", thanks for registering phone number " +
                    customer.customerPhoneNumber);
        }
        else{
            System.out.println("Hello " + customer.customerName + ", thanks for registering phone number " +
                    "********");
        }
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
