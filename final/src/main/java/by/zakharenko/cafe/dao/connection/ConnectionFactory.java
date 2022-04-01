package by.zakharenko.cafe.dao.connection;

import by.zakharenko.cafe.dao.exception.DaoException;
import com.mysql.cj.jdbc.Driver;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static final String PROPERTY_FILE = "configuration/database.properties";
    private static final String CONNECTION_URL = "db.url";

    public Connection create() throws DaoException {
        Properties properties = new Properties();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(PROPERTY_FILE);
        try {
            properties.load(inputStream);
            String url = properties.getProperty(CONNECTION_URL);
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(url, properties);
        } catch (SQLException | IOException e) {
            throw new DaoException(e);
        }
    }
}
