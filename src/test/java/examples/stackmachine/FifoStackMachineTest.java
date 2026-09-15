package examples.stackmachine;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
/**
 * Parasoft Jtest UTA: Test class for FifoStackMachine
 *
 * @see examples.stackmachine.FifoStackMachine
 * @author yoneta
 */
public class FifoStackMachineTest
{

    /**
     * Parasoft Jtest UTA: Test for push(String)
     *
     * @see examples.stackmachine.FifoStackMachine#push(String)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testPush() throws Throwable
    {
        // Given
        FifoStackMachine underTest = new FifoStackMachine();

        // When
        String value = "value"; // UTA: デフォルト値
        underTest.push(value);

    }

    /**
     * Parasoft Jtest UTA: Test for pushInt(int)
     *
     * @see examples.stackmachine.FifoStackMachine#pushInt(int)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testPushInt() throws Throwable
    {
        // Given
        FifoStackMachine underTest = new FifoStackMachine();

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
        FifoStackMachine underTest = new FifoStackMachine();

        // When
        String string = "string"; // UTA: デフォルト値
        boolean result = underTest.isInteger(string);

        // Then - メソッド isInteger(String) の結果 のアサーション
        assertFalse(result);

    }

}
