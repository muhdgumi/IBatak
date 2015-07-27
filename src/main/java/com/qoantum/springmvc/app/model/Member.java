package com.qoantum.springmvc.app.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author Muhammad Bello Muhammad (muhdgumi@gmail.com)
 * @since 26/07/2015
 */
@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "USERNAME", unique = true, nullable = false)
    private String username;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    @NotNull
    @Size(min = 15, max = 120)
    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @NotNull
    @Past
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "BIRTH_DATE", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private Date dateOfBirth;

    @NotNull
    @Column(name = "REGISTRATION_DATE", nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private Date registrationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this, object, "firstName", "lastName", "username", "password", "email",
                "address", "dateOfBirth", "registrationDate");
    }


    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this,  "firstName", "lastName", "username", "password", "email",
                "address", "dateOfBirth", "registrationDate");
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
