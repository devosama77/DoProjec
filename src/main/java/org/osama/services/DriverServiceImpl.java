package org.osama.services;


import org.osama.dao.DriverDao;
import org.osama.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverSerivce{
    @Autowired
    DriverDao driverDao;

    @Transactional
    public List<Driver> getDrivers() {
        return driverDao.getDrivers();
    }

    @Transactional
    public void saveDriver(Driver driver) {
        driverDao.saveDriver(driver);
    }

    @Transactional
    public void updateDriver(Driver driver) {
     driverDao.updateDriver(driver);
    }

    @Transactional
    public void deleteDriver(int id) {
     driverDao.deleteDriver(id);
    }

    @Transactional
    public Driver findDriverById(int id) {
        Driver driverById = driverDao.findDriverById(id);
        return driverById;
    }
}
