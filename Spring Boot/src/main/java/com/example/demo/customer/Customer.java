package com.example.demo.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer{

    @JsonProperty("customer_id")
    @Id
    private Long id;

    @NotBlank(message = "name must not be empty")
    private String name;

//    @JsonIgnore
    @JsonProperty(access = WRITE_ONLY)
    @NotBlank(message = "password must not be empty")
    private String password;

    @NotBlank(message = "email must not be empty")
    @Email
    private String email;

}