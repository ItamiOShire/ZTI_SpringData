package zit.springdata.zti_springdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/sessions/cardId/1")
    public Page<ShoppingSession> getShoppingSessionsByCardId(
            @RequestParam Integer cardId,
            @RequestParam int pageSize,
            @RequestParam int pageNumber,
            @RequestParam String[] sortBy) {

        return pagingAndSortingService.getPageSessionsSorted(cardId, pageSize, pageNumber, sortBy);

    }
}
