package org.osama.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BOOK")
    Integer id;
    @Column(name = "CUSTOMER_NAME")
    String customerName;
    @Column(name = "DRIVER_NAME")
    String driverName;
    @Column(name = "CUSTOMER_ADDRESS")
    String customerAddress;
    @Column(name = "BOOKING")
    String booking;
    @Column(name = "TRIP_DONE")
    String tripDone;
    @Column(name = "TRIP_CANCEL")
    String tripCancel;
    @Column(name = "TRIP_MISSING")
    String tripMissing;
    @Column(name = "REMARK")
    String remark;
    @Column(name = "TYPE_WATER")
    String typeWater;
    @Column(name = "SIZE_TANKER")
    String sizeTanker;
    @Column(name = "NUMBER_TANKER")
    String numberTanker;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    Date date=new Date();

    public String getNumberTanker() {
        return numberTanker;
    }

    public void setNumberTanker(String numberTanker) {
        this.numberTanker = numberTanker;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getSizeTanker() {
        return sizeTanker;
    }

    public void setSizeTanker(String sizeTanker) {
        this.sizeTanker = sizeTanker;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getBooking() {
        return booking;
    }

    public void setBooking(String booking) {
        this.booking = booking;
    }

    public String getTripDone() {
        return tripDone;
    }

    public void setTripDone(String tripDone) {
        this.tripDone = tripDone;
    }

    public String getTripCancel() {
        return tripCancel;
    }

    public void setTripCancel(String tripCancel) {
        this.tripCancel = tripCancel;
    }

    public String getTripMissing() {
        return tripMissing;
    }

    public void setTripMissing(String tripMissing) {
        this.tripMissing = tripMissing;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTypeWater() {
        return typeWater;
    }

    public void setTypeWater(String typeWater) {
        this.typeWater = typeWater;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
