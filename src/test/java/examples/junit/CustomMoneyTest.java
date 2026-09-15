package examples.junit;

import java.lang.reflect.Field;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 * Parasoft Jtest UTA: Test class for CustomMoney
 *
 * @see examples.junit.CustomMoney
 * @author yoneta
 */
public class CustomMoneyTest
{

    /**
     * Parasoft Jtest UTA: Test for changeCurrency(String)
     *
     * @see examples.junit.CustomMoney#changeCurrency(String)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testChangeCurrency() throws Throwable
    {
        // Given
        int amount = 1; // UTA: デフォルト値
        String currency = "currency"; // UTA: デフォルト値
        CustomMoney underTest = new CustomMoney(amount, currency);

        // When
        String currency2 = "currency2"; // UTA: デフォルト値
        underTest.changeCurrency(currency2);

        // Then - CustomMoney の this インスタンス のアサーション
        assertEquals(1, underTest.amount());
        assertEquals("currency2", underTest.fCurrency);

    }

    /**
     * Parasoft Jtest UTA: Test for add(IMoney)
     *
     * @see examples.junit.Money#add(IMoney)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testAdd() throws Throwable
    {
        // Given
        int amount = 1; // UTA: デフォルト値
        String currency = "currency"; // UTA: デフォルト値
        CustomMoney underTest = new CustomMoney(amount, currency);

        // When
        IMoney m = mock(IMoney.class);
        IMoney result = underTest.add(m);

        // Then - メソッド add(IMoney) の結果 のアサーション
        assertNull(result);

        // Then - CustomMoney の this インスタンス のアサーション
        assertEquals(1, underTest.amount());
        assertEquals("currency", underTest.fCurrency);

    }

    /**
     * Parasoft Jtest UTA: Test for addMoney(Money)
     *
     * @see examples.junit.Money#addMoney(Money)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testAddMoney() throws Throwable
    {
        // Given
        int amount = 1; // UTA: デフォルト値
        String currency = "currency"; // UTA: デフォルト値
        CustomMoney underTest = new CustomMoney(amount, currency);

        // When
        Money m = mock(Money.class);
        String currencyResult = "currencyResult"; // UTA: 設定値
        when(m.currency()).thenReturn(currencyResult);
        IMoney result = underTest.addMoney(m);

        // Then - メソッド addMoney(Money) の結果 のアサーション
        assertNotNull(result);

        // Then - CustomMoney の this インスタンス のアサーション
        assertEquals(1, underTest.amount());
        assertEquals("currency", underTest.fCurrency);

    }

    /**
     * Parasoft Jtest UTA: Test for addMoney(Money)
     *
     * @see examples.junit.Money#addMoney(Money)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testAddMoney2() throws Throwable
    {
        // Given
        int amount = 1; // UTA: デフォルト値
        String currency = "currency"; // UTA: デフォルト値
        CustomMoney underTest = new CustomMoney(amount, currency);
        setPrivateField(underTest, Money.class, "fAmount", 0); // UTA: 設定値

        // When
        Money m = mock(Money.class);
        String currencyResult = "currencyResult"; // UTA: 設定値
        when(m.currency()).thenReturn(currencyResult);
        IMoney result = underTest.addMoney(m);

        // Then - メソッド addMoney(Money) の結果 のアサーション
        assertNotNull(result);

        // Then - CustomMoney の this インスタンス のアサーション
        assertEquals(0, underTest.amount());
        assertEquals("currency", underTest.fCurrency);

    }

    /**
     * Parasoft Jtest UTA: private フィールド fAmount を設定するヘルパー メソッド
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
     * Parasoft Jtest UTA: Test for addMoneyBag(MoneyBag)
     *
     * @see examples.junit.Money#addMoneyBag(MoneyBag)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testAddMoneyBag() throws Throwable
    {
        // Given
        int amount = 1; // UTA: デフォルト値
        String currency = "currency"; // UTA: デフォルト値
        CustomMoney underTest = new CustomMoney(amount, currency);

        // When
        MoneyBag s = mock(MoneyBag.class);
        IMoney result = underTest.addMoneyBag(s);

        // Then - メソッド addMoneyBag(MoneyBag) の結果 のアサーション
        assertNull(result);

        // Then - CustomMoney の this インスタンス のアサーション
        assertEquals(1, underTest.amount());
        assertEquals("currency", underTest.fCurrency);

    }

    /**
     * Parasoft Jtest UTA: Test for equals(Object)
     *
     * @see examples.junit.Money#equals(Object)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testEquals() throws Throwable
    {
        // Given
        int amount = 1; // UTA: デフォルト値
        String currency = "currency"; // UTA: デフォルト値
        CustomMoney underTest = new CustomMoney(amount, currency);
        setPrivateField(underTest, Money.class, "fAmount", 0); // UTA: 設定値

        // When
        Object anObject = new Object(); // UTA: デフォルト値
        boolean result = underTest.equals(anObject);

        // Then - メソッド equals(Object) の結果 のアサーション
        assertFalse(result);

        // Then - CustomMoney の this インスタンス のアサーション
        assertEquals(0, underTest.amount());
        assertEquals("currency", underTest.fCurrency);

    }

    /**
     * Parasoft Jtest UTA: Test for hashCode()
     *
     * @see examples.junit.Money#hashCode()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testHashCode() throws Throwable
    {
        // Given
        int amount = 1; // UTA: デフォルト値
        String currency = "currency"; // UTA: デフォルト値
        CustomMoney underTest = new CustomMoney(amount, currency);
        setPrivateField(underTest, Money.class, "fAmount", 0); // UTA: 設定値

        // When
        int result = underTest.hashCode();

        // Then - メソッド hashCode() の結果 のアサーション
        // assertEquals(1, result);// UTA: 期待値は不安定である可能性があります

        // Then - CustomMoney の this インスタンス のアサーション
        assertEquals(0, underTest.amount());
        assertEquals("currency", underTest.fCurrency);

    }

    /**
     * Parasoft Jtest UTA: Test for hashCode()
     *
     * @see examples.junit.Money#hashCode()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testHashCode2() throws Throwable
    {
        // Given
        int amount = 1; // UTA: デフォルト値
        String currency = "currency"; // UTA: デフォルト値
        CustomMoney underTest = new CustomMoney(amount, currency);
        String fCurrencyValue = "fCurrencyValue"; // UTA: デフォルト値
        underTest.fCurrency = fCurrencyValue;
        setPrivateField(underTest, Money.class, "fAmount", 1); // UTA: 設定値

        // When
        int result = underTest.hashCode();

        // Then - メソッド hashCode() の結果 のアサーション
        // assertEquals(1, result);// UTA: 期待値は不安定である可能性があります

        // Then - CustomMoney の this インスタンス のアサーション
        assertEquals(1, underTest.amount());
        assertEquals("fCurrencyValue", underTest.fCurrency);

    }

    /**
     * Parasoft Jtest UTA: Test for multiply(int)
     *
     * @see examples.junit.Money#multiply(int)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testMultiply() throws Throwable
    {
        // Given
        int amount = 1; // UTA: デフォルト値
        String currency = "currency"; // UTA: デフォルト値
        CustomMoney underTest = new CustomMoney(amount, currency);

        // When
        int factor = 1; // UTA: デフォルト値
        IMoney result = underTest.multiply(factor);

        // Then - メソッド multiply(int) の結果 のアサーション
        assertNotNull(result);

        // Then - CustomMoney の this インスタンス のアサーション
        assertEquals(1, underTest.amount());
        assertEquals("currency", underTest.fCurrency);

    }

    /**
     * Parasoft Jtest UTA: Test for negate()
     *
     * @see examples.junit.Money#negate()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testNegate() throws Throwable
    {
        // Given
        int amount = 1; // UTA: デフォルト値
        String currency = "currency"; // UTA: デフォルト値
        CustomMoney underTest = new CustomMoney(amount, currency);

        // When
        IMoney result = underTest.negate();

        // Then - メソッド negate() の結果 のアサーション
        assertNotNull(result);

        // Then - CustomMoney の this インスタンス のアサーション
        assertEquals(1, underTest.amount());
        assertEquals("currency", underTest.fCurrency);

    }

    /**
     * Parasoft Jtest UTA: Test for subtract(IMoney)
     *
     * @see examples.junit.Money#subtract(IMoney)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testSubtract() throws Throwable
    {
        // Given
        int amount = 1; // UTA: デフォルト値
        String currency = "currency"; // UTA: デフォルト値
        CustomMoney underTest = new CustomMoney(amount, currency);

        // When
        IMoney m = mock(IMoney.class);
        IMoney negateResult = mock(IMoney.class);
        when(m.negate()).thenReturn(negateResult);
        IMoney result = underTest.subtract(m);

        // Then - メソッド subtract(IMoney) の結果 のアサーション
        assertNull(result);

        // Then - CustomMoney の this インスタンス のアサーション
        assertEquals(1, underTest.amount());
        assertEquals("currency", underTest.fCurrency);

    }

    /**
     * Parasoft Jtest UTA: Test for toString()
     *
     * @see examples.junit.Money#toString()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testToString() throws Throwable
    {
        // Given
        int amount = 1; // UTA: デフォルト値
        String currency = "currency"; // UTA: デフォルト値
        CustomMoney underTest = new CustomMoney(amount, currency);
        String fCurrencyValue = "fCurrencyValue"; // UTA: デフォルト値
        underTest.fCurrency = fCurrencyValue;

        // When
        String result = underTest.toString();

        // Then - メソッド toString() の結果 のアサーション
        assertEquals("[1 fCurrencyValue]", result);

        // Then - CustomMoney の this インスタンス のアサーション
        assertEquals(1, underTest.amount());
        assertEquals("fCurrencyValue", underTest.fCurrency);

    }
}
