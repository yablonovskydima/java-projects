package com.example.WebHW4.webcontroller;

import com.example.WebHW4.domain.entity.Product;
import com.example.WebHW4.domain.entity.User;
import com.example.WebHW4.domain.repository.ProductRepository;
import com.example.WebHW4.domain.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController
{
    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Operation(summary = "Show information about products")
    @ApiResponse(responseCode = "200", description = "Success")
    @GetMapping()
    public List<Product> show() {
        return productRepository.findAll();
    }

    @Operation(summary = "Add product")
    @ApiResponse(responseCode = "200", description = "Success")
    @PostMapping("/add")
    public Product add(@RequestBody Product product) {
        productRepository.save(product);
        return product;
    }

    @Operation(summary = "Edit product by ID")
    @ApiResponse(responseCode = "200", description = "Success")
    @PutMapping("/edit/{id}")
    public Product edit(@PathVariable int id, @RequestBody Product product) {
        Product old = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        old.setName(product.getName());
        old.setDescription(product.getDescription());
        old.setPrice(product.getPrice());
        old.setType(product.getType());
        productRepository.save(old);
        return old;
    }

    @Operation(summary = "Delete product by ID")
    @ApiResponse(responseCode = "200", description = "Success")
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        Product productToDelete = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        productRepository.delete(productToDelete);
        return "Product with id " + id + " was deleted";
    }

    @Operation(summary = "Get product by ID")
    @ApiResponse(responseCode = "200", description = "Success")
    @PostMapping("/get-product/{id}")
    public Product getProductById(@PathVariable int id)
    {
        return productRepository.findById(id).orElseThrow();
    }

    @Operation(summary = "Get product by name")
    @ApiResponse(responseCode = "200", description = "Success")
    @PostMapping("/find-by-name/{name}")
    public List<Product> getProductById(@PathVariable String name)
    {
        return productRepository.findByName(name);
    }

    @Operation(summary = "Get product by key-word which is contained in product's name")
    @ApiResponse(responseCode = "200", description = "Success")
    @PostMapping("/containing-name/{name}")
    public List<Product> getProductByNameContaining(@PathVariable String name)
    {
        return productRepository.findByNameContaining(name);
    }

    @Operation(summary = "Get product by price")
    @ApiResponse(responseCode = "200", description = "Success")
    @PostMapping("/find-by-price/{price}")
    public List<Product> getProductByNameContaining(@PathVariable Integer price)
    {
        return productRepository.findByPrice(price);
    }

    @Operation(summary = "Get product by product type")
    @ApiResponse(responseCode = "200", description = "Success")
    @PostMapping("/find-by-type/{type}")
    public List<Product> getProductByType(@PathVariable String type)
    {
        return productRepository.findByType(type);
    }
}
