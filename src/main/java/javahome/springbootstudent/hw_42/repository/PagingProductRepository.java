package javahome.springbootstudent.hw_42.repository;

import javahome.springbootstudent.hw_42.repository.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PagingProductRepository extends PagingAndSortingRepository<Product, Integer> {

}
