package net.ugurkartal.entities.concrates;

import lombok.ToString;
import net.ugurkartal.entities.abstracts.Product;

import java.time.LocalDate;

public class Cheese extends Product {
    @Override
    public String toString() {
        return "{ Type:Cheese, " + super.toString() + " }";
    }

    public Cheese(String name, int quality, LocalDate expirationDate, double price) {
        super(name, quality, expirationDate, price);
    }
}
