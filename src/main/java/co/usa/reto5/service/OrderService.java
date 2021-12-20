package co.usa.reto5.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.reto5.model.Order;
import co.usa.reto5.repository.OrderRepository;

/**
 *
 * @author John F
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderRepository.getOrder(id);
    }

    public Order create(Order order) {
        
        Optional<Order> orderIdMaxima = orderRepository.lastUserId();
        
        if (order.getId() == null) {

            if (orderIdMaxima.isEmpty())
                order.setId(1);
            else
                order.setId(orderIdMaxima.get().getId() + 1);
        }
        
        Optional<Order> e = orderRepository.getOrder(order.getId());
        if (e.isEmpty()) {
            return orderRepository.create(order);            
        }else{
            return order;
        }        
    }

    public Order update(Order order) {

        if (order.getId() != null) {
            Optional<Order> orderDb = orderRepository.getOrder(order.getId());
            if (!orderDb.isEmpty()) {
                if (order.getStatus() != null) {
                    orderDb.get().setStatus(order.getStatus());
                }
                orderRepository.update(orderDb.get());
                return orderDb.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getOrder(id).map(order -> {
            orderRepository.delete(order);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<Order> findByZone(String zona) {
        return orderRepository.findByZone(zona);
    }

    public List<Order> findBySalesManId(Integer id) {
        return orderRepository.findBySalesManId(id);
    }

    public List<Order> getSalesManIdAndStatus(Integer id, String status) {
        return orderRepository.getSalesManIdAndStatus(id, status);
    }

    public List<Order> RegisterDateAndSalesM (Integer id, String registerDay) throws ParseException{

        return (List<Order>) orderRepository.getRegisterDateAndSalesM(id, registerDay);
    }

}
