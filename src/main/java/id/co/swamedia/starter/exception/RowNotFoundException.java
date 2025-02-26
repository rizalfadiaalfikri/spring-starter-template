package id.co.swamedia.starter.exception;

/**
 * Custom exception to indicate that a requested database row was not found.
 * This exception extends {@link RuntimeException}, making it an unchecked exception.
 *
 * @author [Your Name]
 * @version 1.0.0
 * @since [yyyy-mm-dd]
 */
public class RowNotFoundException extends RuntimeException {

    /**
     * Constructs a new {@code RowNotFoundException} with the specified detail message.
     *
     * @param message the detail message providing more information about the missing row
     */
    public RowNotFoundException(String message) {
        super(message);
    }
    
}
