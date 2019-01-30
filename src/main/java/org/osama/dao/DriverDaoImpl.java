package org.osama.dao;

import org.hibernate.SessionFactory;
import org.osama.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class DriverDaoImpl implements DriverDao {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public List<Driver> getDrivers() {
        @SuppressWarnings("unchecked")
        TypedQuery<Driver> query = sessionFactory.getCurrentSession().createQuery("from Driver");
        return query.getResultList();
    }

    @Override
    public void saveDriver(Driver driver) {
        sessionFactory.getCurrentSession().save(driver);
    }

    @Override
    public void updateDriver(Driver driver) {
        sessionFactory.getCurrentSession().saveOrUpdate(driver);
    }

    @Override
    public void deleteDriver(int id) {
        Driver driver = sessionFactory.getCurrentSession().get(Driver.class, id);
        sessionFactory.getCurrentSession().delete(driver);
    }

    @Override
    public Driver findDriverById(int id) {
        Driver driver = sessionFactory.getCurrentSession().get(Driver.class, id);
        return driver;
    }

}


