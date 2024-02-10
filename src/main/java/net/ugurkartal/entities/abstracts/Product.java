package net.ugurkartal.entities.abstracts;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public abstract class Product {
    private String name;
    private int quality;
    private LocalDate expirationDate;
    private double price;

    @Override
    public String toString() {
        return
                "Name:" + name +
                ", Quality:" + quality +
                ", Expiration date:" + expirationDate +
                ", Price:" + price
                ;
    }
}