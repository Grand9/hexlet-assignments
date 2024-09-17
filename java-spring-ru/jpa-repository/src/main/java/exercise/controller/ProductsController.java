package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;

import java.util.List;

import exercise.model.Product;
import exercise.repository.ProductRepository;
import exercise.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final String INTERGER_MAX_VALUE = "2147483647";
    @Autowired
    private ProductRepository productRepository;

    // BEGIN
    @GetMapping(path = "")
    public List<Product> availableProducts(@RequestParam(defaultValue = "0", required = false) int min,
                                           @RequestParam(defaultValue = INTERGER_MAX_VALUE, required = false) int max) {
        var sort = Sort.by(Sort.Order.asc("price"));
        return productRepository.findByPriceBetween(min, max, sort);
    }
    // END

    @GetMapping(path = "/{id}")
    public Product show(@PathVariable long id) {

        var product =  productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));

        return product;
    }
}
