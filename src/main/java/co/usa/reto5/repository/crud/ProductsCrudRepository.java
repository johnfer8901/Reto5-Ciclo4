package co.usa.reto5.repository.crud;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.usa.reto5.model.Products;

public interface ProductsCrudRepository extends MongoRepository<Products, Integer>{

    List<Products> findByDescriptionLike(String description);

    List<Products> findByPriceLessThanEqual(double price);
    
    
}
