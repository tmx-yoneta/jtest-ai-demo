package examples.nbank;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 * Parasoft Jtest UTA: Test class for DepositTransaction
 *
 * @see examples.nbank.DepositTransaction
 * @author yoneta
 */
public class DepositTransactionTest
{

    /**
     * Parasoft Jtest UTA: Test for apply(Account)
     *
     * @see examples.nbank.DepositTransaction#apply(Account)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testApply() throws Throwable
    {
        // Given
        int amount = 1; // UTA: デフォルト値
        DepositTransaction underTest = new DepositTransaction(amount);

        // When
        Account account = mock(Account.class);
        Customer getCustomerResult = mock(Customer.class);
        String getNameResult = ""; // UTA: 設定値
        when(getCustomerResult.getName()).thenReturn(getNameResult);
        when(account.getCustomer()).thenReturn(getCustomerResult);
        boolean result = underTest.apply(account);

        // Then - メソッド apply(Account) の結果 のアサーション
        assertTrue(result);

    }

    /**
     * Parasoft Jtest UTA: Test for apply(Account)
     *
     * @see examples.nbank.DepositTransaction#apply(Account)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testApply2() throws Throwable
    {
        // Given
        int amount = 1; // UTA: 設定値
        DepositTransaction underTest = new DepositTransaction(amount);

        // When
        Account account = mock(Account.class);
        int getBalanceResult = 100; // UTA: 設定値
        when(account.getBalance()).thenReturn(getBalanceResult);

        Customer getCustomerResult = mock(Customer.class);
        String getNameResult = "John Hacker"; // UTA: 設定値
        when(getCustomerResult.getName()).thenReturn(getNameResult);
        when(account.getCustomer()).thenReturn(getCustomerResult);
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
        int amount = 1; // UTA: デフォルト値
        DepositTransaction underTest = new DepositTransaction(amount);

        // When
        int result = underTest.fee();

        // Then - メソッド fee() の結果 のアサーション
        assertEquals(0, result);

    }
}
