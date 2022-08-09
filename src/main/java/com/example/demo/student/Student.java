package com.example.demo.student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long Id;
    private String FirstName;
    private String LastName;
    private LocalDate DateOfBirth;

    @Transient
    private Integer Age;

    public  Student(){
    }
    public  Student(Long Id,
                    String FirstName,
                    String LastName,
                    LocalDate DateOfBirth){
        this.Id =Id;
        this.FirstName =FirstName;
        this.LastName = LastName;
        this.DateOfBirth = DateOfBirth;
    }
    public  Student(String FirstName,
                    String LastName,
                    LocalDate DateOfBirth){
        this.FirstName =FirstName;
        this.LastName = LastName;
        this.DateOfBirth = DateOfBirth;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return Period.between(this.DateOfBirth,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        Age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", DateOfBirth=" + DateOfBirth +
                ", Age=" + Age +
                '}';
    }
}
