package examples.flowanalysis.np;

import java.util.Dictionary;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 * Parasoft Jtest UTA: Test class for MyDictionary
 *
 * @see examples.flowanalysis.np.MyDictionary
 * @author yoneta
 */
public class MyDictionaryTest
{

    /**
     * Parasoft Jtest UTA: Test for getFromDictionary(Object)
     *
     * @see examples.flowanalysis.np.MyDictionary#getFromDictionary(Object)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testGetFromDictionary() throws Throwable
    {
        // Given
        MyDictionary underTest = new MyDictionary();
        Dictionary dictValue = mock(Dictionary.class);
        String getResult = "getResult"; // UTA: デフォルト値
        when(dictValue.get(nullable(Object.class))).thenReturn(getResult);
        underTest.dict = dictValue;

        // When
        Object key = new Object(); // UTA: デフォルト値
        String result = underTest.getFromDictionary(key);

        // Then - メソッド getFromDictionary(Object) の結果 のアサーション
        assertEquals("getResult", result);

        // Then - MyDictionary の this インスタンス のアサーション
        assertNotNull(underTest.dict);

    }

    /**
     * Parasoft Jtest UTA: Test for putToDictionary(Object, Object)
     *
     * @see examples.flowanalysis.np.MyDictionary#putToDictionary(Object, Object)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testPutToDictionary() throws Throwable
    {
        // Given
        MyDictionary underTest = new MyDictionary();
        Dictionary dictValue = mock(Dictionary.class);
        underTest.dict = dictValue;

        // When
        String key = "key"; // UTA: デフォルト値
        Object value = new Object(); // UTA: デフォルト値
        underTest.putToDictionary(key, value);

        // Then - MyDictionary の this インスタンス のアサーション
        assertNotNull(underTest.dict);

    }

}
