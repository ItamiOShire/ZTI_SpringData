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

    ///
    /// SELECT *
    /// FROM client
    /// WHERE LOWER(last_name) LIKE LOWER('%kowalski%');
    ///
    List<Client> findByLastNameContainingIgnoreCase(String lastName);

    ///
    /// SELECT *
    /// FROM client
    /// WHERE email = 'jan.kowalski@kaufland.pl'
    /// LIMIT 1;
    ///
    Optional<Client> findByEmail(String email);

    ///
    /// SELECT *
    /// FROM client
    /// WHERE LOWER(first_name) LIKE LOWER('%jan%')
    /// ORDER BY last_name ASC
    /// LIMIT 5 OFFSET 0;
    ///
    Page<Client> findByFirstNameContainingIgnoreCase(String name, Pageable pageable);


    @Query("SELECT c FROM Client c WHERE c.card IS NOT NULL")
    List<Client> findClientsWithCard();


    @Query(value = "SELECT * FROM Client WHERE email LIKE %:domain", nativeQuery = true)
    List<Client> findByEmailDomain(@Param("domain") String domain);
}
