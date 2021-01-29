import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;

public class main {

    private static final Logger logger = LoggerFactory.getLogger(main.class.getName());
    public static void main(String[] args) {

    try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "20612")) {
            JDBC.newJDBC(connection);
            AddToStore.addToStore(connection);
            FilterSorter.filterSorter(connection);
            AddToBucket.addToBucket(connection);

        } catch (SQLException throwables) {
        logger.error("SQLException");
    }
    }
}

