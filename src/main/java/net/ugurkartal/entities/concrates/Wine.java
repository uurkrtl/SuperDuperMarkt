package net.ugurkartal.entities.concrates;

import net.ugurkartal.entities.abstracts.Product;

import java.time.LocalDate;

public class Wine extends Product {
    public Wine(String name, int quality, LocalDate expirationDate, double price) {
        super(name, quality, expirationDate, price);
    }

    @Override
    public String toString() {
        return "{ Type:Wine, " + super.toString() + " }";
    }
}