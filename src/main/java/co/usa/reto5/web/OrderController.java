package co.usa.reto5.web;

import java.text.ParseException;
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

import co.usa.reto5.model.Order;
import co.usa.reto5.service.OrderService;

/**
 *
 * @author John F
 */
@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") int id) {
        return orderService.getOrder(id);
    }

    @GetMapping("/zona/{zone}")
    public List<Order> findByZone(@PathVariable("zone") String zone) {
        return orderService.findByZone(zone);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody Order gadget) {
        return orderService.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order gadget) {
        return orderService.update(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return orderService.delete(id);
    }

    @GetMapping("/salesman/{id}")
    public List<Order> findBySalesManId(@PathVariable("id") Integer id) {
        return orderService.findBySalesManId(id);
    }

    @GetMapping("/state/{status}/{id}")
    public List<Order> getSalesManIdAndStatus(@PathVariable("status") String status, @PathVariable("id") Integer id) {
        return orderService.getSalesManIdAndStatus(id, status);
    }

    @GetMapping("/date/{registerDay}/{id}")
    public List<Order> getRegisterDateAndSalesMId(@PathVariable("registerDay") String registerDay, @PathVariable("id") Integer id) throws ParseException {
        return orderService.RegisterDateAndSalesM(id, registerDay);
    }



}