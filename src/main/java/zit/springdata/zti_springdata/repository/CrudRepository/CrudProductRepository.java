package zit.springdata.zti_springdata.repository.CrudRepository;

import org.springframework.data.repository.CrudRepository;
import zit.springdata.zti_springdata.entity.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface CrudProductRepository extends CrudRepository<Product,Integer> {
    Optional<Product> findByProductName(String productName);

    Optional<List<Product>> findByProductNameLikeAndPriceLessThan(String productName, BigDecimal price);
}
