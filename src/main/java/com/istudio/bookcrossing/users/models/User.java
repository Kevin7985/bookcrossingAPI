package com.istudio.bookcrossing.users.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    public String login;
    public String email;
    public String password;
    public String name;
    public String about;
    public String phone;
    public String avatar;
}
