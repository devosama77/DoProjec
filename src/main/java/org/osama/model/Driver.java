package org.osama.model;

import javax.persistence.*;

@Entity
@Table(name = "driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DRIVER")
    Integer id;
    @Column(name = "DRIVER_NAME")
    String driverName;
    @Column(name = "LORRY_NUMBER")
    String lorryNumber;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLorryNumber() {
        return lorryNumber;
    }

    public void setLorryNumber(String lorryNumber) {
        this.lorryNumber = lorryNumber;
    }
}
