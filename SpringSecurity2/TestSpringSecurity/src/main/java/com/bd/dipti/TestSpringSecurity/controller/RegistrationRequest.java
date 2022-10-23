package com.bd.dipti.TestSpringSecurity.controller;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString


public class RegistrationRequest {
    private  String name;
    private  String username;
    private  String email;
    private  String password;



}
