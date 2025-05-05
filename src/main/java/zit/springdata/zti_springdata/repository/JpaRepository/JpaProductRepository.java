package zit.springdata.zti_springdata.repository.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import zit.springdata.zti_springdata.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface JpaProductRepository extends JpaRepository<Product,Integer> {
    // Wyszukiwanie po nazwie
    Page<Product> findByProductNameContainingIgnoreCase(String name, Pageable pageable);

    // Znajdź najtańsze produkty
    List<Product> findTop5ByOrderByPriceAsc();

    // Produkty w przedziale cenowym
    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);
}
