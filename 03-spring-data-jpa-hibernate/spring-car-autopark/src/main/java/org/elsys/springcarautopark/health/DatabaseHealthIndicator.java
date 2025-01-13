package org.elsys.springcarautopark.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;

@Component
public class DatabaseHealthIndicator implements HealthIndicator {

    private final DataSource dataSource;

    public DatabaseHealthIndicator(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Health health() {
        try (Connection connection = dataSource.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            String databaseName = metaData.getDatabaseProductName();
            String databaseVersion = metaData.getDatabaseProductVersion();

            boolean valid = connection.isValid(1);

            if (valid) {
                return Health.up()
                        .withDetail("database", databaseName)
                        .withDetail("version", databaseVersion)
                        .build();
            } else {
                return Health.down()
                        .withDetail("database", databaseName)
                        .withDetail("version", databaseVersion)
                        .withDetail("error", "Database connection is not valid")
                        .build();
            }
        } catch (Exception e) {
            return Health.down()
                    .withDetail("error", e.getMessage())
                    .build();
        }


    }
}
