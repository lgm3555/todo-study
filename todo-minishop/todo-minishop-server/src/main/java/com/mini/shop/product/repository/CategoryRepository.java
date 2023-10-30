package com.mini.shop.product.repository;

import com.mini.shop.product.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsById(Long id);
}
