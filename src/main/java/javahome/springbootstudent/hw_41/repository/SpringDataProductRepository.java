package javahome.springbootstudent.hw_41.repository;

import javahome.springbootstudent.hw_41.repository.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SpringDataProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByNameLikeOrDescriptionLike(String name, String description);
}

