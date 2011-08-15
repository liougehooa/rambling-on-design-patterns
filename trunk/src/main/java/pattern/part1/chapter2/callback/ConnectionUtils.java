package pattern.part1.chapter2.callback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

/**
 * Date: Jan 12, 2011
 * Time: 7:22:33 PM
 *|| */
public class ConnectionUtils {
    //we create a mock connection and a preparedStatement using easymock to show on how callback works

    public static Connection getConnection() throws SQLException {
        Connection conn = createMock(Connection.class);
        PreparedStatement statement = createMock(PreparedStatement.class);
        expect(statement.executeQuery()).andReturn(null);
        expect(conn.prepareStatement((String) anyObject())).andReturn(statement);
        replay(conn);
        replay(statement);
        return conn;
    }
}