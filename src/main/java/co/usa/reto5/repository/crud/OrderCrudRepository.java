package co.usa.reto5.repository.crud;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import co.usa.reto5.model.Order;

/**
 *
 * @author John F
 */
public interface OrderCrudRepository extends MongoRepository<Order, Integer> {
    
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String zona);
    
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);
    
    Optional<Order> findTopByOrderByIdDesc();

    List<Order> findBySalesManId(Integer id);
    
    List<Order> findBySalesManIdAndStatus(Integer id, String status);

    List<Order> findByRegisterDayAndSalesManId(Date registerDay, Integer id);

    
}
