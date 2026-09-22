package examples.flowanalysis;

import org.junit.Test;

import static org.junit.Assert.assertNull;
/**
 * Parasoft Jtest UTA: Test class for AlwaysCloseRAFs
 *
 * @see examples.flowanalysis.AlwaysCloseRAFs
 * @author yoneta
 */
public class AlwaysCloseRAFsTest
{

    /**
     * Parasoft Jtest UTA: Test for read(String, String, int)
     *
     * @see examples.flowanalysis.AlwaysCloseRAFs#read(String, String, int)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testRead() throws Throwable
    {
        // Given
        AlwaysCloseRAFs underTest = new AlwaysCloseRAFs();

        // When
        String sFileName = "sFileName"; // UTA: デフォルト値
        String sMode = "sMode"; // UTA: デフォルト値
        int offset = 1; // UTA: デフォルト値
        String result = underTest.read(sFileName, sMode, offset);

        // Then - メソッド read(String, String, int) の結果 のアサーション
        assertNull(result);

    }

    /**
     * Parasoft Jtest UTA: Test for readClose(String, String, int)
     *
     * @see examples.flowanalysis.AlwaysCloseRAFs#readClose(String, String, int)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testReadClose() throws Throwable
    {
        // Given
        AlwaysCloseRAFs underTest = new AlwaysCloseRAFs();

        // When
        String sFileName = "sFileName"; // UTA: デフォルト値
        String sMode = "sMode"; // UTA: デフォルト値
        int offset = 1; // UTA: デフォルト値
        String result = underTest.readClose(sFileName, sMode, offset);

        // Then - メソッド readClose(String, String, int) の結果 のアサーション
        assertNull(result);

    }

}
