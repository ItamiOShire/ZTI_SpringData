package zit.springdata.zti_springdata.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import zit.springdata.zti_springdata.entity.Client;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
