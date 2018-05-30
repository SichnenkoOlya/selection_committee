package by.sichnenko.committee.listener;

import by.sichnenko.committee.connection.ConnectionPoolImpl;
import by.sichnenko.committee.exception.ConnectionPoolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * The ContextListener class
 */
@WebListener
public class ContextListener implements ServletContextListener {
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ConnectionPoolImpl.getInstance();

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        try {
            ConnectionPoolImpl.getInstance().disposeConnectionPool();
            Enumeration<Driver> drivers = DriverManager.getDrivers();
            while (drivers.hasMoreElements()) {
                Driver driver = drivers.nextElement();
                DriverManager.deregisterDriver(driver);
            }
        } catch (SQLException e) {
            LOGGER.error("Can't deregister driver", e);

        } catch (ConnectionPoolException e) {
            LOGGER.error("Destroy connection pool error", e);
        }
    }
}
