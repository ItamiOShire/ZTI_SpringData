package zit.springdata.zti_springdata.repository.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import zit.springdata.zti_springdata.entity.ShoppingSession;

import java.util.List;

public interface JpaShoppingSessionRepository extends JpaRepository<ShoppingSession,Integer> {
    // Paginacja sesji klienta (przez ID karty)
    Page<ShoppingSession> findByCard_Id(Long cardId, Pageable pageable);

    // Własne zapytanie: aktywne sesje (bez daty końca)
    @Query("SELECT s FROM ShoppingSession s WHERE s.shoppingEnd IS NULL")
    List<ShoppingSession> findActiveSessions();

}
