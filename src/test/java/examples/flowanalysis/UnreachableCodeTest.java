package examples.flowanalysis;

import org.junit.Test;

import static org.mockito.Mockito.mock;
/**
 * Parasoft Jtest UTA: Test class for UnreachableCode
 *
 * @see examples.flowanalysis.UnreachableCode
 * @author yoneta
 */
public class UnreachableCodeTest
{

    /**
     * Parasoft Jtest UTA: Test for guessFigure(boolean, boolean)
     *
     * @see examples.flowanalysis.UnreachableCode#guessFigure(boolean, boolean)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testGuessFigure() throws Throwable
    {
        // Given
        UnreachableCode underTest = new UnreachableCode();

        // When
        boolean round = true; // UTA: 設定値
        boolean volumetric = true; // UTA: 設定値
        underTest.guessFigure(round, volumetric);

    }

    /**
     * Parasoft Jtest UTA: Test for guessFigure(boolean, boolean)
     *
     * @see examples.flowanalysis.UnreachableCode#guessFigure(boolean, boolean)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testGuessFigure2() throws Throwable
    {
        // Given
        UnreachableCode underTest = new UnreachableCode();

        // When
        boolean round = true; // UTA: 設定値
        boolean volumetric = false; // UTA: 設定値
        underTest.guessFigure(round, volumetric);

    }

    /**
     * Parasoft Jtest UTA: Test for guessFigure(boolean, boolean)
     *
     * @see examples.flowanalysis.UnreachableCode#guessFigure(boolean, boolean)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testGuessFigure3() throws Throwable
    {
        // Given
        UnreachableCode underTest = new UnreachableCode();

        // When
        boolean round = false; // UTA: 設定値
        boolean volumetric = true; // UTA: 設定値
        underTest.guessFigure(round, volumetric);

    }

    /**
     * Parasoft Jtest UTA: Test for guessFigure(boolean, boolean)
     *
     * @see examples.flowanalysis.UnreachableCode#guessFigure(boolean, boolean)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testGuessFigure4() throws Throwable
    {
        // Given
        UnreachableCode underTest = new UnreachableCode();

        // When
        boolean round = false; // UTA: 設定値
        boolean volumetric = false; // UTA: 設定値
        underTest.guessFigure(round, volumetric);

    }

    /**
     * Parasoft Jtest UTA: Test for printCalculationResult(Object)
     *
     * @see examples.flowanalysis.UnreachableCode#printCalculationResult(Object)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testPrintCalculationResult() throws Throwable
    {
        // Given
        UnreachableCode underTest = new UnreachableCode();

        // When
        Exception result = mock(Exception.class);
        underTest.printCalculationResult(result);

    }

    /**
     * Parasoft Jtest UTA: Test for printCalculationResult(Object)
     *
     * @see examples.flowanalysis.UnreachableCode#printCalculationResult(Object)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testPrintCalculationResult2() throws Throwable
    {
        // Given
        UnreachableCode underTest = new UnreachableCode();

        // When
        Object result = new Object(); // UTA: デフォルト値
        underTest.printCalculationResult(result);

    }

}
