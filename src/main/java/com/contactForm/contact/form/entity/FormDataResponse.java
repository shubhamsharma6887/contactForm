package com.contactForm.contact.form.entity;

public class FormDataResponse {
    private int id ;

    private String firstName ;
    private String lastName ;
    private String businessName ;
    private String businessLocation ;
    private String businessType ;

    private String email;


    private String phone;

    private String query;

    public boolean isResolved() {
        return isResolved;
    }

    public void setResolved(boolean resolved) {
        isResolved = resolved;
    }

    private boolean isResolved;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessLocation() {
        return businessLocation;
    }

    public void setBusinessLocation(String businessLocation) {
        this.businessLocation = businessLocation;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public FormDataResponse(int id, String firstName, String lastName, String businessName, String businessLocation, String businessType, String email, String phone, String query,boolean isResolved) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.businessName = businessName;
        this.businessLocation = businessLocation;
        this.businessType = businessType;
        this.email = email;
        this.phone = phone;
        this.query = query;
        this.isResolved= isResolved;
    }
    public FormDataResponse(){}
}
