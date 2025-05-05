package zit.springdata.zti_springdata.repository.PagingAndSortingRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import zit.springdata.zti_springdata.entity.KauflandCard;
import zit.springdata.zti_springdata.entity.ShoppingSession;


public interface PASShoppingSessionRepository extends PagingAndSortingRepository<ShoppingSession,Integer> {
    Page<ShoppingSession> findByCard(KauflandCard card, Pageable pageable);
}
