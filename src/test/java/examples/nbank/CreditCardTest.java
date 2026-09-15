package examples.nbank;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
/**
 * Parasoft Jtest UTA: Test class for CreditCard
 *
 * @see examples.nbank.CreditCard
 * @author yoneta
 */
public class CreditCardTest
{

    /**
     * Parasoft Jtest UTA: Test for validate(int[], String)
     *
     * @see examples.nbank.CreditCard#validate(int[], String)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testValidate() throws Throwable
    {
        // When
        int[] digLengths = new int[1]; // UTA: デフォルト値
        digLengths[0] = 1; // UTA: デフォルト値
        String input = "input"; // UTA: デフォルト値
        boolean result = CreditCard.validate(digLengths, input);

        // Then - メソッド validate(int[], String) の結果 のアサーション
        assertFalse(result);

    }

    /**
     * Parasoft Jtest UTA: Test for validate(int[], String)
     *
     * @see examples.nbank.CreditCard#validate(int[], String)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testValidate2() throws Throwable
    {
        // When
        int[] digLengths = new int[2]; // UTA: 設定値
        digLengths[0] = 0; // UTA: 設定値
        digLengths[1] = 1;
        String input = ""; // UTA: 設定値
        boolean result = CreditCard.validate(digLengths, input);

        // Then - メソッド validate(int[], String) の結果 のアサーション
        assertFalse(result);

    }

    /**
     * Parasoft Jtest UTA: Test for validate(int[], String)
     *
     * @see examples.nbank.CreditCard#validate(int[], String)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testValidate3() throws Throwable
    {
        // When
        int[] digLengths = new int[1]; // UTA: 設定値
        digLengths[0] = 0; // UTA: 設定値
        String input = "input"; // UTA: デフォルト値
        boolean result = CreditCard.validate(digLengths, input);

        // Then - メソッド validate(int[], String) の結果 のアサーション
        assertFalse(result);

    }

}
