package com.racqcomm.racqecommerce.DAO;

import com.racqcomm.racqecommerce.Entity.Product;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
            List<Product> findByNameContaining(String name, Pageable pageable);

}
