package zit.springdata.zti_springdata.repository.PagingAndSortingRepository;

import org.springframework.data.repository.PagingAndSortingRepository;
import zit.springdata.zti_springdata.entity.CartItem;

public interface CartItemRepository extends PagingAndSortingRepository<CartItem,Integer> {


}
