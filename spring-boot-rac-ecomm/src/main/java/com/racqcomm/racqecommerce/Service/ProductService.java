package com.racqcomm.racqecommerce.Service;

import com.racqcomm.racqecommerce.DAO.ProductRepository;
import com.racqcomm.racqecommerce.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository theproductRepository){
        this.productRepository= theproductRepository;
    }

    public List<Product> findAll(int page, int size){

        Pageable pageable = PageRequest.of(page,size);
        return productRepository.findAll(pageable).getContent();
    }

    public Optional<Product> findById(int id)
    {
        return productRepository.findById(id);
    }

    public Product save(Product product){return productRepository.save(product);}

    public void delete(int id){
        productRepository.deleteById(id);
    }
    public Product update(Product product){return productRepository.save(product);}

    public List<Product> findByName(String name, int page, int size){
        Pageable pageable = PageRequest.of(page ,size);
        return productRepository.findByNameContaining(name,pageable);
    }
}
