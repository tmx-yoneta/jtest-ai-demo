package examples.junit;

import java.util.Collection;
import java.util.Map;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
/**
 * Parasoft Jtest UTA: Test class for SimpleObjectHandler
 *
 * @see examples.junit.SimpleObjectHandler
 * @author yoneta
 */
public class SimpleObjectHandlerTest
{

    /**
     * Parasoft Jtest UTA: Test for getElement()
     *
     * @see examples.junit.SimpleObjectHandler#getElement()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testGetElement() throws Throwable
    {
        // Given
        Object element = new Object(); // UTA: デフォルト値
        SimpleObjectHandler underTest = new SimpleObjectHandler(element);

        // When
        Object result = underTest.getElement();

        // Then - メソッド getElement() の結果 のアサーション
        assertNotNull(result);

    }

    /**
     * Parasoft Jtest UTA: Test for getList()
     *
     * @see examples.junit.SimpleObjectHandler#getList()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testGetList() throws Throwable
    {
        // When
        Collection<Integer> result = SimpleObjectHandler.getList();

        // Then - メソッド getList() の結果 のアサーション
        assertNotNull(result);
        assertEquals(0, result.size());

    }

    /**
     * Parasoft Jtest UTA: Test for getMap()
     *
     * @see examples.junit.SimpleObjectHandler#getMap()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testGetMap() throws Throwable
    {
        // When
        Map<Object, Object> result = SimpleObjectHandler.getMap();

        // Then - メソッド getMap() の結果 のアサーション
        assertNotNull(result);
        assertEquals(0, result.size());

    }

    /**
     * Parasoft Jtest UTA: Test for getString()
     *
     * @see examples.junit.SimpleObjectHandler#getString()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testGetString() throws Throwable
    {
        // Given
        Object element = new Object(); // UTA: デフォルト値
        SimpleObjectHandler underTest = new SimpleObjectHandler(element);

        // When
        String result = underTest.getString();

        // Then - メソッド getString() の結果 のアサーション
        assertEquals("", result);

        // Then - SimpleObjectHandler の this インスタンス のアサーション
        assertNotNull(underTest.getElement());

    }
}
