package examples.flowanalysis;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
/**
 * Parasoft Jtest UTA: Test class for InefficientMapRemoval
 *
 * @see examples.flowanalysis.InefficientMapRemoval
 * @author yoneta
 */
public class InefficientMapRemovalTest
{

    /**
     * Parasoft Jtest UTA: Test for effectiveRemoval(Map)
     *
     * @see examples.flowanalysis.InefficientMapRemoval#effectiveRemoval(Map)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testEffectiveRemoval() throws Throwable
    {
        // Given
        InefficientMapRemoval underTest = new InefficientMapRemoval();

        // When
        Map<Object, Object> map = new HashMap<Object, Object>(); // UTA: デフォルト値
        underTest.effectiveRemoval(map);

    }

    /**
     * Parasoft Jtest UTA: Test for effectiveRemovalKeySet(Map)
     *
     * @see examples.flowanalysis.InefficientMapRemoval#effectiveRemovalKeySet(Map)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testEffectiveRemovalKeySet() throws Throwable
    {
        // Given
        InefficientMapRemoval underTest = new InefficientMapRemoval();

        // When
        Map<Object, Object> map = new HashMap<Object, Object>(); // UTA: デフォルト値
        underTest.effectiveRemovalKeySet(map);

    }

    /**
     * Parasoft Jtest UTA: Test for inefficientRemoval(Map)
     *
     * @see examples.flowanalysis.InefficientMapRemoval#inefficientRemoval(Map)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testInefficientRemoval() throws Throwable
    {
        // Given
        InefficientMapRemoval underTest = new InefficientMapRemoval();

        // When
        Map<Object, Object> map = new HashMap<Object, Object>(); // UTA: デフォルト値
        underTest.inefficientRemoval(map);

    }

    /**
     * Parasoft Jtest UTA: Test for inefficientRemoval(Map)
     *
     * @see examples.flowanalysis.InefficientMapRemoval#inefficientRemoval(Map)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testInefficientRemoval2() throws Throwable
    {
        // Given
        InefficientMapRemoval underTest = new InefficientMapRemoval();

        // When
        Map<Object, Object> map = new HashMap<Object, Object>(); // UTA: デフォルト値
        Object key = new Object(); // UTA: デフォルト値
        Object value = new Object(); // UTA: デフォルト値
        map.put(key, value);
        underTest.inefficientRemoval(map);

        // Then - メソッド inefficientRemoval(Map) の引数 1 のアサーション
        assertNotNull(map);
        assertEquals(0, map.size());

    }

    /**
     * Parasoft Jtest UTA: Test for inefficientRemovalEntry(Map)
     *
     * @see examples.flowanalysis.InefficientMapRemoval#inefficientRemovalEntry(Map)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testInefficientRemovalEntry() throws Throwable
    {
        // Given
        InefficientMapRemoval underTest = new InefficientMapRemoval();

        // When
        Map<Object, Object> map = new HashMap<Object, Object>(); // UTA: デフォルト値
        underTest.inefficientRemovalEntry(map);

    }

    /**
     * Parasoft Jtest UTA: Test for inefficientRemovalEntry(Map)
     *
     * @see examples.flowanalysis.InefficientMapRemoval#inefficientRemovalEntry(Map)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testInefficientRemovalEntry2() throws Throwable
    {
        // Given
        InefficientMapRemoval underTest = new InefficientMapRemoval();

        // When
        Map<Object, Object> map = new HashMap<Object, Object>(); // UTA: デフォルト値
        Object key = new Object(); // UTA: デフォルト値
        Object value = new Object(); // UTA: デフォルト値
        map.put(key, value);
        underTest.inefficientRemovalEntry(map);

        // Then - メソッド inefficientRemovalEntry(Map) の引数 1 のアサーション
        assertNotNull(map);
        assertEquals(0, map.size());

    }
}
