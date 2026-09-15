package examples.flowanalysis.np;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 * Parasoft Jtest UTA: Test class for DatabaseObject
 *
 * @see examples.flowanalysis.np.DatabaseObject
 * @author yoneta
 */
public class DatabaseObjectTest
{

    /**
     * Parasoft Jtest UTA: Test for getClassName()
     *
     * @see examples.flowanalysis.np.DatabaseObject#getClassName()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testGetClassName() throws Throwable
    {
        // Given
        DatabaseObject underTest = new DatabaseObject();

        // When
        String result = underTest.getClassName();

        // Then - メソッド getClassName() の結果 のアサーション
        assertEquals("examples.flowanalysis.np.DatabaseObject", result);

        // Then - DatabaseObject の this インスタンス のアサーション
        assertNull(underTest.oid);

    }

    /**
     * Parasoft Jtest UTA: Test for getOID()
     *
     * @see examples.flowanalysis.np.DatabaseObject#getOID()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testGetOID() throws Throwable
    {
        // Given
        DatabaseObject underTest = new DatabaseObject();

        // When
        Object result = underTest.getOID();

        // Then - メソッド getOID() の結果 のアサーション
        assertNull(result);

        // Then - DatabaseObject の this インスタンス のアサーション
        assertNull(underTest.oid);

    }

    /**
     * Parasoft Jtest UTA: Test for getObjectFromDatabase(Connection, String, String)
     *
     * @see examples.flowanalysis.np.DatabaseObject#getObjectFromDatabase(Connection, String, String)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testGetObjectFromDatabase() throws Throwable
    {
        // When
        Connection sqlConnection = mock(Connection.class);
        Statement createStatementResult = mock(Statement.class);
        ResultSet executeQueryResult = mock(ResultSet.class);
        String getStringResult = "getStringResult"; // UTA: デフォルト値
        when(executeQueryResult.getString(nullable(String.class))).thenReturn(getStringResult);

        boolean nextResult = true; // UTA: 設定値
        when(executeQueryResult.next()).thenReturn(nextResult);
        when(createStatementResult.executeQuery(nullable(String.class))).thenReturn(executeQueryResult);
        when(sqlConnection.createStatement()).thenReturn(createStatementResult);
        String table = "table"; // UTA: デフォルト値
        String id = "id"; // UTA: デフォルト値
        DatabaseObject result = DatabaseObject.getObjectFromDatabase(sqlConnection, table, id);

        // Then - メソッド getObjectFromDatabase(Connection, String, String) の結果 のアサーション
        assertNotNull(result);
        assertEquals("getStringResult", result.oid);

    }

    /**
     * Parasoft Jtest UTA: Test for getObjectFromDatabase(Connection, String, String)
     *
     * @see examples.flowanalysis.np.DatabaseObject#getObjectFromDatabase(Connection, String, String)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testGetObjectFromDatabase2() throws Throwable
    {
        // When
        Connection sqlConnection = mock(Connection.class);
        Statement createStatementResult = mock(Statement.class);
        ResultSet executeQueryResult = mock(ResultSet.class);
        doThrow(SQLException.class).when(executeQueryResult).close();

        String getStringResult = "getStringResult"; // UTA: デフォルト値
        when(executeQueryResult.getString(nullable(String.class))).thenReturn(getStringResult);

        boolean nextResult = true; // UTA: 設定値
        when(executeQueryResult.next()).thenReturn(nextResult);
        when(createStatementResult.executeQuery(nullable(String.class))).thenReturn(executeQueryResult);
        when(sqlConnection.createStatement()).thenReturn(createStatementResult);
        String table = "table"; // UTA: デフォルト値
        String id = "id"; // UTA: デフォルト値
        DatabaseObject result = DatabaseObject.getObjectFromDatabase(sqlConnection, table, id);

        // Then - メソッド getObjectFromDatabase(Connection, String, String) の結果 のアサーション
        assertNotNull(result);
        assertEquals("getStringResult", result.oid);

    }

    /**
     * Parasoft Jtest UTA: Test for getObjectFromDatabase(Connection, String, String)
     *
     * @see examples.flowanalysis.np.DatabaseObject#getObjectFromDatabase(Connection, String, String)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testGetObjectFromDatabase3() throws Throwable
    {
        // When
        Connection sqlConnection = mock(Connection.class);
        Statement createStatementResult = mock(Statement.class);
        doThrow(SQLException.class).when(createStatementResult).close();

        ResultSet executeQueryResult = mock(ResultSet.class);
        String getStringResult = "getStringResult"; // UTA: デフォルト値
        when(executeQueryResult.getString(nullable(String.class))).thenReturn(getStringResult);

        boolean nextResult = true; // UTA: 設定値
        when(executeQueryResult.next()).thenReturn(nextResult);
        when(createStatementResult.executeQuery(nullable(String.class))).thenReturn(executeQueryResult);
        when(sqlConnection.createStatement()).thenReturn(createStatementResult);
        String table = "table"; // UTA: デフォルト値
        String id = "id"; // UTA: デフォルト値
        DatabaseObject result = DatabaseObject.getObjectFromDatabase(sqlConnection, table, id);

        // Then - メソッド getObjectFromDatabase(Connection, String, String) の結果 のアサーション
        assertNotNull(result);
        assertEquals("getStringResult", result.oid);

    }

}
