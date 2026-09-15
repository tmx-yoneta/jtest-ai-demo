package examples.mock;

import java.nio.CharBuffer;

import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
/**
 * Parasoft Jtest UTA: Test class for MultiSourceCharacterReader
 *
 * @see examples.mock.MultiSourceCharacterReader
 * @author yoneta
 */
public class MultiSourceCharacterReaderTest
{

    /**
     * Parasoft Jtest UTA: Test for initialize()
     *
     * @see examples.mock.MultiSourceCharacterReader#initialize()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testInitialize() throws Throwable
    {
        // Given
        Readable readable = mock(Readable.class);
        MultiSourceCharacterReader underTest = new MultiSourceCharacterReader(readable);

        // When
        underTest.initialize();

        // Then - MultiSourceCharacterReader の this インスタンス のアサーション
        assertNull(underTest._readablePublic);

    }

}
