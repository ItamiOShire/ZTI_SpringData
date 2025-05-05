package zit.springdata.zti_springdata.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import zit.springdata.zti_springdata.entity.Client;

import java.util.List;

public class CustomRepositoryImpl implements CustomRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Client> findLoyalClients(String emailDomain, int minSessions) {
        String jpql = """
            SELECT c FROM Client c
            WHERE c.card IS NOT NULL
              AND c.email LIKE :emailPattern
              AND (
                SELECT COUNT(s) FROM ShoppingSession s
                WHERE s.card.id = c.card.id
              ) > :minSessions
        """;

        return em.createQuery(jpql, Client.class)
                .setParameter("emailPattern", "%" + emailDomain)
                .setParameter("minSessions", minSessions)
                .getResultList();
    }
}
