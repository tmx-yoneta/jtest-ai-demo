package examples.nbank;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 * Parasoft Jtest UTA: Test class for LogAccountInfo
 *
 * @see examples.nbank.LogAccountInfo
 * @author yoneta
 */
public class LogAccountInfoTest
{

    /**
     * Parasoft Jtest UTA: Test for log(Account)
     *
     * @see examples.nbank.LogAccountInfo#log(Account)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testLog() throws Throwable
    {
        // Given
        LogAccountInfo underTest = new LogAccountInfo();

        // When
        Account account = mock(Account.class);
        String getIDResult = "getIDResult"; // UTA: デフォルト値
        when(account.getID()).thenReturn(getIDResult);
        boolean result = underTest.log(account);

        // Then - メソッド log(Account) の結果 のアサーション
        assertTrue(result);

    }

}
