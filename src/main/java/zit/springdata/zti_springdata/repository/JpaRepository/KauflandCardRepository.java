package zit.springdata.zti_springdata.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import zit.springdata.zti_springdata.entity.KauflandCard;

public interface KauflandCardRepository extends JpaRepository<KauflandCard,Integer> {
}
