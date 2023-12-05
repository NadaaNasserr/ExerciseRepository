package com.example.exerciserepository.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(225) not null")
    @Size(min = 4 , message = "name length more than 4 ")
    @NotEmpty(message = "name must be not empty")
    private String name;




    @Column(columnDefinition = "varchar(225) not null unique")
    @Size(min = 4 , message = "name length more than 4 ")
    @NotEmpty(message = "username must be not empty")
    private String username;

    @Pattern(regexp =  "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$" , message = "password must contain at least one number and one uppercase, lowercase letter and special character, and at least 8 or more characters")
    @NotEmpty(message = "password must be not empty")
    private String password;


    @Column(columnDefinition = "varchar(225) not null unique")
    @NotEmpty(message = "email must be not empty")
    @Email(message = "must be valid email")
    private String email;

    @Column(columnDefinition = "varchar(20) check(role='admin' or role='user') ")
    @Pattern(regexp = "^(user|admin)$" , message = "role must be user or admin only")
    @NotEmpty(message = "role must be not empty")
    private String role;


    @NotNull(message = "age must be not null")
    @Positive(message = "age must be integer")
    @Column(columnDefinition = "int not null")
    private Integer age;


}
