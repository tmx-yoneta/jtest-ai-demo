package examples.flowanalysis;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 * Parasoft Jtest UTA: Test class for WebApplication
 *
 * @see examples.flowanalysis.WebApplication
 * @author yoneta
 */
public class WebApplicationTest
{

    /**
     * Parasoft Jtest UTA: Test for doGet(HttpServletRequest, HttpServletResponse)
     *
     * @see examples.flowanalysis.WebApplication#doGet(HttpServletRequest, HttpServletResponse)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testDoGet() throws Throwable
    {
        // Given
        WebApplication underTest = new WebApplication();

        // When
        HttpServletRequest req = mock(HttpServletRequest.class);
        String getParameterResult = "getParameterResult"; // UTA: デフォルト値
        when(req.getParameter(nullable(String.class))).thenReturn(getParameterResult);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        ServletOutputStream getOutputStreamResult = mock(ServletOutputStream.class);
        when(resp.getOutputStream()).thenReturn(getOutputStreamResult);
        underTest.doGet(req, resp);

    }

    /**
     * Parasoft Jtest UTA: Test for doPost(HttpServletRequest, HttpServletResponse)
     *
     * @see examples.flowanalysis.WebApplication#doPost(HttpServletRequest, HttpServletResponse)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testDoPost() throws Throwable
    {
        // Given
        WebApplication underTest = new WebApplication();

        // When
        HttpServletRequest req = mock(HttpServletRequest.class);
        String getParameterResult = "getParameterResult"; // UTA: デフォルト値
        when(req.getParameter(nullable(String.class))).thenReturn(getParameterResult);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        ServletOutputStream getOutputStreamResult = mock(ServletOutputStream.class);
        when(resp.getOutputStream()).thenReturn(getOutputStreamResult);
        underTest.doPost(req, resp);

    }

}
