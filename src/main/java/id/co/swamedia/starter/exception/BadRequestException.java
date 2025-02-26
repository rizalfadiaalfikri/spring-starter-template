package id.co.swamedia.starter.exception;

/**
 * Custom exception to indicate that a bad request was made.
 * This exception extends {@link RuntimeException}, making it an unchecked exception.
 *
 * @author [Your Name]
 * @version 1.0.0
 * @since [yyyy-mm-dd]
 */
public class BadRequestException extends RuntimeException {

    /**
     * Constructs a new {@code BadRequestException} with the specified detail message.
     *
     * @param message the detail message providing more information about the bad request
     */
    public BadRequestException(String message) {
        super(message);
    }
    
}
