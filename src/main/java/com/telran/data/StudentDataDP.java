package com.telran.data;

public class StudentDataDP {
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String dateOfBirth;
    private String subjects;
    private String address;
    private String state;
    private String city;

    public StudentDataDP setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public StudentDataDP setSubjects(String subjects) {
        this.subjects = subjects;
        return this;
    }

    public StudentDataDP setState(String state) {
        this.state = state;
        return this;
    }

    public StudentDataDP setCity(String city) {
        this.city = city;
        return this;
    }

    public StudentDataDP setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public StudentDataDP setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public StudentDataDP setEmail(String email) {
        this.email = email;
        return this;
    }

    public StudentDataDP setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public StudentDataDP setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAddress() {
        return address;
    }
}
