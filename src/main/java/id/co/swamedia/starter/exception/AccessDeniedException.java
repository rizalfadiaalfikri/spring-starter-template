package id.co.swamedia.starter.exception;

/**
 * Custom exception to indicate that access has been denied.
 * This exception extends {@link RuntimeException}, allowing it to be thrown
 * without requiring explicit handling.
 *
 * @author [Your Name]
 * @version 1.0.0
 * @since [yyyy-mm-dd]
 */
public class AccessDeniedException  extends RuntimeException {

    /**
     * Constructs a new {@code AccessDeniedException} with the specified detail message.
     *
     * @param message the detail message providing more information about the access denial
     */
    public AccessDeniedException (String message) {
        super(message);
    }
    
}
