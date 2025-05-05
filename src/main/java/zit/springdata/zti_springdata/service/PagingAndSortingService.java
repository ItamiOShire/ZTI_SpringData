package zit.springdata.zti_springdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import zit.springdata.zti_springdata.entity.Client;
import zit.springdata.zti_springdata.entity.KauflandCard;
import zit.springdata.zti_springdata.entity.Product;
import zit.springdata.zti_springdata.entity.ShoppingSession;
import zit.springdata.zti_springdata.repository.PagingAndSortingRepository.*;

import javax.smartcardio.Card;

@Service
public class PagingAndSortingService {

    private final PASCartItemRepository PASCartItemRepository;
    private final PASProductRepository PASProductRepository;
    private final PASClientRepository PASClientRepository;
    private final PASKauflandCardRepository PASKauflandCardRepository;
    private final PASScannerRepository PASScannerRepository;
    private final PASShoppingSessionRepository PASShoppingSessionRepository;

    @Autowired
    public PagingAndSortingService(PASCartItemRepository PASCartItemRepository, PASProductRepository PASProductRepository, PASClientRepository PASClientRepository, PASKauflandCardRepository PASKauflandCardRepository, PASScannerRepository PASScannerRepository, PASShoppingSessionRepository PASShoppingSessionRepository) {
        this.PASCartItemRepository = PASCartItemRepository;
        this.PASProductRepository = PASProductRepository;
        this.PASClientRepository = PASClientRepository;
        this.PASKauflandCardRepository = PASKauflandCardRepository;
        this.PASScannerRepository = PASScannerRepository;
        this.PASShoppingSessionRepository = PASShoppingSessionRepository;
    }


    public Page<Product> getPageProduct(int pageSize, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return PASProductRepository.findAll(pageable);
    }

    public Page<ShoppingSession> getPageSessionsSorted(Integer id,int pageSize, int pageNumber, String[] sortBy) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize,  Sort.by(Sort.Direction.fromString(sortBy[1]),sortBy[0]));
        KauflandCard card = PASKauflandCardRepository.findKauflandCardById(id);
        return PASShoppingSessionRepository.findByCard(card, pageable);
    }

    public Page<Client> getPageClientsSorted(String lastName,int pageSize, int pageNumber, String[] sortBy) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize,  Sort.by(Sort.Direction.fromString(sortBy[1]),sortBy[0]));
        return PASClientRepository.findByLastNameContainingIgnoreCase(lastName, pageable);

    }

}
