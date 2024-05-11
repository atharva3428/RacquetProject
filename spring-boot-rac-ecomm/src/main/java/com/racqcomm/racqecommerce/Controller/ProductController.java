package com.racqcomm.racqecommerce.Controller;

import com.racqcomm.racqecommerce.Entity.Product;
import com.racqcomm.racqecommerce.Service.ProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService theProductService){
        productService = theProductService;
    }
    @GetMapping("/products")
    public List<Product> findAll(@RequestParam int page,@RequestParam int size){
        return productService.findAll(page,size);
    }
    @GetMapping("/products/{id}")
    public Optional<Product> findById(@PathVariable int id)
    {
        return productService.findById(id);
    }
//    @GetMapping("/hello")
//    public String hello(@RequestParam(value = "name", defaultValue = "World") String name){
//        return "Hello"+ name;
//    }
    @PostMapping("/products")
    public Product create(@Valid @RequestBody Product product){
        return productService.save(product);
    }
    @DeleteMapping("/products/{id}")
    public void deletebyId(@PathVariable int id)
    {
        productService.delete(id);
    }
    @PutMapping("products/{id}")
    public Product update(@PathVariable int id, @RequestBody Product product)
    {
        Optional<Product> existprod = productService.findById(id);
        Product prod = existprod.get();
        prod.setName(product.getName());
        return productService.update(product);
    }

    @GetMapping("/search/{name}")
    public List<Product> findByName(@PathVariable String name, @RequestParam int page , @RequestParam int size){
        return productService.findByName(name, page,size);
    }
}
