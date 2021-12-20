package co.usa.reto5.repository.crud;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

import co.usa.reto5.model.User;


public interface UserCrudRepository extends MongoRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
    Optional<User> findTopByOrderByIdDesc();
    List<User> findByMonthBirthtDay(String monthBirthtDay);
    
}
