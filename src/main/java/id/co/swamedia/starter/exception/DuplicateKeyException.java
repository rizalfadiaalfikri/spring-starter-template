package id.co.swamedia.starter.exception;

/**
 * Custom exception to indicate that a duplicate key violation has occurred.
 * This exception extends {@link RuntimeException}, making it an unchecked exception.
 *
 * @author [Your Name]
 * @version 1.0.0
 * @since [yyyy-mm-dd]
 */
public class DuplicateKeyException extends RuntimeException {

    /**
     * Constructs a new {@code DuplicateKeyException} with the specified detail message.
     *
     * @param message the detail message providing more information about the duplicate key violation
     */
    public DuplicateKeyException(String message) {
        super(message);
    }

}
