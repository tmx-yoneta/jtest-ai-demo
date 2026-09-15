package examples.flowanalysis;

import org.junit.Test;

import examples.flowanalysis.DivisionByZero.Consumer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
/**
 * Parasoft Jtest UTA: Test class for DivisionByZero
 *
 * @see examples.flowanalysis.DivisionByZero
 * @author yoneta
 */
public class DivisionByZeroTest
{

    /**
     * Parasoft Jtest UTA: Test for calculateDiscountedSum(int, float, Consumer)
     *
     * @see examples.flowanalysis.DivisionByZero#calculateDiscountedSum(int, float, Consumer)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testCalculateDiscountedSum() throws Throwable
    {
        // When
        int code = 1; // UTA: 設定値
        float initialSum = 5; // UTA: 設定値
        Consumer person = mock(Consumer.class);
        float result = DivisionByZero.calculateDiscountedSum(code, initialSum, person);

        // Then - メソッド calculateDiscountedSum(int, float, DivisionByZero.Consumer) の結果 のアサーション
        assertEquals(0.0f, result, 0.0);

    }

    /**
     * Parasoft Jtest UTA: Test for calculateDiscountedSum(int, float, Consumer)
     *
     * @see examples.flowanalysis.DivisionByZero#calculateDiscountedSum(int, float, Consumer)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testCalculateDiscountedSum2() throws Throwable
    {
        // When
        int code = 1; // UTA: 設定値
        float initialSum = 6; // UTA: 設定値
        Consumer person = mock(Consumer.class);
        float result = DivisionByZero.calculateDiscountedSum(code, initialSum, person);

        // Then - メソッド calculateDiscountedSum(int, float, DivisionByZero.Consumer) の結果 のアサーション
        assertEquals(5.7f, result, 0.0);

    }

    /**
     * Parasoft Jtest UTA: Test for calculateDiscountedSum(int, float, Consumer)
     *
     * @see examples.flowanalysis.DivisionByZero#calculateDiscountedSum(int, float, Consumer)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testCalculateDiscountedSum3() throws Throwable
    {
        // When
        int code = 1; // UTA: 設定値
        float initialSum = 4; // UTA: 設定値
        Consumer person = mock(Consumer.class);
        float result = DivisionByZero.calculateDiscountedSum(code, initialSum, person);

        // Then - メソッド calculateDiscountedSum(int, float, DivisionByZero.Consumer) の結果 のアサーション
        assertEquals(3.92f, result, 0.0);

    }

    /**
     * Parasoft Jtest UTA: Test for calculateDiscountedSum(int, float, Consumer)
     *
     * @see examples.flowanalysis.DivisionByZero#calculateDiscountedSum(int, float, Consumer)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testCalculateDiscountedSum4() throws Throwable
    {
        // When
        int code = 0; // UTA: 設定値
        float initialSum = 5; // UTA: 設定値
        Consumer person = mock(Consumer.class);
        float result = DivisionByZero.calculateDiscountedSum(code, initialSum, person);

        // Then - メソッド calculateDiscountedSum(int, float, DivisionByZero.Consumer) の結果 のアサーション
        assertEquals(0.0f, result, 0.0);

    }

}
