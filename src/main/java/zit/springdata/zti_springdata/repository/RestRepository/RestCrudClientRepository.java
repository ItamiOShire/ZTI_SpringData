package zit.springdata.zti_springdata.repository.RestRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import zit.springdata.zti_springdata.entity.Client;

@RepositoryRestResource(collectionResourceRel = "client", path="client")
public interface RestCrudClientRepository extends JpaRepository<Client, Integer> {
}
