package com.app.quantitymeasurement.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {
    private static final Properties props = new Properties();
    static {
        try (InputStream is = DatabaseConfig.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (is != null) props.load(is);
        } catch (IOException ignored) { }
    }

    // Read from application.properties with sensible defaults.
    public static String getJdbcUrl() {
        return props.getProperty("jdbc.url", "jdbc:mysql://localhost:3306/quantity_measurement?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true");
    }
    public static String getUsername() { return props.getProperty("jdbc.username", "root"); }
    public static String getPassword() { return props.getProperty("jdbc.password", "root"); }
}