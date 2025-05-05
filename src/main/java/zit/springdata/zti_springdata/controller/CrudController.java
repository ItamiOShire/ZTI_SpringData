package zit.springdata.zti_springdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zit.springdata.zti_springdata.entity.CartItem;
import zit.springdata.zti_springdata.entity.Client;
import zit.springdata.zti_springdata.entity.Product;
import zit.springdata.zti_springdata.repository.CrudRepository.*;
import zit.springdata.zti_springdata.service.CrudService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/crud/")
public class CrudController {

    private final CrudService crudService;

    @Autowired
    public CrudController(CrudService crudService) {
        this.crudService = crudService;
    }

    @GetMapping("/allCartItems")
    public List<CartItem> findAllCartItems() {
        return crudService.findAllCartItems();
    }

    @GetMapping("/product")
    public Product findProductByName(@RequestParam String name) {
        return crudService.findProductByName(name);
    }

    @GetMapping("/client/{id}")
    public Client findClientById(@PathVariable Integer id) {
        return crudService.findClientById(id);
    }

    @DeleteMapping("/client/{id}")
    public boolean deleteClientById(@PathVariable Integer id) {
        return crudService.deleteClientById(id);
    }

    @PatchMapping("/product/{id}")
    public Product updateProduct(@RequestParam BigDecimal price,  @PathVariable Integer id) {
        return crudService.updateProduct(price, id);
    }

    @GetMapping("/product/{name}/{price}")
    public List<Product> getProductsByNameAndPriceLowerThanGiven(@PathVariable String name,@PathVariable BigDecimal price) {
        return crudService.findProductsByNameAndLessThanPrice(name, price);
    }

}
