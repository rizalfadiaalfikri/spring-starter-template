package id.co.swamedia.starter.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * Configure validation for Spring Boot applications.
 * <p>
 * This class configures {@link LocalValidatorFactoryBean} to
 * use the configured message source (MessageSource),
 * allowing the use of locally customizable validation messages.
 * </p>
 *
 * @author [Your Name]
 * @version 1.0.0
 * @since [yyyy-mm-dd]
 */
@Configuration
public class ValidationConfig {

    /**
     * Configure {@link LocalValidatorFactoryBean} with a custom message source.
     * <p>
     * This configuration allows validation messages to be retrieved from a message source that is
     * has been defined, thus supporting localization.
     * </p>
     *
     * @param messageSource the message source used for validation.
     * @return the configured {@link LocalValidatorFactoryBean} instance.
     */
    @Bean
    public LocalValidatorFactoryBean validator(MessageSource messageSource) {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource);
        return bean;
    }

}
