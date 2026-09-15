package examples.flowanalysis;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;

import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 * Parasoft Jtest UTA: Test class for FilesInjection
 *
 * @see examples.flowanalysis.FilesInjection
 * @author yoneta
 */
public class FilesInjectionTest
{

    /**
     * Parasoft Jtest UTA: Test for fileNameContentsInjection(HttpServletRequest)
     *
     * @see examples.flowanalysis.FilesInjection#fileNameContentsInjection(HttpServletRequest)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testFileNameContentsInjection() throws Throwable
    {
        // Given
        FilesInjection underTest = new FilesInjection();

        // When
        HttpServletRequest req = mock(HttpServletRequest.class);
        String getParameterResult = "getParameterResult"; // UTA: デフォルト値
        String getParameterResult2 = "getParameterResult2"; // UTA: デフォルト値
        when(req.getParameter(nullable(String.class))).thenReturn(getParameterResult, getParameterResult2);
        underTest.fileNameContentsInjection(req);

    }

}
