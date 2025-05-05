package zit.springdata.zti_springdata.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import zit.springdata.zti_springdata.entity.CartItem;

public interface JpaCartItemRepository extends JpaRepository<CartItem,Integer> {


}
