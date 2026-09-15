package examples.metrics;

import java.io.File;
import java.util.Collection;
import java.util.Set;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Parasoft Jtest UTA: Test class for MetricsExample
 *
 * @see examples.metrics.MetricsExample
 * @author yoneta
 */
public class MetricsExampleTest
{

    /**
     * Parasoft Jtest UTA: Test for collectErrorCodesFromFiles(File[])
     *
     * @see examples.metrics.MetricsExample#collectErrorCodesFromFiles(File[])
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testCollectErrorCodesFromFiles() throws Throwable
    {
        // Given
        MetricsExample underTest = new MetricsExample();

        // When
        File[] aFile = null; // UTA: 設定値
        Set<Integer> result = underTest.collectErrorCodesFromFiles(aFile);

        // Then - メソッド collectErrorCodesFromFiles(File[]) の結果 のアサーション
        assertNotNull(result);
        assertTrue(result instanceof Collection);
        assertEquals(0, ((Collection<?>) result).size());

    }

    /**
     * Parasoft Jtest UTA: Test for collectErrorCodesFromFiles(File[])
     *
     * @see examples.metrics.MetricsExample#collectErrorCodesFromFiles(File[])
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testCollectErrorCodesFromFiles2() throws Throwable
    {
        // Given
        MetricsExample underTest = new MetricsExample();

        // When
        File[] aFile = new File[1]; // UTA: デフォルト値
        aFile[0] = File.createTempFile("aFile[0]", null); // UTA: デフォルト値
        aFile[0].deleteOnExit();
        Set<Integer> result = underTest.collectErrorCodesFromFiles(aFile);

        // Then - メソッド collectErrorCodesFromFiles(File[]) の結果 のアサーション
        assertNotNull(result);
        assertTrue(result instanceof Collection);
        assertEquals(0, ((Collection<?>) result).size());

    }

}
