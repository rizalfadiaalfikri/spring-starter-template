package id.co.swamedia.starter.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * Configure the message source (MessageSource) for Spring Boot applications.
 * <p>
 * This class configures {@link MessageSource} using {@link ReloadableResourceBundleMessageSource},
 * which allows automatic reloading of message resources.
 * </p>
 *
 * @author [Your Name]
 * @version 1.0.0
 * @since [yyyy-mm-dd]
 */
@Configuration
public class MessageSourceConfig {

    /**
     * A bean that configures {@link MessageSource} to handle internationalized (i18n) messages.
     * <p>
     * Messages will be loaded from a resource with path “classpath:i18n/messages”
     * and use UTF-8 encoding.
     * </p>
     *
     * @return an instance of the configured {@link MessageSource}.
     */
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    
}
