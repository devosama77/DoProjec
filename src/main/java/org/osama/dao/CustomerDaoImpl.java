package org.osama.dao;

import org.hibernate.SessionFactory;
import org.osama.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    @Autowired
    SessionFactory sessionFactory;


    @Transactional
    public List<Customer> getCustomers() {
        @SuppressWarnings("unchecked")
        TypedQuery<Customer> query = sessionFactory.getCurrentSession().createQuery("from Customer");
        return query.getResultList();
    }

    @Override
    public void saveCustomer( Customer customer) {
      sessionFactory.getCurrentSession().save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        sessionFactory.getCurrentSession().saveOrUpdate(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        Customer customer = sessionFactory.getCurrentSession().get(Customer.class, id);
        sessionFactory.getCurrentSession().delete(customer);
    }

    @Override
    public Customer findCustomerById(int id) {
        Customer customer = sessionFactory.getCurrentSession().get(Customer.class, id);
        return customer;
    }
}
