package zit.springdata.zti_springdata.repository;

import zit.springdata.zti_springdata.entity.Client;

import java.util.List;

public interface CustomRepository {
    List<Client> findLoyalClients(String emailDomain, int minSessions);
}
