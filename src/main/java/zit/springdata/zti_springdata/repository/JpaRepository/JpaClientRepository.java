package zit.springdata.zti_springdata.repository.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import zit.springdata.zti_springdata.entity.Client;

import java.util.List;
import java.util.Optional;

public interface JpaClientRepository extends JpaRepository<Client,Integer> {
    // Filtrowanie po nazwisku
    List<Client> findByLastNameContainingIgnoreCase(String lastName);

    // Szukanie po emailu (unikalnym)
    Optional<Client> findByEmail(String email);

    // Paginacja + sortowanie + filtr
    Page<Client> findByFirstNameContainingIgnoreCase(String name, Pageable pageable);

    // Custom query (JPQL)
    @Query("SELECT c FROM Client c WHERE c.card IS NOT NULL")
    List<Client> findClientsWithCard();

    // Natywne SQL
    @Query(value = "SELECT * FROM Client WHERE email LIKE %:domain", nativeQuery = true)
    List<Client> findByEmailDomain(@Param("domain") String domain);
}
