package org.osama.services;

import org.osama.dao.CustomerDao;
import org.osama.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    public CustomerDao customerDao;
    @Transactional
    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }

    @Transactional
    public void saveCustomer( Customer customer) {
        customerDao.saveCustomer(customer);
    }

    @Transactional
    public void updateCustomer(Customer customer) {
       customerDao.updateCustomer(customer);
    }

    @Transactional
    public void deleteCustomer(int id) {
         customerDao.deleteCustomer(id);
    }

    @Transactional
    public Customer findCustomerById(int id) {
        Customer customerById = customerDao.findCustomerById(id);
        return customerById;
    }
}
