package examples.stackmachine;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
/**
 * Parasoft Jtest UTA: Test class for LifoStackMachine
 *
 * @see examples.stackmachine.LifoStackMachine
 * @author yoneta
 */
public class LifoStackMachineTest
{

    /**
     * Parasoft Jtest UTA: Test for push(String)
     *
     * @see examples.stackmachine.LifoStackMachine#push(String)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testPush() throws Throwable
    {
        // Given
        LifoStackMachine underTest = new LifoStackMachine();

        // When
        String value = "value"; // UTA: デフォルト値
        underTest.push(value);

    }

    /**
     * Parasoft Jtest UTA: Test for pushInt(int)
     *
     * @see examples.stackmachine.LifoStackMachine#pushInt(int)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testPushInt() throws Throwable
    {
        // Given
        LifoStackMachine underTest = new LifoStackMachine();

        // When
        int value = 1; // UTA: デフォルト値
        underTest.pushInt(value);

    }

    /**
     * Parasoft Jtest UTA: Test for isInteger(String)
     *
     * @see examples.stackmachine.AbstractStackMachine#isInteger(String)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testIsInteger() throws Throwable
    {
        // Given
        LifoStackMachine underTest = new LifoStackMachine();

        // When
        String string = "string"; // UTA: デフォルト値
        boolean result = underTest.isInteger(string);

        // Then - メソッド isInteger(String) の結果 のアサーション
        assertFalse(result);

    }

}
