package com.niranjan.register;

public class Usermodel {
    String name, email, password, classname,rollnumber,gender,fathername,mothername,address,dob,mobilenumber,totalfee,totaldues,result;

    public Usermodel() {
    }

    public Usermodel(String name, String email, String password, String classname, String rollnumber, String gender, String fathername, String mothername, String address, String dob, String mobilenumber, String totalfee, String totaldues, String result) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.classname = classname;
        this.rollnumber = rollnumber;
        this.gender = gender;
        this.fathername = fathername;
        this.mothername = mothername;
        this.address = address;
        this.dob = dob;
        this.mobilenumber = mobilenumber;
        this.totalfee = totalfee;
        this.totaldues = totaldues;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getRollnumber() {
        return rollnumber;
    }

    public void setRollnumber(String rollnumber) {
        this.rollnumber = rollnumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getMothername() {
        return mothername;
    }

    public void setMothername(String mothername) {
        this.mothername = mothername;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getTotalfee() {
        return totalfee;
    }

    public void setTotalfee(String totalfee) {
        this.totalfee = totalfee;
    }

    public String getTotaldues() {
        return totaldues;
    }

    public void setTotaldues(String totaldues) {
        this.totaldues = totaldues;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
