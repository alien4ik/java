package com.example.java.Models;


import java.util.Date;

public record Client(Integer clientId,String email, String surname, Date birthday, boolean male) {
}
