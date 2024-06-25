package com.example.WebHW4.domain.repository;

import com.example.WebHW4.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>
{
    public List<Product> findByName(String name);
    public List<Product> findByNameContaining(String name);
    public List<Product> findByPrice(int price);

    public List<Product> findByType(String type);
}
