package com.wojciechwoloszun.rest.repository;

import com.wojciechwoloszun.rest.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
