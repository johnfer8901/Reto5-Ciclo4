package co.usa.reto5.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.reto5.model.Order;
import co.usa.reto5.repository.crud.OrderCrudRepository;

/**
 *
 * @author John F
 */
@Repository
public class OrderRepository {

    @Autowired
    private OrderCrudRepository orderCrudRepository;

    public List<Order> getAll() {
        return (List<Order>) orderCrudRepository.findAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderCrudRepository.findById(id);
    }

    public Order create(Order order) {
        return orderCrudRepository.save(order);
    }

    public void update(Order order) {
        orderCrudRepository.save(order);
    }

    public void delete(Order order) {
        orderCrudRepository.delete(order);
    }
    
    public Optional<Order> lastUserId(){
        return orderCrudRepository.findTopByOrderByIdDesc();
    }

    public List<Order> findByZone(String zona) {
        return (List<Order>) orderCrudRepository.findByZone(zona);
    }

    public List<Order> findBySalesManId(Integer id){

        return (List<Order>) orderCrudRepository.findBySalesManId(id);
    }

    public List<Order> getSalesManIdAndStatus (Integer id, String status){

        return (List<Order>) orderCrudRepository.findBySalesManIdAndStatus(id, status);
    }

    public List<Order> getRegisterDateAndSalesM (Integer id, String registerDay) throws ParseException{

        return (List<Order>) orderCrudRepository.findByRegisterDayAndSalesManId(new SimpleDateFormat("yyyy-MM-dd").parse(registerDay), id);
    }

}
