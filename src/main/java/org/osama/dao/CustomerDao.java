package org.osama.dao;

import org.osama.model.Customer;

import java.util.List;

public interface CustomerDao {
    public List<Customer> getCustomers();
    public void saveCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(int id);
    public Customer findCustomerById(int id);
}
