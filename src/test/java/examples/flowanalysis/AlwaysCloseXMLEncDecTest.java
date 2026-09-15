package examples.flowanalysis;

import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
/**
 * Parasoft Jtest UTA: Test class for AlwaysCloseXMLEncDec
 *
 * @see examples.flowanalysis.AlwaysCloseXMLEncDec
 * @author yoneta
 */
public class AlwaysCloseXMLEncDecTest
{

    /**
     * Parasoft Jtest UTA: Test for read(InputStream)
     *
     * @see examples.flowanalysis.AlwaysCloseXMLEncDec#read(InputStream)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testRead() throws Throwable
    {
        // Given
        AlwaysCloseXMLEncDec underTest = new AlwaysCloseXMLEncDec();

        // When
        InputStream in = mock(InputStream.class);
        Object[] result = underTest.read(in);

        // Then - メソッド read(InputStream) の結果 のアサーション
        assertNotNull(result);
        assertEquals(0, result.length);

    }

    /**
     * Parasoft Jtest UTA: Test for readClose(InputStream)
     *
     * @see examples.flowanalysis.AlwaysCloseXMLEncDec#readClose(InputStream)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testReadClose() throws Throwable
    {
        // Given
        AlwaysCloseXMLEncDec underTest = new AlwaysCloseXMLEncDec();

        // When
        InputStream in = mock(InputStream.class);
        Object[] result = underTest.readClose(in);

        // Then - メソッド readClose(InputStream) の結果 のアサーション
        assertNotNull(result);
        assertEquals(0, result.length);

    }

    /**
     * Parasoft Jtest UTA: Test for store(OutputStream, Object[])
     *
     * @see examples.flowanalysis.AlwaysCloseXMLEncDec#store(OutputStream, Object[])
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testStore() throws Throwable
    {
        // Given
        AlwaysCloseXMLEncDec underTest = new AlwaysCloseXMLEncDec();

        // When
        OutputStream out = mock(OutputStream.class);
        Object[] objects = new Object[1]; // UTA: デフォルト値
        objects[0] = new Object(); // UTA: デフォルト値
        underTest.store(out, objects);

    }

    /**
     * Parasoft Jtest UTA: Test for storeClose(OutputStream, Object[])
     *
     * @see examples.flowanalysis.AlwaysCloseXMLEncDec#storeClose(OutputStream, Object[])
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testStoreClose() throws Throwable
    {
        // Given
        AlwaysCloseXMLEncDec underTest = new AlwaysCloseXMLEncDec();

        // When
        OutputStream out = mock(OutputStream.class);
        Object[] objects = new Object[1]; // UTA: デフォルト値
        objects[0] = new Object(); // UTA: デフォルト値
        underTest.storeClose(out, objects);

    }
}
