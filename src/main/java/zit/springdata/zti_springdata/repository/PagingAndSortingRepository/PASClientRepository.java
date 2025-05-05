package zit.springdata.zti_springdata.repository.PagingAndSortingRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import zit.springdata.zti_springdata.entity.Client;

public interface PASClientRepository extends PagingAndSortingRepository<Client,Integer> {
    Page<Client> findByLastNameContainingIgnoreCase(String lastName, Pageable pageable);
}
