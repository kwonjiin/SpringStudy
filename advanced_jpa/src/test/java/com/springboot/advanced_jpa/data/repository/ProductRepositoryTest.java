package com.springboot.advanced_jpa.data.repository;

import com.springboot.advanced_jpa.data.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import java.time.LocalDateTime;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void sortingAndPagingTest() {
        Product product1 = new Product();
        product1.setName("펜");
        product1.setPrice(1000);
        product1.setStock(100);
        product1.setCreatedAt(LocalDateTime.now());
        product1.setUpdatedAt(LocalDateTime.now());

        Product product2 = new Product();
        product2.setName("펜");
        product2.setPrice(5000);
        product2.setStock(300);
        product2.setCreatedAt(LocalDateTime.now());
        product2.setUpdatedAt(LocalDateTime.now());

        Product product3 = new Product();
        product3.setName("펜");
        product3.setPrice(500);
        product3.setStock(50);
        product3.setCreatedAt(LocalDateTime.now());
        product3.setUpdatedAt(LocalDateTime.now());

        Product savedProduct1 = productRepository.save(product1);
        Product savedProduct2 = productRepository.save(product2);
        Product savedProduct3 = productRepository.save(product3);


//        쿼리 메서드에 Sort 객체 전달
//        productRepository.findByName("펜", Sort.by(Order.asc("price")));
//        productRepository.findByName("펜", Sort.by(Order.asc("price"), Order.desc("stock")));

        System.out.println(productRepository.findByName("펜", getSort()));
    }

//    쿼리 메서드에서 정렬 부분을 분리
    private Sort getSort() {
        return Sort.by(
                Order.asc("price"),
                Order.desc("Stock")
        );
    }
//    페이징 쿼리 메서드를 호출하는 방법
    Page<Product> productPage = productRepository.findByName("펜", PageRequest.of(0, 2));

//    Page 객체의 데이터 출력
//    Page<Product> productPage = productRepository.findByName("펜", PageRequest.of(0, 2));
//    System.out.println(productPage.getContent());
}
