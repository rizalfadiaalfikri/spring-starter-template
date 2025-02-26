package id.co.swamedia.starter.exception;

/**
 * Custom exception to indicate that authentication failed due to invalid credentials.
 * This exception extends {@link RuntimeException}, making it an unchecked exception.
 *
 * @author [Your Name]
 * @version 1.0.0
 * @since [yyyy-mm-dd]
 */
public class BadCredentialsException extends RuntimeException {

    /**
     * Constructs a new {@code BadCredentialsException} with the specified detail message.
     *
     * @param message the detail message providing more information about the invalid credentials
     */
    public BadCredentialsException(String message) {
        super(message);
    }
    
}
