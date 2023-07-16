package javahome.springbootstudent.repository;

import javahome.springbootstudent.repository.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {
}
