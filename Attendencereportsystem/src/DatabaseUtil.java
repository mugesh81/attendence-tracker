import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    // Database URL, username, and password
    private static final String DB_URL = "jdbc:mysql://localhost:3306/SchoolAttendanceDB";
    private static final String USER = "root";      // Replace with your MySQL username
    private static final String PASSWORD = "root";  // Replace with your MySQL password

    /**
     * This method establishes a connection to the database.
     *
     * @return Connection object to the database.
     * @throws SQLException If an SQL error occurs while connecting.
     */
    public static Connection getConnection() throws SQLException {
        try {
            // Establish and return the connection to the database
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            return conn;
        } catch (SQLException e) {
            System.out.println("Error while establishing database connection: " + e.getMessage());
            throw e;  // Re-throw the exception to propagate it
        }
    }

    /**
     * Close the given connection if it's not already closed.
     *
     * @param conn Connection to be closed.
     */
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error while closing the connection: " + e.getMessage());
            }
        }
    }
}
