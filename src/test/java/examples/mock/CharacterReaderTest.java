package examples.mock;

import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 * Parasoft Jtest UTA: Test class for CharacterReader
 *
 * @see examples.mock.CharacterReader
 * @author yoneta
 */
public class CharacterReaderTest
{

    /**
     * Parasoft Jtest UTA: Test for read(Reader)
     *
     * @see examples.mock.CharacterReader#read(Reader)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testRead() throws Throwable
    {
        // Given
        CharacterReader underTest = new CharacterReader();

        // When
        Reader reader = mock(Reader.class);
        boolean readyResult = false; // UTA: 設定値
        when(reader.ready()).thenReturn(readyResult);
        underTest.read(reader);

    }

    /**
     * Parasoft Jtest UTA: Test for read(Reader)
     *
     * @see examples.mock.CharacterReader#read(Reader)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testRead2() throws Throwable
    {
        // Given
        CharacterReader underTest = new CharacterReader();

        // When
        Reader reader = mock(Reader.class);
        boolean readyResult = true; // UTA: 設定値
        when(reader.ready()).thenReturn(readyResult);
        underTest.read(reader);

    }

    /**
     * Parasoft Jtest UTA: Test for readString(Reader)
     *
     * @see examples.mock.CharacterReader#readString(Reader)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testReadString() throws Throwable
    {
        // Given
        CharacterReader underTest = new CharacterReader();

        // When
        Reader reader = mock(Reader.class);
        int readResult = 0; // UTA: 設定値
        when(reader.read(nullable(char[].class))).thenReturn(readResult);
        String result = underTest.readString(reader);

        // Then - メソッド readString(Reader) の結果 のアサーション
        assertNull(result);

    }

    /**
     * Parasoft Jtest UTA: Test for readString(Reader)
     *
     * @see examples.mock.CharacterReader#readString(Reader)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testReadString2() throws Throwable
    {
        // Given
        CharacterReader underTest = new CharacterReader();

        // When
        Reader reader = mock(Reader.class);
        int readResult = 1; // UTA: 設定値
        int readResult2 = 0; // UTA: 設定値
        when(reader.read(nullable(char[].class))).thenReturn(readResult, readResult2);
        String result = underTest.readString(reader);

        // Then - メソッド readString(Reader) の結果 のアサーション
        assertEquals("\0", result);

    }

}
