package examples.flowanalysis;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
/**
 * Parasoft Jtest UTA: Test class for InefficientCollectionRemoval
 *
 * @see examples.flowanalysis.InefficientCollectionRemoval
 * @author yoneta
 */
public class InefficientCollectionRemovalTest
{

    /**
     * Parasoft Jtest UTA: Test for effectiveRemoval(Collection)
     *
     * @see examples.flowanalysis.InefficientCollectionRemoval#effectiveRemoval(Collection)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testEffectiveRemoval() throws Throwable
    {
        // Given
        InefficientCollectionRemoval underTest = new InefficientCollectionRemoval();

        // When
        Collection<Object> collection = new ArrayList<Object>(); // UTA: デフォルト値
        underTest.effectiveRemoval(collection);

    }

    /**
     * Parasoft Jtest UTA: Test for inefficientRemoval(Collection)
     *
     * @see examples.flowanalysis.InefficientCollectionRemoval#inefficientRemoval(Collection)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testInefficientRemoval() throws Throwable
    {
        // Given
        InefficientCollectionRemoval underTest = new InefficientCollectionRemoval();

        // When
        Collection<Object> collection = new ArrayList<Object>(); // UTA: デフォルト値
        underTest.inefficientRemoval(collection);

    }

}
