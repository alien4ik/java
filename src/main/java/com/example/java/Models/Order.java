package com.example.java.Models;

import java.util.Date;

public record Order(int OrderId, int ClientId, float price, Date OrderTime) {

}
