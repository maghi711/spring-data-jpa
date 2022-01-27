package com.maghi711.springbootjpa.product.repos;

import com.maghi711.springbootjpa.product.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
