package id.co.swamedia.starter.service;

/**
 * Service interface for retrieving localized messages based on message codes.
 * This interface provides methods to fetch messages with or without arguments.
 *
 * @author [Your Name]
 * @version 1.0.0
 * @since [yyyy-mm-dd]
 */
public interface MessageService {

    String getMessage(String code);
    String getMessage(String code, Object[] args);
}