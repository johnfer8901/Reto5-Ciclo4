package co.usa.reto5.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.usa.reto5.model.Products;
import co.usa.reto5.service.ProductsService;

/**
 *
 * @author John F
 */
@RestController
@RequestMapping("/api/cleaningprod")
@CrossOrigin("*")
public class ProductsController {

    @Autowired
    private ProductsService productsService;
       
     @GetMapping("/all")
    public List<Products> getAll() {
        return productsService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Products> getProducts(@PathVariable("id") int id) {
        return productsService.getProducts(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Products create(@RequestBody Products producto) {
        return productsService.create(producto);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Products update(@RequestBody Products producto) {
        return productsService.update(producto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return productsService.delete(id);
    }

    @GetMapping("/price/{price}")
    public List<Products> gadgetsByPrice(@PathVariable("price") double price) {
        return productsService.productByPrice(price);
    }
    @GetMapping("/description/{description}")
    public List<Products> findByDescriptionLike(@PathVariable("description") String description) {
        return productsService.findByDescriptionLike(description);
    }    


    
}
