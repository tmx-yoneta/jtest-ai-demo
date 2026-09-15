package examples.flowanalysis;

import org.junit.Test;
/**
 * Parasoft Jtest UTA: Test class for AlwaysCloseNIOChannels
 *
 * @see examples.flowanalysis.AlwaysCloseNIOChannels
 * @author yoneta
 */
public class AlwaysCloseNIOChannelsTest
{

    /**
     * Parasoft Jtest UTA: Test for process(String)
     *
     * @see examples.flowanalysis.AlwaysCloseNIOChannels#process(String)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testProcess() throws Throwable
    {
        // Given
        AlwaysCloseNIOChannels underTest = new AlwaysCloseNIOChannels();

        // When
        String filename = "filename"; // UTA: デフォルト値
        underTest.process(filename);

    }

    /**
     * Parasoft Jtest UTA: Test for processClose(String)
     *
     * @see examples.flowanalysis.AlwaysCloseNIOChannels#processClose(String)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testProcessClose() throws Throwable
    {
        // Given
        AlwaysCloseNIOChannels underTest = new AlwaysCloseNIOChannels();

        // When
        String filename = "filename"; // UTA: デフォルト値
        underTest.processClose(filename);

    }
}
