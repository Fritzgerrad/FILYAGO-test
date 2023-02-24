package com.filyago.demo.dto;

import com.filyago.demo.model.Tailor;

import java.util.Date;
import java.util.Random;

public class TailorDTO {
    //private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private char gender;
    private String phone;
    private String activationCode;
    private Date created_at;
    private String password;
    private String nationality;
    private int age;

    public TailorDTO( String firstname, String lastname, String username, int age,char gender, String phone, String nationality) {
        //this.id = id;
        this.nationality = nationality;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.gender = gender;
        this.phone = phone;
        this.created_at = new Date();
        this.activationCode = makeActivationCode(created_at);
        this.password = "123456";
        this.age = age;

    }


//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age= age;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String makeActivationCode(Date date){
        Random random = new Random();
        int code = random.nextInt(10);
        code = code + 159;
        code = ((code+code)*code*code) -code;
        String code_s = Integer.toString(code);
        String thedate = Integer.toString(date.getYear());
        return "FLTA"+thedate+code;
    }

}
