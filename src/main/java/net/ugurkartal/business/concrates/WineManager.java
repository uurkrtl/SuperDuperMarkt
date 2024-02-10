package net.ugurkartal.business.concrates;

import lombok.Data;
import net.ugurkartal.business.abstracts.WineService;
import net.ugurkartal.dataaccess.abstracts.ProductRepository;
import net.ugurkartal.dataaccess.concrates.ProductListDal;
import net.ugurkartal.entities.abstracts.Product;
import net.ugurkartal.entities.concrates.Cheese;
import net.ugurkartal.entities.concrates.Wine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class WineManager implements WineService {
    List<Product> wines;
    Map<Product, String> printFormat;
    private int dayCounter;

    ProductRepository productRepository = new ProductListDal();

    public WineManager() {
        wines = productRepository.getProductsByProductType("Wine");
        printFormat = new HashMap<>();
        this.dayCounter = 1;
        updateProductMap();
    }

    @Override
    public int updateQuality(Product product) {
        int newQuality = product.getQuality();
        if (product.getQuality()<50){
            newQuality += dayCounter/10;
        }
        return newQuality;
    }

    @Override
    public void updateProductMap() {
        for (Product wine : wines) {
            printFormat.put(wine, String.format("Product type: %s, Product name: %s, Price: %.2f, Quality: %d, Can sell: %s%n", wine.getClass().getSimpleName(), wine.getName(), wine.getPrice(), this.updateQuality(wine), "Yes"));
        }
    }

    @Override
    public Map<Product, String> getProducts() {
        updateProductMap();
        return getPrintFormat();
    }

    @Override
    public List<Product> getAllProductsWithCurrentStatus() {
        return productRepository.getProductsByProductType("Wine");
    }

    @Override
    public String getProductByName(String name) {
        updateProductMap();
        Product product = wines.stream().filter(w -> w.getName().equals(name)).findFirst().orElse(null);
        return printFormat.get(product);
    }

    @Override
    public void makeOld() {
        this.dayCounter++;
        updateProductMap();
    }
}