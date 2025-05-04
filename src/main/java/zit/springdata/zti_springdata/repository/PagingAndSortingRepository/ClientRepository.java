package zit.springdata.zti_springdata.repository.PagingAndSortingRepository;

import org.springframework.data.repository.PagingAndSortingRepository;
import zit.springdata.zti_springdata.entity.Client;

public interface ClientRepository extends PagingAndSortingRepository<Client,Integer> {
}
