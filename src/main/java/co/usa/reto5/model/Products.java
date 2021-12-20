package co.usa.reto5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author John F
 */
@Document(collection = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products {
    @Id
    private Integer id;
    private String brand;
    private String category;
    private String presentation;
    private String description;
    private double price;
    private boolean availability = true;    
    private int quantity;
    private String photography;
}
