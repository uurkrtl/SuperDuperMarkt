package net.ugurkartal.business.abstracts;

import net.ugurkartal.entities.abstracts.Product;

public interface CheeseService extends BaseService {
    double updatePrice(Product product);
    boolean canSell(Product product);
}