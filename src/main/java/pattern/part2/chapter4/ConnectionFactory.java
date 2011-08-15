package pattern.part2.chapter4;

import java.sql.Connection;

/**
 * Date: 2009-11-8
 * Time: 23:58:33
 */
public class ConnectionFactory {
    private final ThreadLocal<Connection> connections = new ThreadLocal<Connection>();
    //other variables and methods...

    public Connection currentConnection() {
        Connection conn = connections.get();
        if (conn == null) {//if no connection binds to this thread, create a new one

            //create a new connection.
            conn = createConnection();

            //bind this connction to current thread
            connections.set(conn);
        }
        return conn;
    }

    public void setCurrentConnection(Connection conn){
          connections.set(conn);
    }

    public void closeConnection(Connection conn){
          connections.remove();
    }

    private Connection createConnection() {
        //create a connection. Eg, conn = dataSource.getConnection();
        return null;
    }
}