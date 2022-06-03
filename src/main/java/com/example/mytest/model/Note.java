package com.example.mytest.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "NOTES")
public class Note {
    @Id
    @Column(name = "NoteID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "FirstName")
    private String firstName;

    @NotNull
    @Column(name = "LastName")
    private String lastName;

    @NotNull
    @Column(name = "Phone")
    private String phone;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
