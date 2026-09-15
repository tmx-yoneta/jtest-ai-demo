package examples.flowanalysis;

import org.junit.Test;
/**
 * Parasoft Jtest UTA: Test class for AlwaysCloseGSS
 *
 * @see examples.flowanalysis.AlwaysCloseGSS
 * @author yoneta
 */
public class AlwaysCloseGSSTest
{

    /**
     * Parasoft Jtest UTA: Test for process(byte[])
     *
     * @see examples.flowanalysis.AlwaysCloseGSS#process(byte[])
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testProcess() throws Throwable
    {
        // Given
        AlwaysCloseGSS underTest = new AlwaysCloseGSS();

        // When
        byte[] tokens = new byte[1]; // UTA: デフォルト値
        tokens[0] = (byte) 1; // UTA: デフォルト値
        underTest.process(tokens);

    }

    /**
     * Parasoft Jtest UTA: Test for processClose(byte[])
     *
     * @see examples.flowanalysis.AlwaysCloseGSS#processClose(byte[])
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testProcessClose() throws Throwable
    {
        // Given
        AlwaysCloseGSS underTest = new AlwaysCloseGSS();

        // When
        byte[] tokens = new byte[1]; // UTA: デフォルト値
        tokens[0] = (byte) 1; // UTA: デフォルト値
        underTest.processClose(tokens);

    }
}
