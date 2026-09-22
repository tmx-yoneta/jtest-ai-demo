package examples.nbank;

import java.io.IOException;
import java.lang.reflect.Field;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 * Parasoft Jtest UTA: Test class for Account
 *
 * @see examples.nbank.Account
 * @author yoneta
 */
public class AccountTest
{

    /**
     * Parasoft Jtest UTA: Test for apply(ITransaction)
     *
     * @see examples.nbank.Account#apply(ITransaction)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testApply() throws Throwable
    {
        // Given
        Customer customer = mock(Customer.class);
        int initial_balance = 0; // UTA: 設定値
        Account underTest = new Account(customer, initial_balance);

        // When
        ITransaction transaction = mock(ITransaction.class);
        boolean applyResult = false; // UTA: 設定値
        when(transaction.apply(nullable(Account.class))).thenReturn(applyResult);
        underTest.apply(transaction);

        // Then - Account の this インスタンス のアサーション
        assertNotNull(underTest.getCustomer());
        assertEquals(0, underTest.getBalance());
        assertEquals("silver", underTest.getStatus());

    }

    /**
     * Parasoft Jtest UTA: Test for apply(ITransaction)
     *
     * @see examples.nbank.Account#apply(ITransaction)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testApply2() throws Throwable
    {
        // Given
        Customer customer = mock(Customer.class);
        int initial_balance = 0; // UTA: 設定値
        Account underTest = new Account(customer, initial_balance);

        // When
        ITransaction transaction = mock(ITransaction.class);
        boolean applyResult = true; // UTA: 設定値
        when(transaction.apply(nullable(Account.class))).thenReturn(applyResult);
        underTest.apply(transaction);

        // Then - Account の this インスタンス のアサーション
        assertNotNull(underTest.getCustomer());
        assertEquals(0, underTest.getBalance());
        assertEquals("silver", underTest.getStatus());

    }

    /**
     * Parasoft Jtest UTA: Test for getBalance()
     *
     * @see examples.nbank.Account#getBalance()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testGetBalance() throws Throwable
    {
        // Given
        Customer customer = mock(Customer.class);
        int initial_balance = 0; // UTA: 設定値
        Account underTest = new Account(customer, initial_balance);

        // When
        int result = underTest.getBalance();

        // Then - メソッド getBalance() の結果 のアサーション
        assertEquals(0, result);

        // Then - Account の this インスタンス のアサーション
        assertNotNull(underTest.getCustomer());
        assertEquals("silver", underTest.getStatus());

    }

    /**
     * Parasoft Jtest UTA: Test for getCustomer()
     *
     * @see examples.nbank.Account#getCustomer()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testGetCustomer() throws Throwable
    {
        // Given
        Customer customer = mock(Customer.class);
        int initial_balance = 0; // UTA: 設定値
        Account underTest = new Account(customer, initial_balance);

        // When
        Customer result = underTest.getCustomer();

        // Then - メソッド getCustomer() の結果 のアサーション
        assertNotNull(result);

        // Then - Account の this インスタンス のアサーション
        assertEquals(0, underTest.getBalance());
        assertEquals("silver", underTest.getStatus());

    }

    /**
     * Parasoft Jtest UTA: Test for getID()
     *
     * @see examples.nbank.Account#getID()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testGetID() throws Throwable
    {
        // Given
        Customer customer = mock(Customer.class);
        int initial_balance = 0; // UTA: 設定値
        Account underTest = new Account(customer, initial_balance);

        // When
        String result = underTest.getID();

        // Then - メソッド getID() の結果 のアサーション
        assertNull(result);

        // Then - Account の this インスタンス のアサーション
        assertNotNull(underTest.getCustomer());
        assertEquals(0, underTest.getBalance());
        assertEquals("silver", underTest.getStatus());

    }

    /**
     * Parasoft Jtest UTA: Test for getStatus()
     *
     * @see examples.nbank.Account#getStatus()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testGetStatus() throws Throwable
    {
        // Given
        Customer customer = mock(Customer.class);
        int initial_balance = 0; // UTA: 設定値
        Account underTest = new Account(customer, initial_balance);

        // When
        String result = underTest.getStatus();

        // Then - メソッド getStatus() の結果 のアサーション
        assertEquals("silver", result);

        // Then - Account の this インスタンス のアサーション
        assertNotNull(underTest.getCustomer());
        assertEquals(0, underTest.getBalance());

    }

    /**
     * Parasoft Jtest UTA: Test for isOverdrawn(int)
     *
     * @see examples.nbank.Account#isOverdrawn(int)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testIsOverdrawn() throws Throwable
    {
        // Given
        Customer customer = mock(Customer.class);
        int initial_balance = 0; // UTA: 設定値
        Account underTest = new Account(customer, initial_balance);

        // When
        int balance = 0; // UTA: 設定値
        boolean result = underTest.isOverdrawn(balance);

        // Then - メソッド isOverdrawn(int) の結果 のアサーション
        assertFalse(result);

        // Then - Account の this インスタンス のアサーション
        assertNotNull(underTest.getCustomer());
        assertEquals(0, underTest.getBalance());
        assertEquals("silver", underTest.getStatus());

    }

    /**
     * Parasoft Jtest UTA: Test for isOverdrawn(int)
     *
     * @see examples.nbank.Account#isOverdrawn(int)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testIsOverdrawn2() throws Throwable
    {
        // Given
        Customer customer = mock(Customer.class);
        String getNameResult = "getNameResult"; // UTA: デフォルト値
        when(customer.getName()).thenReturn(getNameResult);

        String getSSNResult = "getSSNResult"; // UTA: デフォルト値
        when(customer.getSSN()).thenReturn(getSSNResult);
        int initial_balance = 0; // UTA: 設定値
        Account underTest = new Account(customer, initial_balance);
        String _accountStatusValue = "_accountStatusValue"; // UTA: デフォルト値
        setPrivateField(underTest, Account.class, "_accountStatus", _accountStatusValue);

        // When
        int balance = -10000; // UTA: 設定値
        boolean result = underTest.isOverdrawn(balance);

        // Then - メソッド isOverdrawn(int) の結果 のアサーション
        assertTrue(result);

        // Then - Account の this インスタンス のアサーション
        assertNotNull(underTest.getCustomer());
        assertEquals(0, underTest.getBalance());
        assertEquals("_accountStatusValue", underTest.getStatus());

    }

    /**
     * Parasoft Jtest UTA: private フィールド _accountStatus を設定するヘルパー メソッド
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
     * Parasoft Jtest UTA: Test for isOverdrawn(int)
     *
     * @see examples.nbank.Account#isOverdrawn(int)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testIsOverdrawn3() throws Throwable
    {
        // Given
        Customer customer = mock(Customer.class);
        String getNameResult = "getNameResult"; // UTA: デフォルト値
        when(customer.getName()).thenReturn(getNameResult);

        String getSSNResult = "getSSNResult"; // UTA: デフォルト値
        when(customer.getSSN()).thenReturn(getSSNResult);
        int initial_balance = 0; // UTA: 設定値
        Account underTest = new Account(customer, initial_balance);
        String _accountStatusValue = "_accountStatusValue"; // UTA: デフォルト値
        setPrivateField(underTest, Account.class, "_accountStatus", _accountStatusValue);

        // When
        int balance = -1; // UTA: 設定値
        boolean result = underTest.isOverdrawn(balance);

        // Then - メソッド isOverdrawn(int) の結果 のアサーション
        assertTrue(result);

        // Then - Account の this インスタンス のアサーション
        assertNotNull(underTest.getCustomer());
        assertEquals(0, underTest.getBalance());
        assertEquals("_accountStatusValue", underTest.getStatus());

    }

    /**
     * Parasoft Jtest UTA: Test for reportToCreditAgency(ICreditAgency)
     *
     * @see examples.nbank.Account#reportToCreditAgency(ICreditAgency)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testReportToCreditAgency() throws Throwable
    {
        // Given
        Customer customer = mock(Customer.class);
        int initial_balance = 0; // UTA: 設定値
        Account underTest = new Account(customer, initial_balance);

        // When
        ICreditAgency agency = mock(ICreditAgency.class);
        boolean result = underTest.reportToCreditAgency(agency);

        // Then - メソッド reportToCreditAgency(ICreditAgency) の結果 のアサーション
        assertFalse(result);

        // Then - Account の this インスタンス のアサーション
        assertNotNull(underTest.getCustomer());
        assertEquals(0, underTest.getBalance());
        assertEquals("silver", underTest.getStatus());

    }

    /**
     * Parasoft Jtest UTA: Test for reportToCreditAgency(ICreditAgency)
     *
     * @see examples.nbank.Account#reportToCreditAgency(ICreditAgency)
     * @author yoneta
     */
    @Test(timeout = 5000, expected = ConnectionException.class)
    public void testReportToCreditAgency2() throws Throwable
    {
        // Given
        Customer customer = mock(Customer.class);
        int initial_balance = 0; // UTA: 設定値
        Account underTest = new Account(customer, initial_balance);

        // When
        ICreditAgency agency = mock(ICreditAgency.class);
        when(agency.report(nullable(Account.class))).thenThrow(IOException.class);
        underTest.reportToCreditAgency(agency);

    }

    /**
     * Parasoft Jtest UTA: Test for setBalance(int)
     *
     * @see examples.nbank.Account#setBalance(int)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testSetBalance() throws Throwable
    {
        // Given
        Customer customer = mock(Customer.class);
        int initial_balance = 0; // UTA: 設定値
        Account underTest = new Account(customer, initial_balance);

        // When
        int balance = 4999; // UTA: 設定値
        underTest.setBalance(balance);

        // Then - Account の this インスタンス のアサーション
        assertNotNull(underTest.getCustomer());
        assertEquals(4999, underTest.getBalance());
        assertEquals("silver", underTest.getStatus());

    }

    /**
     * Parasoft Jtest UTA: Test for setBalance(int)
     *
     * @see examples.nbank.Account#setBalance(int)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testSetBalance2() throws Throwable
    {
        // Given
        Customer customer = mock(Customer.class);
        int initial_balance = 0; // UTA: 設定値
        Account underTest = new Account(customer, initial_balance);

        // When
        int balance = 5000; // UTA: 設定値
        underTest.setBalance(balance);

        // Then - Account の this インスタンス のアサーション
        assertNotNull(underTest.getCustomer());
        assertEquals(5000, underTest.getBalance());
        assertEquals("gold", underTest.getStatus());

    }

    /**
     * Parasoft Jtest UTA: Test for setBalance(int)
     *
     * @see examples.nbank.Account#setBalance(int)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testSetBalance3() throws Throwable
    {
        // Given
        Customer customer = mock(Customer.class);
        int initial_balance = 0; // UTA: 設定値
        Account underTest = new Account(customer, initial_balance);

        // When
        int balance = 10000; // UTA: 設定値
        underTest.setBalance(balance);

        // Then - Account の this インスタンス のアサーション
        assertNotNull(underTest.getCustomer());
        assertEquals(10000, underTest.getBalance());
        assertEquals("platinum", underTest.getStatus());

    }

    /**
     * Parasoft Jtest UTA: Test for getCustomer()
     *
     * @see examples.nbank.Account#getCustomer()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testGetCustomer2() throws Throwable
    {
        // Given
        Customer customer = mock(Customer.class);
        int initial_balance = 0; // UTA: 設定値
        Account underTest = new Account(customer, initial_balance);

        // When
        Customer result = underTest.getCustomer();

    }

    /**
     * Parasoft Jtest UTA: Test for getStatus()
     *
     * @see examples.nbank.Account#getStatus()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testGetStatus2() throws Throwable
    {
        // Given
        Customer customer = mock(Customer.class);
        int initial_balance = 0; // UTA: 設定値
        Account underTest = new Account(customer, initial_balance);

        // When
        String result = underTest.getStatus();

        // Then - メソッド getStatus() の結果 のアサーション
        assertEquals("silver", result);

        // Then - Account の this インスタンス のアサーション
        assertNotNull(underTest.getCustomer());
        assertEquals(0, underTest.getBalance());

    }

}
