package com.example.java.Models;

import java.text.DecimalFormat;
import java.util.Date;

public record Order(Integer orderId, Integer clientId, Float price, Date orderTime) {

}
