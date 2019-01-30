package org.osama.services;

import org.osama.model.Customer;

import java.util.List;

public interface CustomerService  {
    public List<Customer> getCustomers();
    public void saveCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(int id);
    public Customer findCustomerById(int id);
}
