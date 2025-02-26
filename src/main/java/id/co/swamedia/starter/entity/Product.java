package id.co.swamedia.starter.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entity class representing a product in the system.
 * This class is mapped to the {@code products} table in the database.
 *
 * @author [Your Name]
 * @version 1.0.0
 * @since [yyyy-mm-dd]
 */
@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String description;
    private Double price;
}