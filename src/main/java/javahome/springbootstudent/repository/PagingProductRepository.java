package javahome.springbootstudent.repository;

import javahome.springbootstudent.repository.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PagingProductRepository extends PagingAndSortingRepository<Product, Integer> {

}
