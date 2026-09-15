package examples.flowanalysis;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;

import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 * Parasoft Jtest UTA: Test class for SQLInjection
 *
 * @see examples.flowanalysis.SQLInjection
 * @author yoneta
 */
public class SQLInjectionTest
{

    /**
     * Parasoft Jtest UTA: Test for auth(HttpServletRequest, Connection)
     *
     * @see examples.flowanalysis.SQLInjection#auth(HttpServletRequest, Connection)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testAuth() throws Throwable
    {
        // Given
        SQLInjection underTest = new SQLInjection();

        // When
        HttpServletRequest request = mock(HttpServletRequest.class);
        String getParameterResult = "getParameterResult"; // UTA: デフォルト値
        String getParameterResult2 = "getParameterResult2"; // UTA: デフォルト値
        when(request.getParameter(nullable(String.class))).thenReturn(getParameterResult, getParameterResult2);
        Connection sqlConnection = mock(Connection.class);
        Statement createStatementResult = mock(Statement.class);
        ResultSet executeQueryResult = mock(ResultSet.class);
        boolean nextResult = true; // UTA: 設定値
        when(executeQueryResult.next()).thenReturn(nextResult);
        when(createStatementResult.executeQuery(nullable(String.class))).thenReturn(executeQueryResult);
        when(sqlConnection.createStatement()).thenReturn(createStatementResult);
        underTest.auth(request, sqlConnection);

    }

    /**
     * Parasoft Jtest UTA: Test for auth(HttpServletRequest, Connection)
     *
     * @see examples.flowanalysis.SQLInjection#auth(HttpServletRequest, Connection)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testAuth2() throws Throwable
    {
        // Given
        SQLInjection underTest = new SQLInjection();

        // When
        HttpServletRequest request = mock(HttpServletRequest.class);
        String getParameterResult = "getParameterResult"; // UTA: デフォルト値
        String getParameterResult2 = "getParameterResult2"; // UTA: デフォルト値
        when(request.getParameter(nullable(String.class))).thenReturn(getParameterResult, getParameterResult2);
        Connection sqlConnection = mock(Connection.class);
        Statement createStatementResult = mock(Statement.class);
        ResultSet executeQueryResult = mock(ResultSet.class);
        when(executeQueryResult.next()).thenThrow(SQLException.class);
        when(createStatementResult.executeQuery(nullable(String.class))).thenReturn(executeQueryResult);
        when(sqlConnection.createStatement()).thenReturn(createStatementResult);
        underTest.auth(request, sqlConnection);

    }

    /**
     * Parasoft Jtest UTA: Test for auth(HttpServletRequest, Connection)
     *
     * @see examples.flowanalysis.SQLInjection#auth(HttpServletRequest, Connection)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testAuth3() throws Throwable
    {
        // Given
        SQLInjection underTest = new SQLInjection();

        // When
        HttpServletRequest request = mock(HttpServletRequest.class);
        String getParameterResult = "getParameterResult"; // UTA: デフォルト値
        String getParameterResult2 = "getParameterResult2"; // UTA: デフォルト値
        when(request.getParameter(nullable(String.class))).thenReturn(getParameterResult, getParameterResult2);
        Connection sqlConnection = mock(Connection.class);
        Statement createStatementResult = mock(Statement.class);
        ResultSet executeQueryResult = mock(ResultSet.class);
        doThrow(SQLException.class).when(executeQueryResult).close();

        when(executeQueryResult.next()).thenThrow(SQLException.class);
        when(createStatementResult.executeQuery(nullable(String.class))).thenReturn(executeQueryResult);
        when(sqlConnection.createStatement()).thenReturn(createStatementResult);
        underTest.auth(request, sqlConnection);

    }

    /**
     * Parasoft Jtest UTA: Test for auth(HttpServletRequest, Connection)
     *
     * @see examples.flowanalysis.SQLInjection#auth(HttpServletRequest, Connection)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testAuth4() throws Throwable
    {
        // Given
        SQLInjection underTest = new SQLInjection();

        // When
        HttpServletRequest request = mock(HttpServletRequest.class);
        String getParameterResult = "getParameterResult"; // UTA: デフォルト値
        String getParameterResult2 = "getParameterResult2"; // UTA: デフォルト値
        when(request.getParameter(nullable(String.class))).thenReturn(getParameterResult, getParameterResult2);
        Connection sqlConnection = mock(Connection.class);
        Statement createStatementResult = mock(Statement.class);
        doThrow(SQLException.class).when(createStatementResult).close();

        ResultSet executeQueryResult = mock(ResultSet.class);
        when(executeQueryResult.next()).thenThrow(SQLException.class);
        when(createStatementResult.executeQuery(nullable(String.class))).thenReturn(executeQueryResult);
        when(sqlConnection.createStatement()).thenReturn(createStatementResult);
        underTest.auth(request, sqlConnection);

    }

}
