package Service;

import model.Customer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    private Map<String, Customer>mapOfCustomer = new HashMap<String, Customer>();
    private void CustomerService(){};
    static CustomerService obj = null;

    public static CustomerService getInstance(){
        if (obj == null){
            obj = new CustomerService();
        }
        return obj;
    }



    public void addCustomer(String email, String firstName,String lastName){

        Customer thisPerson  = new Customer(firstName,lastName,email);
        this.mapOfCustomer.put(thisPerson.getEmail(),thisPerson);

    }

    public Customer getCustomer(String customerEmail){
        return mapOfCustomer.get(customerEmail);

    }

    public Collection<Customer> getAllCustomers(){
        ArrayList<Customer> allcustomers = new ArrayList<Customer>();
        for (Customer customer: mapOfCustomer.values()){
            allcustomers.add(customer);
        }
        return allcustomers;

    }

}
