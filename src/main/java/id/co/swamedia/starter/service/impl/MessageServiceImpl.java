package id.co.swamedia.starter.service.impl;

import id.co.swamedia.starter.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link MessageService} for retrieving localized messages.
 * This service provides methods to fetch messages based on message codes and
 * optional arguments, supporting internationalization (i18n).
 *
 * @author [Your Name]
 * @version 1.0.0
 * @since [yyyy-mm-dd]
 */
@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    /**
     * MessageSource instance for retrieving localized messages.
     */
    private final MessageSource messageSource;

    /**
     * Retrieves a localized message based on the given message code.
     * The message is resolved using the default locale from {@link LocaleContextHolder}.
     *
     * @param code the message code
     * @return the corresponding localized message as a {@link String}
     */
    @Override
    public String getMessage(String code) {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }

    /**
     * Retrieves a localized message based on the given message code and arguments.
     * Arguments are used for dynamic message formatting (e.g., placeholders).
     * The message is resolved using the default locale from {@link LocaleContextHolder}.
     *
     * @param code the message code
     * @param args an array of arguments to be inserted into the message
     * @return the formatted localized message as a {@link String}
     */
    @Override
    public String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}