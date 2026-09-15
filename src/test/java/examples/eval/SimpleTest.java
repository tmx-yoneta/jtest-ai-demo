package examples.eval;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * Parasoft Jtest UTA: Test class for Simple
 *
 * @see examples.eval.Simple
 * @author yoneta
 */
public class SimpleTest
{

    /**
     * Parasoft Jtest UTA: Test for map(int)
     *
     * @see examples.eval.Simple#map(int)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testMap() throws Throwable
    {
        // When
        int index = 0; // UTA: 設定値
        int result = Simple.map(index);

        // Then - メソッド map(int) の結果 のアサーション
        assertEquals(-1, result);

    }

    /**
     * Parasoft Jtest UTA: Test for map(int)
     *
     * @see examples.eval.Simple#map(int)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testMap2() throws Throwable
    {
        // When
        int index = 2; // UTA: 設定値
        int result = Simple.map(index);

        // Then - メソッド map(int) の結果 のアサーション
        assertEquals(0, result);

    }

    /**
     * Parasoft Jtest UTA: Test for map(int)
     *
     * @see examples.eval.Simple#map(int)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testMap3() throws Throwable
    {
        // When
        int index = 1; // UTA: 設定値
        int result = Simple.map(index);

        // Then - メソッド map(int) の結果 のアサーション
        assertEquals(-2, result);

    }

    /**
     * Parasoft Jtest UTA: Test for startsWith(String, String)
     *
     * @see examples.eval.Simple#startsWith(String, String)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testStartsWith() throws Throwable
    {
        // When
        String str = "str"; // UTA: デフォルト値
        String match = ""; // UTA: 設定値
        boolean result = Simple.startsWith(str, match);

        // Then - メソッド startsWith(String, String) の結果 のアサーション
        assertTrue(result);

    }

    /**
     * Parasoft Jtest UTA: Test for startsWith(String, String)
     *
     * @see examples.eval.Simple#startsWith(String, String)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testStartsWith2() throws Throwable
    {
        // When
        String str = "\u0001"; // UTA: 設定値
        String match = "match"; // UTA: 設定値
        boolean result = Simple.startsWith(str, match);

        // Then - メソッド startsWith(String, String) の結果 のアサーション
        assertFalse(result);

    }

}
