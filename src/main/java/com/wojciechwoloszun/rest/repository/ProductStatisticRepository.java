package com.wojciechwoloszun.rest.repository;

import com.wojciechwoloszun.rest.model.ProductStatistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductStatisticRepository extends JpaRepository<ProductStatistic, Long> {

    @Query("select ps from ProductStatistic ps where ps.product.id = :xxx")
    ProductStatistic findByProductId(@Param("xxx") Long productId);

}
