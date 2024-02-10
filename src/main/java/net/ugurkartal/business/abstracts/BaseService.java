package net.ugurkartal.business.abstracts;

import net.ugurkartal.entities.abstracts.Product;

import java.util.List;
import java.util.Map;

public interface BaseService {
    int updateQuality(Product product);
    Map<Product, String> getProducts();
    List<Product> getAllProductsWithCurrentStatus();
    String getProductByName(String name);
    void makeOld();
    void updateProductMap();
}
