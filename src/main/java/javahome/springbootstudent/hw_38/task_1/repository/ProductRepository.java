package javahome.springbootstudent.hw_38.task_1.repository;

import jakarta.annotation.PostConstruct;
import javahome.springbootstudent.hw_38.task_1.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepository {
    private Map<Integer, Product> products = new HashMap<>();

    @PostConstruct
    public void init() {
        products.put(1, new Product(1, "Potato", "3kg in pack", 3.50));
        products.put(2, new Product(2, "Orange", "From Turkey", 6.90));
        products.put(3, new Product(3, "Water", "Highly carbonated", 2.00));
        products.put(4, new Product(4, "Corn", "Canned corn 2 in pack", 7.15));
        products.put(5, new Product(5, "Cherry", "1kg in pack", 20.00));
        products.put(6, new Product(6, "Bread", "Toast bread", 1.90));
        products.put(7, new Product(7, "Chocolate", "Dark chocolate 100g", 7.45));
    }

    public Product getProductById(Integer id) {
        return products.get(id);
    }

    public Collection<Product> getAllProducts() {
        return products.values();
    }

    public String deleteProduct(Integer id) {
        products.remove(id);
        return "Product with id=" + id + " deleted";
    }

}
