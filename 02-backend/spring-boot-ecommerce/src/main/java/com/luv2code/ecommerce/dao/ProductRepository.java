package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Spring magic: SELECT * FROM products WHERE category_id=?
    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable); /* then also Spring Data REST will
                                                automatically expose                                                                   //the endpoint based on that given method name,
                                                http://localhost:8080/api/products/search/findByCategoryId?id=2
                                                so search/findByCategoryId, and then here we have the ID, and that's
                                                what we pass over to that given REST API */

    /* Spring magic: SELECT * FROM Product p WHERE p.name LIKE CONCAT ('%', :name ,'%') */
    Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
}
