package net.ugurkartal.dataaccess.concrates;

import net.ugurkartal.dataaccess.abstracts.ProductRepository;
import net.ugurkartal.entities.abstracts.Product;
import net.ugurkartal.entities.concrates.Cheese;
import net.ugurkartal.entities.concrates.Wine;

import java.time.LocalDate;
import java.util.List;

public class ProductListDal implements ProductRepository {
    List<Product> products;

    public ProductListDal() {
        this.products = List.of(
                new Cheese("Cheddar", 35, LocalDate.of(2024, 3, 11), 2.99),
                new Cheese("Gouda", 38, LocalDate.of(2024, 2, 19), 4.99),
                new Cheese("Brie", 54, LocalDate.of(2024, 2, 13), 3.99),
                new Wine("Chardonnay", 8, LocalDate.of(2024, 2, 1), 30.0),
                new Wine("Merlot", 7, LocalDate.of(2024, 2, 15), 40.0),
                new Wine("Cabernet Sauvignon", 11, LocalDate.of(2023, 12, 29), 62.0)
        );
    }

    @Override
    public List<Product> getProductsByProductType(String productType) {
        return products.stream().filter(p -> p.getClass().getSimpleName().equals(productType)).toList();
    }

    @Override
    public Product getProductByName(String name) {
        return products.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
    }
}
