package examples.demo;

import org.junit.Test;
/**
 * Parasoft Jtest UTA: Test class for EmptyCatchDemo
 *
 * @see examples.demo.EmptyCatchDemo
 * @author yoneta
 */
public class EmptyCatchDemoTest
{

    /**
     * Parasoft Jtest UTA: Test for parseNumber(String)
     *
     * @see examples.demo.EmptyCatchDemo#parseNumber(String)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testParseNumber() throws Throwable
    {
        // Given
        EmptyCatchDemo underTest = new EmptyCatchDemo();

        // When
        String value = "value"; // UTA: デフォルト値
        underTest.parseNumber(value);

    }
}
