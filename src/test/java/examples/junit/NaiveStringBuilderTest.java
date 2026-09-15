package examples.junit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Parasoft Jtest UTA: Test class for NaiveStringBuilder
 *
 * @see examples.junit.NaiveStringBuilder
 * @author yoneta
 */
public class NaiveStringBuilderTest
{

    /**
     * Parasoft Jtest UTA: Test for append(String)
     *
     * @see examples.junit.NaiveStringBuilder#append(String)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testAppend() throws Throwable
    {
        // Given
        String value = "value"; // UTA: デフォルト値
        NaiveStringBuilder underTest = NaiveStringBuilder.createInstance(value);

        // When
        String sTitle = "sTitle"; // UTA: デフォルト値
        String result = underTest.append(sTitle);

        // Then - メソッド append(String) の結果 のアサーション
        assertEquals("valuesTitle", result);

    }

    /**
     * Parasoft Jtest UTA: Test for append(String)
     *
     * @see examples.junit.NaiveStringBuilder#append(String)
     * @author yoneta
     */
    @Test(timeout = 5000, expected = IllegalArgumentException.class)
    public void testAppend2() throws Throwable
    {
        // Given
        String value = "value"; // UTA: デフォルト値
        NaiveStringBuilder underTest = NaiveStringBuilder.createInstance(value);

        // When
        String sTitle = null; // UTA: 設定値
        underTest.append(sTitle);

    }

}
