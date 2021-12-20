package co.usa.reto5.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.reto5.model.Products;
import co.usa.reto5.repository.ProductsRepository;

/**
 *
 * @author John F
 */
@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    public List<Products> getAll() {
        return productsRepository.getAll();
    }

    public Optional<Products> getProducts(int id) {
        return productsRepository.getProducts(id);
    }

    public Products create(Products producto) {
        if (producto.getId() == null) {
            return producto;
        } else {
            return productsRepository.create(producto);
        }
    }

    public Products update(Products producto) {

        if (producto.getId() != null) {
            Optional<Products> productoDb = productsRepository.getProducts(producto.getId());
            if (!productoDb.isEmpty()) {

                if (producto.getBrand() != null) {
                    productoDb.get().setBrand(producto.getBrand());
                }

                if (producto.getCategory() != null) {
                    productoDb.get().setCategory(producto.getCategory());
                }

                if (producto.getPresentation() != null) {
                    productoDb.get().setPresentation(producto.getPresentation());
                }

                if (producto.getDescription() != null) {
                    productoDb.get().setDescription(producto.getDescription());
                }
                if (producto.getPrice() != 0.0) {
                    productoDb.get().setPrice(producto.getPrice());
                }
                if (producto.getQuantity() != 0) {
                    productoDb.get().setQuantity(producto.getQuantity());
                }
                if (producto.getPhotography() != null) {
                    productoDb.get().setPhotography(producto.getPhotography());
                }
                productoDb.get().setAvailability(producto.isAvailability());
                productsRepository.update(productoDb.get());
                return productoDb.get();
            } else {
                return producto;
            }
        } else {
            return producto;
        }
    }


    public boolean delete(int id) {
        Boolean aBoolean = getProducts(id).map(producto -> {
            productsRepository.delete(producto);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<Products> productByPrice(double price) {
        return productsRepository.productByPrice(price);
    }

    public List<Products> findByDescriptionLike(String description) {
        return productsRepository.findByDescriptionLike(description);
    }    

}
