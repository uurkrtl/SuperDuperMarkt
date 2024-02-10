package net.ugurkartal.business.concrates;

import lombok.Data;
import net.ugurkartal.business.abstracts.CheeseService;
import net.ugurkartal.dataaccess.abstracts.ProductRepository;
import net.ugurkartal.dataaccess.concrates.ProductListDal;
import net.ugurkartal.entities.abstracts.Product;
import net.ugurkartal.entities.concrates.Cheese;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class CheeseManager implements CheeseService {
    private final int MIN_QUALITY;
    private int dayCounter;
    List<Product> cheeses;
    Map<Product , String> printFormat;

    ProductRepository productRepository = new ProductListDal();

    public CheeseManager() {
        cheeses = productRepository.getProductsByProductType("Cheese");
        printFormat = new HashMap<>();
        this.MIN_QUALITY = 30;
        this.dayCounter = 0;
        updateProductMap();
    }

    @Override
    public void updateProductMap() {
        for (Product cheese : cheeses) {
            printFormat.put(cheese, String.format("Product type: %s, Product name: %s, Price: %.2f, Quality: %d, Can sell: %s%n", cheese.getClass().getSimpleName(), cheese.getName(), this.updatePrice(cheese), this.updateQuality(cheese), this.canSell(cheese) ? "Yes" : "No"));
        }
    }

    @Override
    public void makeOld() {
        this.dayCounter++;
        updateProductMap();
    }

    @Override
    public double updatePrice(Product product) {
        return product.getPrice() + (this.updateQuality(product) * 0.1);
    }

    @Override
    public boolean canSell(Product product) {
        if (this.updateQuality(product) < MIN_QUALITY || product.getExpirationDate().isBefore(LocalDate.now().plusDays(dayCounter))) {
            return false;
        }
        return true;
    }

    @Override
    public int updateQuality(Product product) {
        return product.getQuality() - dayCounter;
    }

    @Override
    public Map<Product, String> getProducts() {
        updateProductMap();
        return getPrintFormat();
    }

    @Override
    public List<Product> getAllProductsWithCurrentStatus() {
        return productRepository.getProductsByProductType("Cheese");
    }

    @Override
    public String getProductByName(String name) {
        updateProductMap();
        Product product = cheeses.stream().filter(c -> c.getName().equals(name)).findFirst().orElse(null);
        return printFormat.get(product);
    }
}