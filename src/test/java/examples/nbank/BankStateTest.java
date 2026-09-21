package examples.nbank;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Parasoft Jtest UTA: Test class for BankState
 *
 * @see examples.nbank.BankState
 * @author yoneta
 */
public class BankStateTest
{

    /**
     * Parasoft Jtest UTA: Test for endMaintenance()
     *
     * @see examples.nbank.BankState#endMaintenance()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testEndMaintenance() throws Throwable
    {
        // When
        BankState.endMaintenance();

    }

    /**
     * Parasoft Jtest UTA: Test for isMaintenanceMode()
     *
     * @see examples.nbank.BankState#isMaintenanceMode()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testIsMaintenanceMode() throws Throwable
    {
        // When
        System.clearProperty("demo-bank-maintanance");
        Boolean result = BankState.isMaintenanceMode();

        // Then - メソッド isMaintenanceMode() の結果 のアサーション
        assertNotNull(result);
        assertFalse(result);

    }

    /**
     * Parasoft Jtest UTA: Test for startMaintenance()
     *
     * @see examples.nbank.BankState#startMaintenance()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testStartMaintenance() throws Throwable
    {
        // When
        BankState.startMaintenance();

    }

    /**
     * Parasoft Jtest UTA: Test for endMaintenance()
     *
     * @see examples.nbank.BankState#endMaintenance()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testEndMaintenance2() throws Throwable
    {
        // When
        BankState.endMaintenance();

    }

    /**
     * Parasoft Jtest UTA: Test for isMaintenanceMode()
     *
     * @see examples.nbank.BankState#isMaintenanceMode()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testIsMaintenanceMode2() throws Throwable
    {
        // When
        Boolean result = BankState.isMaintenanceMode();

        // Then - メソッド isMaintenanceMode() の結果 のアサーション
        assertNotNull(result);
        assertTrue(result);

    }

    /**
     * Parasoft Jtest UTA: Test for startMaintenance()
     *
     * @see examples.nbank.BankState#startMaintenance()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testStartMaintenance2() throws Throwable
    {
        // When
        BankState.startMaintenance();

    }
}
