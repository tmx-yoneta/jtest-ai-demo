package examples.flowanalysis.np;

import java.util.Locale;
import java.util.Map;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 * Parasoft Jtest UTA: Test class for ExtendedNullPointer
 *
 * @see examples.flowanalysis.np.ExtendedNullPointer
 * @author yoneta
 */
public class ExtendedNullPointerTest
{

    /**
     * Parasoft Jtest UTA: Test for getCountry(String, boolean)
     *
     * @see examples.flowanalysis.np.ExtendedNullPointer#getCountry(String, boolean)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testGetCountry() throws Throwable
    {
        // Given
        ExtendedNullPointer underTest = new ExtendedNullPointer();
        Map supportedLocalesMapValue = mock(Map.class);
        Locale getResult = Locale.getDefault(); // UTA: デフォルト値
        when(supportedLocalesMapValue.get(nullable(Object.class))).thenReturn(getResult);
        underTest.supportedLocalesMap = supportedLocalesMapValue;

        // When
        String languageId = "languageId"; // UTA: デフォルト値
        boolean bDisplayName = true; // UTA: 設定値
        String result = underTest.getCountry(languageId, bDisplayName);

        // Then - メソッド getCountry(String, boolean) の結果 のアサーション
        assertEquals("日本", result);

        // Then - ExtendedNullPointer の this インスタンス のアサーション
        assertEquals("", underTest.sFileName);
        assertNotNull(underTest.supportedLocalesMap);

    }

    /**
     * Parasoft Jtest UTA: Test for getCountry(String, boolean)
     *
     * @see examples.flowanalysis.np.ExtendedNullPointer#getCountry(String, boolean)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testGetCountry2() throws Throwable
    {
        // Given
        ExtendedNullPointer underTest = new ExtendedNullPointer();
        Map supportedLocalesMapValue = mock(Map.class);
        Locale getResult = Locale.getDefault(); // UTA: デフォルト値
        when(supportedLocalesMapValue.get(nullable(Object.class))).thenReturn(getResult);
        underTest.supportedLocalesMap = supportedLocalesMapValue;

        // When
        String languageId = "languageId"; // UTA: デフォルト値
        boolean bDisplayName = false; // UTA: 設定値
        String result = underTest.getCountry(languageId, bDisplayName);

        // Then - メソッド getCountry(String, boolean) の結果 のアサーション
        assertEquals("JP", result);

        // Then - ExtendedNullPointer の this インスタンス のアサーション
        assertEquals("", underTest.sFileName);
        assertNotNull(underTest.supportedLocalesMap);

    }

}
