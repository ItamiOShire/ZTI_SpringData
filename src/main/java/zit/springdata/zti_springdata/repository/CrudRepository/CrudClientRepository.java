package zit.springdata.zti_springdata.repository.CrudRepository;

import org.springframework.data.repository.CrudRepository;
import zit.springdata.zti_springdata.entity.Client;

public interface CrudClientRepository extends CrudRepository<Client,Integer> {
}
