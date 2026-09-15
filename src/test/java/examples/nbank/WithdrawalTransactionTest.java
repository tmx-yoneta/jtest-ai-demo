package examples.nbank;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
/**
 * Parasoft Jtest UTA: Test class for WithdrawalTransaction
 *
 * @see examples.nbank.WithdrawalTransaction
 * @author yoneta
 */
public class WithdrawalTransactionTest
{

    /**
     * Parasoft Jtest UTA: Test for apply(Account)
     *
     * @see examples.nbank.WithdrawalTransaction#apply(Account)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testApply() throws Throwable
    {
        // Given
        int amount = 0; // UTA: 設定値
        WithdrawalTransaction underTest = new WithdrawalTransaction(amount);

        // When
        Account account = mock(Account.class);
        boolean result = underTest.apply(account);

        // Then - メソッド apply(Account) の結果 のアサーション
        assertTrue(result);

    }

    /**
     * Parasoft Jtest UTA: Test for fee()
     *
     * @see examples.nbank.AbstractTransaction#fee()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testFee() throws Throwable
    {
        // Given
        int amount = 0; // UTA: 設定値
        WithdrawalTransaction underTest = new WithdrawalTransaction(amount);

        // When
        int result = underTest.fee();

        // Then - メソッド fee() の結果 のアサーション
        assertEquals(0, result);

    }
}
