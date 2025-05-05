package zit.springdata.zti_springdata.repository.PagingAndSortingRepository;

import org.springframework.data.repository.PagingAndSortingRepository;
import zit.springdata.zti_springdata.entity.Product;

public interface PASProductRepository extends PagingAndSortingRepository<Product,Integer> {
}
