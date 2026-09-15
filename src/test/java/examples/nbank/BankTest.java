package examples.nbank;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 * Parasoft Jtest UTA: Test class for Bank
 *
 * @see examples.nbank.Bank
 * @author yoneta
 */
public class BankTest
{

    /**
     * Parasoft Jtest UTA: Test for addAccount(Account)
     *
     * @see examples.nbank.Bank#addAccount(Account)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testAddAccount() throws Throwable
    {
        // Given
        Bank underTest = new Bank();
        Map<String, Account> _accountsValue = new HashMap<String, Account>(); // UTA: デフォルト値
        setPrivateField(underTest, Bank.class, "_accounts", _accountsValue);

        // When
        Account account = mock(Account.class);
        Boolean result = underTest.addAccount(account);

        // Then - メソッド addAccount(Account) の結果 のアサーション
        assertNotNull(result);
        assertTrue(result);

    }

    /**
     * Parasoft Jtest UTA: private フィールド _accounts を設定するヘルパー メソッド
     */
    private static <T> void setPrivateField(Object object, Class<?> fieldClass, String fieldName, T value)
    {
        try {
            Field field = fieldClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(object, value);
        } catch (NoSuchFieldException e) {
            throw (AssertionError) new AssertionError("No such field found").initCause(e);
        } catch (IllegalAccessException e) {
            throw (AssertionError) new AssertionError("Unable to access the specified private field").initCause(e);
        } catch (SecurityException e) {
            throw (AssertionError) new AssertionError("There was a security exception when attempting to access a private field").initCause(e);
        }
    }

    /**
     * Parasoft Jtest UTA: Test for addAccount(Account)
     *
     * @see examples.nbank.Bank#addAccount(Account)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testAddAccount2() throws Throwable
    {
        // Given
        Bank underTest = new Bank();
        Map<String, Account> _accountsValue = new HashMap<String, Account>(); // UTA: デフォルト値
        setPrivateField(underTest, Bank.class, "_accounts", _accountsValue);

        // When
        Account account = mock(Account.class);
        String getIDResult = "getIDResult"; // UTA: デフォルト値
        when(account.getID()).thenReturn(getIDResult);
        Boolean result = underTest.addAccount(account);

        // Then - メソッド addAccount(Account) の結果 のアサーション
        assertNotNull(result);
        assertTrue(result);

    }

    /**
     * Parasoft Jtest UTA: Test for closeAccounts(List)
     *
     * @see examples.nbank.Bank#closeAccounts(List)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testCloseAccounts() throws Throwable
    {
        // Given
        Bank underTest = new Bank();

        // When
        List<Account> list = null; // UTA: 設定値
        underTest.closeAccounts(list);

    }

    /**
     * Parasoft Jtest UTA: Test for closeAccounts(List)
     *
     * @see examples.nbank.Bank#closeAccounts(List)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testCloseAccounts2() throws Throwable
    {
        // Given
        Bank underTest = new Bank();
        Map<String, Account> _accountsValue = new HashMap<String, Account>(); // UTA: デフォルト値
        String key = "key"; // UTA: デフォルト値
        Account value = mock(Account.class);
        _accountsValue.put(key, value);
        setPrivateField(underTest, Bank.class, "_accounts", _accountsValue);

        // When
        List<Account> list = new ArrayList<Account>(); // UTA: デフォルト値
        Account item = mock(Account.class);
        String getIDResult = "getIDResult"; // UTA: デフォルト値
        when(item.getID()).thenReturn(getIDResult);
        list.add(item);
        underTest.closeAccounts(list);

    }

    /**
     * Parasoft Jtest UTA: Test for endMaintenance()
     *
     * @see examples.nbank.Bank#endMaintenance()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testEndMaintenance() throws Throwable
    {
        // Given
        Bank underTest = new Bank();

        // When
        underTest.endMaintenance();

    }

    /**
     * Parasoft Jtest UTA: Test for getAccount(String, String)
     *
     * @see examples.nbank.Bank#getAccount(String, String)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testGetAccount() throws Throwable
    {
        // Given
        Bank underTest = new Bank();
        Map<String, Account> _accountsValue = new HashMap<String, Account>(); // UTA: デフォルト値
        setPrivateField(underTest, Bank.class, "_accounts", _accountsValue);

        // When
        String id = "id"; // UTA: デフォルト値
        String name = "name"; // UTA: デフォルト値
        Account result = underTest.getAccount(id, name);

        // Then - メソッド getAccount(String, String) の結果 のアサーション
        assertNull(result);

    }

    /**
     * Parasoft Jtest UTA: Test for getAccount(String, String)
     *
     * @see examples.nbank.Bank#getAccount(String, String)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testGetAccount2() throws Throwable
    {
        // Given
        Bank underTest = new Bank();
        Map<String, Account> _accountsValue = new HashMap<String, Account>(); // UTA: デフォルト値
        String key = "key"; // UTA: デフォルト値
        Account value = mock(Account.class);
        _accountsValue.put(key, value);
        setPrivateField(underTest, Bank.class, "_accounts", _accountsValue);

        // When
        String id = "id"; // UTA: デフォルト値
        String name = "name"; // UTA: デフォルト値
        Account result = underTest.getAccount(id, name);

        // Then - メソッド getAccount(String, String) の結果 のアサーション
        assertNull(result);

    }

    /**
     * Parasoft Jtest UTA: Test for isMaintenanceMode()
     *
     * @see examples.nbank.Bank#isMaintenanceMode()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testIsMaintenanceMode() throws Throwable
    {
        // Given
        Bank underTest = new Bank();

        // When
        Boolean result = underTest.isMaintenanceMode();

        // Then - メソッド isMaintenanceMode() の結果 のアサーション
        assertNotNull(result);
        assertFalse(result);

    }

    /**
     * Parasoft Jtest UTA: Test for setAccountsLimit(Integer)
     *
     * @see examples.nbank.Bank#setAccountsLimit(Integer)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testSetAccountsLimit() throws Throwable
    {
        // When
        Integer limit = 1; // UTA: デフォルト値
        Bank.setAccountsLimit(limit);

    }

    /**
     * Parasoft Jtest UTA: Test for startMaintenance()
     *
     * @see examples.nbank.Bank#startMaintenance()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testStartMaintenance() throws Throwable
    {
        // Given
        Bank underTest = new Bank();

        // When
        underTest.startMaintenance();

    }
}
