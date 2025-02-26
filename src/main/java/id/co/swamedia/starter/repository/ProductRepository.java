package id.co.swamedia.starter.repository;

import id.co.swamedia.starter.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing {@link Product} entities.
 * This interface provides CRUD operations and query methods
 * for interacting with the {@code products} table in the database.
 *
 * @author [Your Name]
 * @version 1.0.0
 * @since [yyyy-mm-dd]
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}