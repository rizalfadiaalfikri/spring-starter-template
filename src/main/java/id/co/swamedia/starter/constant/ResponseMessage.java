package id.co.swamedia.starter.constant;

/**
 * A utility class that stores error messages used in applications.
 * <p>
 * This class is final and has a private constructor to prevent instantiation.
 * All messages are defined as static constants.
 * </p>
 *
 * @author [Your Name]
 * @version 1.0.0
 * @since [yyyy-mm-dd]
 */
public class ResponseMessage {

    /**
     * A private constructor to prevent instantiation of this class.
     */
    private ResponseMessage() {
    }

    public static final String ERR_DUPLICATE_KEY_EXCEPTION = "Data already exists. Duplicate entry is not allowed.";
    public static final String ERR_ROW_NOT_FOUND_EXCEPTION = "The requested resource was not found.";
    public static final String ERR_METHOD_ARGUMENT_NOT_VALID_EXCEPTION = "Validation failed for the provided input.";
    public static final String ERR_BAD_REQUEST_EXCEPTION = "The request could not be understood or was missing required parameters.";
    public static final String ERR_INTERNAL_SERVER_EXCEPTION = "An unexpected error occurred. Please try again later.";
    public static final String ERR_AUTHENTICATION_EXCEPTION = "Authentication failed. Please provide valid credentials.";
    public static final String ERR_BAD_CREDENTIALS_EXCEPTION = "Invalid username or password. The username or password you provided is incorrect.";
    public static final String ERR_ACCESS_DENIED_EXCEPTION = " Access denied. You do not have permission to access this resource.";
    

}
