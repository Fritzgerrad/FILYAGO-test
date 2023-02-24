package com.filyago.demo.model;

import com.filyago.demo.dto.TailorDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tailors")
public class Tailor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private long id;
    private String firstname;
    private String lastname;
    @Column(unique = true, updatable = false, nullable = false)
    private String username;
    @Transient
    private String password;
    private int age;
    @Column(nullable = false)
    private char gender;
    private String nationality;

    //@Column(unique = true, nullable = false)
    //private String email;
    private String activation_code;
    //@Column(length = 11)
    private String phone;
    //@Column(length = 10)
    //private String account_number;
    private Date created_at;

    public Tailor() {

    }

    public Tailor(long id,
                  String firstname,
                  String lastname,
                  int age,
                  char gender,
                  String nationality,
                  String username,
                  //String email,
                  String activation_code,
                  String phone,
                  //String account_number,
                  Date created_at,
                  String password
    ) {
        this.id = id;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.nationality = nationality;
        this.username = username;
        //this.email = email;
        this.activation_code = activation_code;
        this.phone = phone;
        //this.account_number = account_number;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    //public String getUsername() {
        //return username;
    //}

    //public void setUsername(String username) {
       // this.username = username;
    //}

    //public String getEmail() {
      //  return email;
    //}

    //public void setEmail(String email) {
      //  this.email = email;
    // }

    public String getActivation_code() {
        return activation_code;
    }

    public void setActivation_code(String activation_code) {
        this.activation_code = activation_code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //public String getAccount_number() {
        //return account_number;
    //}

   // public void setAccount_number(String account_number) {
        //this.account_number = account_number;
    //}

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setId(long id) {this.id = id;}

    public String getUsername() {return this.username;}

    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public static Tailor CREATE(TailorDTO tailorDTO){
        Tailor tailor = new Tailor();
        tailor.setCreated_at(tailorDTO.getCreated_at());
        tailor.setFirstname(tailorDTO.getFirstname());
        tailor.setLastname(tailorDTO.getLastname());
        tailor.setPassword(tailorDTO.getPassword());
        tailor.setUsername(tailorDTO.getUsername());
        tailor.setPhone(tailorDTO.getPhone());
        tailor.setActivation_code(tailorDTO.getActivationCode());
        tailor.setGender(tailorDTO.getGender());
        tailor.setAge(tailorDTO.getAge());
        tailor.setNationality(tailorDTO.getNationality());

        return tailor;
    }


}
