package elisa.devtest.endtoend.dao;

import org.h2.jdbcx.JdbcConnectionPool;

import javax.sql.DataSource;

public class DBConnection {

    private static DataSource dataSource = null;

    public static synchronized DataSource getDataSource() {
        String connectionStr = "jdbc:h2:mem:devprod;MODE=Oracle";

        if (System.getProperty("testDb") != null ) {
            connectionStr = "jdbc:h2:mem:devtest;MODE=Oracle";
        }

        if (dataSource == null) {
            try {
                Class.forName("org.h2.Driver");
                dataSource = JdbcConnectionPool.create(connectionStr, "sa", "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return dataSource;
    }
}
