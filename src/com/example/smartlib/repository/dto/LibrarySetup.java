package com.example.smartlib.repository.dto;

public class LibrarySetup {
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Integer id;
    private String name;
    private Integer capacity;
    private String incharge;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    private String emailId;

    public Integer getNoAvailableDays() {
        return noAvailableDays;
    }

    public void setNoAvailableDays(int noAvailableDays) {
        this.noAvailableDays = noAvailableDays;
    }

    private Integer noAvailableDays;
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public long getOpenTime() {
        return OpenTime;
    }

    public void setOpenTime(long openTime) {
        OpenTime = openTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCloseTime() {
        return CloseTime;
    }

    public void setCloseTime(long closeTime) {
        CloseTime = closeTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIncharge() {
        return incharge;
    }

    public void setIncharge(String incharge) {
        this.incharge = incharge;
    }

    private String address;
    private String phoneNo;
    private long OpenTime;
    private long CloseTime;
}
