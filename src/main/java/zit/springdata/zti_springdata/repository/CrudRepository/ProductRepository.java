package zit.springdata.zti_springdata.repository.CrudRepository;

import org.springframework.data.repository.CrudRepository;
import zit.springdata.zti_springdata.entity.Product;

public interface ProductRepository extends CrudRepository<Product,Integer> {
}
