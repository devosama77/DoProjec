package org.osama.dao;

import org.osama.model.Driver;

import java.util.List;

public interface DriverDao  {
   public List<Driver> getDrivers();
   public void saveDriver(Driver driver);
   public void updateDriver(Driver driver);
   public void deleteDriver(int id);
   public Driver findDriverById(int id);
}
