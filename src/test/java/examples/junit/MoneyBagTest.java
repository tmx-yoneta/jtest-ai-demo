package examples.junit;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 * Parasoft Jtest UTA: Test class for MoneyBag
 *
 * @see examples.junit.MoneyBag
 * @author yoneta
 */
public class MoneyBagTest
{

    /**
     * Parasoft Jtest UTA: Test for add(IMoney)
     *
     * @see examples.junit.MoneyBag#add(IMoney)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testAdd() throws Throwable
    {
        // Given
        MoneyBag underTest = new MoneyBag();

        // When
        IMoney m = mock(IMoney.class);
        IMoney result = underTest.add(m);

        // Then - メソッド add(IMoney) の結果 のアサーション
        assertNull(result);

    }

    /**
     * Parasoft Jtest UTA: Test for addMoney(Money)
     *
     * @see examples.junit.MoneyBag#addMoney(Money)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testAddMoney() throws Throwable
    {
        // Given
        MoneyBag underTest = new MoneyBag();
        List<Money> fMoniesValue = new ArrayList<Money>(); // UTA: デフォルト値
        setPrivateField(underTest, MoneyBag.class, "fMonies", fMoniesValue);

        // When
        Money m = mock(Money.class);
        IMoney result = underTest.addMoney(m);

        // Then - メソッド addMoney(Money) の結果 のアサーション
        assertNotNull(result);

    }

    /**
     * Parasoft Jtest UTA: private フィールド fMonies を設定するヘルパー メソッド
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
     * Parasoft Jtest UTA: Test for addMoney(Money)
     *
     * @see examples.junit.MoneyBag#addMoney(Money)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testAddMoney2() throws Throwable
    {
        // Given
        MoneyBag underTest = new MoneyBag();
        List<Money> fMoniesValue = new ArrayList<Money>(); // UTA: デフォルト値
        Money item = mock(Money.class);
        boolean isZeroResult = true; // UTA: 設定値
        when(item.isZero()).thenReturn(isZeroResult);
        fMoniesValue.add(item);
        setPrivateField(underTest, MoneyBag.class, "fMonies", fMoniesValue);

        // When
        Money m = mock(Money.class);
        IMoney result = underTest.addMoney(m);

        // Then - メソッド addMoney(Money) の結果 のアサーション
        assertNotNull(result);

    }

    /**
     * Parasoft Jtest UTA: Test for addMoney(Money)
     *
     * @see examples.junit.MoneyBag#addMoney(Money)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testAddMoney3() throws Throwable
    {
        // Given
        MoneyBag underTest = new MoneyBag();
        List<Money> fMoniesValue = new ArrayList<Money>(); // UTA: デフォルト値
        Money item = mock(Money.class);
        boolean isZeroResult = false; // UTA: 設定値
        when(item.isZero()).thenReturn(isZeroResult);
        fMoniesValue.add(item);
        setPrivateField(underTest, MoneyBag.class, "fMonies", fMoniesValue);

        // When
        Money m = mock(Money.class);
        IMoney result = underTest.addMoney(m);

        // Then - メソッド addMoney(Money) の結果 のアサーション
        assertNotNull(result);

    }

    /**
     * Parasoft Jtest UTA: Test for addMoneyBag(MoneyBag)
     *
     * @see examples.junit.MoneyBag#addMoneyBag(MoneyBag)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testAddMoneyBag() throws Throwable
    {
        // Given
        MoneyBag underTest = new MoneyBag();
        List<Money> fMoniesValue = new ArrayList<Money>(); // UTA: デフォルト値
        setPrivateField(underTest, MoneyBag.class, "fMonies", fMoniesValue);

        // When
        MoneyBag s = mock(MoneyBag.class);
        IMoney result = underTest.addMoneyBag(s);

        // Then - メソッド addMoneyBag(MoneyBag) の結果 のアサーション
        assertNotNull(result);

    }

    /**
     * Parasoft Jtest UTA: Test for appendMoney(Money)
     *
     * @see examples.junit.MoneyBag#appendMoney(Money)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testAppendMoney() throws Throwable
    {
        // Given
        MoneyBag underTest = new MoneyBag();
        List<Money> fMoniesValue = new ArrayList<Money>(); // UTA: デフォルト値
        Money item = mock(Money.class);
        String currencyResult = "currencyResult"; // UTA: 設定値
        when(item.currency()).thenReturn(currencyResult);
        fMoniesValue.add(item);
        setPrivateField(underTest, MoneyBag.class, "fMonies", fMoniesValue);

        // When
        Money aMoney = mock(Money.class);
        boolean isZeroResult = false; // UTA: 設定値
        when(aMoney.isZero()).thenReturn(isZeroResult);
        underTest.appendMoney(aMoney);

    }

    /**
     * Parasoft Jtest UTA: Test for equals(Object)
     *
     * @see examples.junit.MoneyBag#equals(Object)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testEquals() throws Throwable
    {
        // Given
        MoneyBag underTest = new MoneyBag();
        List<Money> fMoniesValue = new ArrayList<Money>(); // UTA: デフォルト値
        setPrivateField(underTest, MoneyBag.class, "fMonies", fMoniesValue);

        // When
        Object anObject = new Object(); // UTA: デフォルト値
        boolean result = underTest.equals(anObject);

        // Then - メソッド equals(Object) の結果 のアサーション
        assertFalse(result);

    }

    /**
     * Parasoft Jtest UTA: Test for equals(Object)
     *
     * @see examples.junit.MoneyBag#equals(Object)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testEquals2() throws Throwable
    {
        // Given
        MoneyBag underTest = new MoneyBag();
        List<Money> fMoniesValue = new ArrayList<Money>(); // UTA: デフォルト値
        setPrivateField(underTest, MoneyBag.class, "fMonies", fMoniesValue);

        // When
        MoneyBag anObject = mock(MoneyBag.class);
        boolean result = underTest.equals(anObject);

        // Then - メソッド equals(Object) の結果 のアサーション
        assertFalse(result);

    }

    /**
     * Parasoft Jtest UTA: Test for hashCode()
     *
     * @see examples.junit.MoneyBag#hashCode()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testHashCode() throws Throwable
    {
        // Given
        MoneyBag underTest = new MoneyBag();
        List<Money> fMoniesValue = new ArrayList<Money>(); // UTA: デフォルト値
        setPrivateField(underTest, MoneyBag.class, "fMonies", fMoniesValue);

        // When
        int result = underTest.hashCode();

        // Then - メソッド hashCode() の結果 のアサーション
        // assertEquals(1, result);// UTA: 期待値は不安定である可能性があります

    }

    /**
     * Parasoft Jtest UTA: Test for hashCode()
     *
     * @see examples.junit.MoneyBag#hashCode()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testHashCode2() throws Throwable
    {
        // Given
        MoneyBag underTest = new MoneyBag();
        List<Money> fMoniesValue = new ArrayList<Money>(); // UTA: デフォルト値
        Money item = mock(Money.class);
        fMoniesValue.add(item);
        setPrivateField(underTest, MoneyBag.class, "fMonies", fMoniesValue);

        // When
        int result = underTest.hashCode();

        // Then - メソッド hashCode() の結果 のアサーション
        // assertEquals(1, result);// UTA: 期待値は不安定である可能性があります

    }

    /**
     * Parasoft Jtest UTA: Test for multiply(int)
     *
     * @see examples.junit.MoneyBag#multiply(int)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testMultiply() throws Throwable
    {
        // Given
        MoneyBag underTest = new MoneyBag();

        // When
        int factor = 0; // UTA: 設定値
        IMoney result = underTest.multiply(factor);

        // Then - メソッド multiply(int) の結果 のアサーション
        assertNotNull(result);

    }

    /**
     * Parasoft Jtest UTA: Test for multiply(int)
     *
     * @see examples.junit.MoneyBag#multiply(int)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testMultiply2() throws Throwable
    {
        // Given
        MoneyBag underTest = new MoneyBag();
        List<Money> fMoniesValue = new ArrayList<Money>(); // UTA: デフォルト値
        setPrivateField(underTest, MoneyBag.class, "fMonies", fMoniesValue);

        // When
        int factor = 1; // UTA: 設定値
        IMoney result = underTest.multiply(factor);

        // Then - メソッド multiply(int) の結果 のアサーション
        assertNotNull(result);

    }

    /**
     * Parasoft Jtest UTA: Test for negate()
     *
     * @see examples.junit.MoneyBag#negate()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testNegate() throws Throwable
    {
        // Given
        MoneyBag underTest = new MoneyBag();
        List<Money> fMoniesValue = new ArrayList<Money>(); // UTA: デフォルト値
        setPrivateField(underTest, MoneyBag.class, "fMonies", fMoniesValue);

        // When
        IMoney result = underTest.negate();

        // Then - メソッド negate() の結果 のアサーション
        assertNotNull(result);

    }

    /**
     * Parasoft Jtest UTA: Test for subtract(IMoney)
     *
     * @see examples.junit.MoneyBag#subtract(IMoney)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testSubtract() throws Throwable
    {
        // Given
        MoneyBag underTest = new MoneyBag();

        // When
        IMoney m = mock(IMoney.class);
        IMoney negateResult = mock(IMoney.class);
        when(m.negate()).thenReturn(negateResult);
        IMoney result = underTest.subtract(m);

        // Then - メソッド subtract(IMoney) の結果 のアサーション
        assertNull(result);

    }

    /**
     * Parasoft Jtest UTA: Test for toString()
     *
     * @see examples.junit.MoneyBag#toString()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testToString() throws Throwable
    {
        // Given
        MoneyBag underTest = new MoneyBag();
        List<Money> fMoniesValue = new ArrayList<Money>(); // UTA: デフォルト値
        setPrivateField(underTest, MoneyBag.class, "fMonies", fMoniesValue);

        // When
        String result = underTest.toString();

        // Then - メソッド toString() の結果 のアサーション
        assertEquals("{}", result);

    }

    /**
     * Parasoft Jtest UTA: Test for toString()
     *
     * @see examples.junit.MoneyBag#toString()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testToString2() throws Throwable
    {
        // Given
        MoneyBag underTest = new MoneyBag();
        List<Money> fMoniesValue = new ArrayList<Money>(); // UTA: デフォルト値
        Money item = mock(Money.class);
        fMoniesValue.add(item);
        setPrivateField(underTest, MoneyBag.class, "fMonies", fMoniesValue);

        // When
        String result = underTest.toString();

        // Then - メソッド toString() の結果 のアサーション
        assertEquals(1, result.chars().filter(ch -> ch == '{').count());
        assertEquals(1, result.chars().filter(ch -> ch == '}').count());
        assertEquals(1, result.chars().filter(ch -> ch == ',').count());

    }
}
