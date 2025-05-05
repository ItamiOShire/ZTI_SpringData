package zit.springdata.zti_springdata.repository.CrudRepository;

import org.springframework.data.repository.CrudRepository;
import zit.springdata.zti_springdata.entity.CartItem;

public interface CrudCartItemRepository extends CrudRepository<CartItem,Integer> {


}
