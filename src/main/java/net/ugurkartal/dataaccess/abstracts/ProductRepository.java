package net.ugurkartal.dataaccess.abstracts;

import net.ugurkartal.entities.abstracts.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getProductsByProductType(String productType);
    Product getProductByName(String name);
}
