package examples.junit;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
/**
 * Parasoft Jtest UTA: Test class for IntegerComparator
 *
 * @see examples.junit.IntegerComparator
 * @author yoneta
 */
public class IntegerComparatorTest
{

    /**
     * Parasoft Jtest UTA: Test for isGreater(int, int)
     *
     * @see examples.junit.IntegerComparator#isGreater(int, int)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testIsGreater() throws Throwable
    {
        // When
        int val1 = 1; // UTA: デフォルト値
        int val2 = 1; // UTA: デフォルト値
        boolean result = IntegerComparator.isGreater(val1, val2);

        // Then - メソッド isGreater(int, int) の結果 のアサーション
        assertFalse(result);

    }
}
