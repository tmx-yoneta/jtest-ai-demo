package examples.junit;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.nio.CharBuffer;

import org.junit.Test;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 * Parasoft Jtest UTA: Test class for ChoosingConstructor
 *
 * @see examples.junit.ChoosingConstructor
 * @author yoneta
 */
public class ChoosingConstructorTest
{

    /**
     * Parasoft Jtest UTA: Test for getFromStream()
     *
     * @see examples.junit.ChoosingConstructor#getFromStream()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testGetFromStream() throws Throwable
    {
        // Given
        InputStream inStream = mock(InputStream.class);
        ChoosingConstructor underTest = new ChoosingConstructor(inStream);

        // When
        underTest.getFromStream();

    }

    /**
     * Parasoft Jtest UTA: Test for performAction()
     *
     * @see examples.junit.ChoosingConstructor#performAction()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testPerformAction() throws Throwable
    {
        // Given
        InputStream inStream = mock(InputStream.class);
        ChoosingConstructor underTest = new ChoosingConstructor(inStream);
        OutputStream _outStreamValue = mock(OutputStream.class);
        setPrivateField(underTest, ChoosingConstructor.class, "_outStream", _outStreamValue);
        Readable _readableValue = mock(Readable.class);
        setPrivateField(underTest, ChoosingConstructor.class, "_readable", _readableValue);

        // When
        underTest.performAction();

    }

    /**
     * Parasoft Jtest UTA: private フィールド _outStream を設定するヘルパー メソッド
     */
    private static <T> void setPrivateField(Object object, Class<?> fieldClass, String fieldName, T value)
    {
        try {
            Field field = fieldClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(object, value);
        } catch (NoSuchFieldException e) {
            throw (AssertionError) new AssertionError("No such field found").initCause(e);
        } catch (IllegalAccessException e) {
            throw (AssertionError) new AssertionError("Unable to access the specified private field").initCause(e);
        } catch (SecurityException e) {
            throw (AssertionError) new AssertionError("There was a security exception when attempting to access a private field").initCause(e);
        }
    }

}
