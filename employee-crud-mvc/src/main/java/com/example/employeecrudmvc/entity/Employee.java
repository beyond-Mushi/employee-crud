package com.example.employeecrudmvc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "FirstName cannot be empty.")
    @NotBlank(message = "FirstName cannot be blank.")
    private String firstName;
    @NotEmpty(message = "LastName cannot be empty.")
    @NotBlank(message = "LastName cannot be blank.")
    private String lastName;
    @Email(message = "Invalid Email Format!")
    private String email;
    @Past(message = "Date of Birth must be past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

}
