package me.drakespirit.plantry.model;

import java.time.LocalDate;

public record Stock(double quantity, String unit, LocalDate expiryDate) {
}
