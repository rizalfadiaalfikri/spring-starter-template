package id.co.swamedia.starter.exception;

/**
 * Custom exception to indicate authentication failure.
 * This exception extends {@link RuntimeException}, making it an unchecked exception.
 *
 * @author [Your Name]
 * @version 1.0.0
 * @since [yyyy-mm-dd]
 */
public class AuthenticationException extends RuntimeException {

    /**
     * Constructs a new {@code AuthenticationException} with the specified detail message.
     *
     * @param message the detail message providing more information about the authentication failure
     */
    public AuthenticationException(String message) {
        super(message);
    }
    
}
