package simplestockjavafx.dao.jdbc.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;


import simplestockjavafx.exceptions.DataBaseException;

public class JDBCSqliteHelper {

    private static final Logger LOG = Logger.getLogger(JDBCSqliteHelper.class
              .getPackage().getName());

    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String URL = "jdbc:sqlite:testJavaFxWithSqlite.sqlite";

    public static Connection getConnector() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL);

        } catch (SQLException e) {
            LOG.error("Error SQL" + e.getMessage());
            throw new DataBaseException("Error SQL", e);

        } catch (ClassNotFoundException e) {
            LOG.error("Error no se encuentra la clase" + e.getMessage());
            throw new DataBaseException("Error no se encuentra la clase", e);
        }

        return conn;

    }


}
