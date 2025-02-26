package id.co.swamedia.starter.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

/**
 * Configuration for locale settings in Spring Boot applications.
 * <p>
 * This class defines {@link LocaleResolver} by using
 * {@link AcceptHeaderLocaleResolver}, which will determine the locale based on the
 * the “Accept-Language” header in the HTTP request.
 * </p>
 *
 * @author [Your Name]
 * @version 1.0.0
 * @since [yyyy-mm-dd]
 */
@Configuration
public class LocaleConfig {

    /**
     * A bean that configures {@link LocaleResolver} to use {@link AcceptHeaderLocaleResolver}.
     * <p>
     * The default locale used is {@link Locale#US}.
     * </p>
     *
     * @return an instance of {@link LocaleResolver} with the default US locale.
     */
    @Bean
    public LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        return localeResolver;
    }
}
