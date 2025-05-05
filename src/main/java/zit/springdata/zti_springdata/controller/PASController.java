package zit.springdata.zti_springdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import zit.springdata.zti_springdata.service.PagingAndSortingService;
import zit.springdata.zti_springdata.entity.*;

@RestController
@RequestMapping("/pas/")
public class PASController {

    private final PagingAndSortingService pagingAndSortingService;

    @Autowired

    public PASController(PagingAndSortingService pagingAndSortingService) {
        this.pagingAndSortingService = pagingAndSortingService;
    }

    @GetMapping("/product")
    public Page<Product> getProductPage(@RequestParam int pages, @RequestParam int items) {
        return pagingAndSortingService.getPageProduct(items, pages);
    }

    @GetMapping("/session/cardId/{cardId}")
    public Page<ShoppingSession> getShoppingSessionsByCardId(
            @PathVariable Integer cardId,
            @RequestParam int pageSize,
            @RequestParam int pageNumber,
            @RequestParam String[] sortBy) {

        return pagingAndSortingService.getPageSessionsSorted(cardId, pageSize, pageNumber, sortBy);

    }

    @GetMapping("/client/all")
    public Page<Client> getClientPage(
            @RequestParam String lastName,
            @RequestParam int pageSize,
            @RequestParam int pageNumber,
            @RequestParam String[] sortBy) {
        return pagingAndSortingService.getPageClientsSorted(lastName, pageSize, pageNumber, sortBy);
    }
}
