package zit.springdata.zti_springdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zit.springdata.zti_springdata.entity.CartItem;
import zit.springdata.zti_springdata.entity.Client;
import zit.springdata.zti_springdata.entity.Product;
import zit.springdata.zti_springdata.repository.CrudRepository.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CrudService {

    private final CrudCartItemRepository crudCartItemRepository;
    private final CrudProductRepository crudProductRepository;
    private final CrudClientRepository crudClientRepository;
    private final CrudKauflandCardRepository crudKauflandCardRepository;
    private final CrudScannerRepository crudScannerRepository;
    private final CrudShoppingSessionRepository crudShoppingSessionRepository;

    @Autowired
    public CrudService(CrudCartItemRepository crudCartItemRepository, CrudProductRepository crudProductRepository, CrudClientRepository crudClientRepository, CrudKauflandCardRepository crudKauflandCardRepository, CrudScannerRepository crudScannerRepository, CrudShoppingSessionRepository crudShoppingSessionRepository) {
        this.crudCartItemRepository = crudCartItemRepository;
        this.crudProductRepository = crudProductRepository;
        this.crudClientRepository = crudClientRepository;
        this.crudKauflandCardRepository = crudKauflandCardRepository;
        this.crudScannerRepository = crudScannerRepository;
        this.crudShoppingSessionRepository = crudShoppingSessionRepository;
    }

    public boolean addAllCartItems(List<CartItem> cartItems) {

        List<CartItem> saved = (List<CartItem>) crudCartItemRepository.saveAll(cartItems);

        return !saved.isEmpty();

    }

    public List<CartItem> findAllCartItems() {
        return (List<CartItem>) crudCartItemRepository.findAll();
    }

    public Product findProductById(Integer id) {
        Optional<Product> product = crudProductRepository.findById(id);

        return product.orElse(null);
    }

    public Product findProductByName(String productName) {
        Optional<Product> product = crudProductRepository.findByProductName(productName);

        return product.orElse(null);
    }


    public Client findClientById(Integer id) {
        Optional<Client> client = crudClientRepository.findById(id);
        return client.orElse(null);
    }

    public boolean deleteClientById(Integer id) {
        crudClientRepository.deleteById(id);

        Client client = crudClientRepository.findById(id).orElse(null);

        if (client == null) {
            return true;
        } else {
            return false;
        }
    }

    public Product updateProduct(BigDecimal price, Integer id) {

        Product product = crudProductRepository.findById(id).orElse(null);
        product.setPrice(price);

        return crudProductRepository.save(product);
    }

    public List<Product> findProductsByNameAndLessThanPrice(String productName, BigDecimal price) {

        Optional<List<Product>> list = crudProductRepository.findByProductNameLikeAndPriceLessThan(productName, price);

        return list.orElse(null);
    }



}
