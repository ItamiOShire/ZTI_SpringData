package zit.springdata.zti_springdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import zit.springdata.zti_springdata.entity.Client;
import zit.springdata.zti_springdata.repository.JpaRepository.*;

import java.util.List;

@Service
public class JpaService {

    private final JpaCartItemRepository jpaCartItemRepository;
    private final JpaProductRepository jpaProductRepository;
    private final JpaClientRepository jpaClientRepository;
    private final JpaKauflandCardRepository jpaKauflandCardRepository;
    private final JpaScannerRepository jpaScannerRepository;
    private final JpaShoppingSessionRepository jpaShoppingSessionRepository;

    @Autowired
    public JpaService(JpaCartItemRepository jpaCartItemRepository, JpaProductRepository jpaProductRepository, JpaClientRepository jpaClientRepository, JpaKauflandCardRepository jpaKauflandCardRepository, JpaScannerRepository jpaScannerRepository, JpaShoppingSessionRepository jpaShoppingSessionRepository) {
        this.jpaCartItemRepository = jpaCartItemRepository;
        this.jpaProductRepository = jpaProductRepository;
        this.jpaClientRepository = jpaClientRepository;
        this.jpaKauflandCardRepository = jpaKauflandCardRepository;
        this.jpaScannerRepository = jpaScannerRepository;
        this.jpaShoppingSessionRepository = jpaShoppingSessionRepository;
    }

    public List<Client> getClientsWithCard() {
        return jpaClientRepository.findClientsWithCard();
    }

    public Page<Client> searchClients(
            int page,
            int size,
            String[] sort,
            String filter) {

        Sort.Direction dir = Sort.Direction.fromString(sort[1]);
        Pageable pageable = PageRequest.of(page, size, Sort.by(dir, sort[0]));

        if (filter != null) {
            return jpaClientRepository.findByFirstNameContainingIgnoreCase(filter, pageable);
        }

        return jpaClientRepository.findAll(pageable);
    }

    public List<Client> getByEmailDomain(String domain) {
        return jpaClientRepository.findByEmailDomain(domain);
    }

}
