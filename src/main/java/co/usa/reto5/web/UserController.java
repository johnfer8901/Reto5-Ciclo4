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

import co.usa.reto5.model.User;
import co.usa.reto5.service.UserService;

/**
 *
 * @author John F
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    /**
     * 
     */
    private UserService userService;

    @GetMapping("/all")
    /**
     * 
     * @return
     */
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    /**
     * 
     * @param id
     * @return
     */
    public Optional <User> getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    /**
     * 
     * @param user
     * @return
     */
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    /**
     * 
     * @param user
     * @return
     */
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    /**
     * 
     * @param idUser
     * @return
     */
    public boolean delete(@PathVariable("id") int idUser) {
        return userService.delete(idUser);
    }

    @GetMapping("/{email}/{password}")
    /**
     * 
     * @param email
     * @param password
     * @return
     */
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticateUser(email, password);
    }

    @GetMapping("/emailexist/{email}")
    /**
     * 
     * @param email
     * @return
     */
    public boolean emailExists(@PathVariable("email") String email) {
        return userService.emailExists(email);
    }

    @GetMapping("/birthday/{month}")
    public List<User> birthtDayList(@PathVariable("month") String monthBirthtDay) {
        return userService.birthtDayList(monthBirthtDay);
    }
}