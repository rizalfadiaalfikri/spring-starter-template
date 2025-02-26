package id.co.swamedia.starter.monitoring;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Component responsible for monitoring the health of connection.
 * It performs an initial connection check upon startup and allows periodic checks.
 *
 * @author [Your Name]
 * @version 1.0.0
 * @since [yyyy-mm-dd]
 */
@Slf4j
@Component
public class MonitoringConnection {

    private final JdbcTemplate jdbcTemplate;

    private boolean wasConnected = true;

    /**
     * Constructs a MonitoringConnection instance with the provided {@link DataSource}.
     *
     * @param dataSource the data source used to create the {@link JdbcTemplate} for database queries.
     */
    public MonitoringConnection(DataSource dataSource) {
        log.info("🔄 Initializing Connection...");
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * Performs an initial database connection check upon application startup.
     * Logs success if the connection is established, otherwise logs an error.
     */
    @PostConstruct
    public void checkInitialDatabaseConnection() {
        try {
            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            log.info("✅ Connected to MySQL Database successfully.");
        } catch (Exception e) {
            log.error("❌ Failed to connect to MySQL Database: {}", e.getMessage());
        }
    }

    /**
     * Performs a periodic database connection check every 30 seconds
     * Logs when the connection is lost or restored.
     */
    @Scheduled(fixedRate = 30000)
    public void checkPeriodicDatabaseConnection(){
        try {
            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            if (!wasConnected){
                log.info("✅ MySQL Database is back online and accessible.");
                wasConnected = true;
            }
        }catch (Exception e){
            if (wasConnected) {
                log.error("❌ Lost connection to MySQL Database : {}", e.getMessage());
                wasConnected = false;
            }
        }
    }
}
