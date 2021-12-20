package co.usa.reto5.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.reto5.model.Products;
import co.usa.reto5.repository.crud.ProductsCrudRepository;

/**
 *
 * @author Jhon F
 */
@Repository
public class ProductsRepository {

    @Autowired
    private ProductsCrudRepository productsCrudRepository;

    public List<Products> getAll() {
        return productsCrudRepository.findAll();
    }

    public Optional<Products> getProducts(int id) {
        return productsCrudRepository.findById(id);
    }
    public Products create(Products producto) {
        return productsCrudRepository.save(producto);
    }

    public void update(Products producto) {
        productsCrudRepository.save(producto);
    }
    
    public void delete(Products producto) {
        productsCrudRepository.delete(producto);
    }

    public List<Products> productByPrice(double price) {
        return productsCrudRepository.findByPriceLessThanEqual(price);
    }
    
    public List<Products> findByDescriptionLike(String description) {
        return productsCrudRepository.findByDescriptionLike(description);
    }  
    
}