package examples.mock;

/*
 * InterpreterTest.java Created by Jtest on 7/3/14 2:47:55 PM.
 */
import java.io.DataInputStream;
import java.io.IOException;

import org.junit.Test;
import org.mockito.MockedConstruction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;
/**
 * InterpreterTest is a test class for Interpreter
 *
 * @see Interpreter
 * @author Parasoft Jtest 10.0
 */
public class InterpreterTest
{
    @Test(timeout = 10000)
    public void testAdd34() throws Throwable
    {
        try (MockedConstruction<DataInputStream> mocked = mockConstruction(DataInputStream.class, (mock, context) -> {
            when(mock.readUTF()).thenReturn("ADD");
            when(mock.readInt()).thenReturn(3, 4);
        }
        )) {
            Interpreter itp = new Interpreter(null);
            try {
                int value = itp.getNext().intValue();
                assertTrue(value == -1, "value is:" + value);
            } catch (IOException e) {
                fail(e.toString());
            }
        }
    }

    /**
     * Parasoft Jtest UTA: Test for getNext()
     *
     * @see examples.mock.Interpreter#getNext()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testGetNext() throws Throwable
    {
        try (MockedConstruction<DataInputStream> mocked = mockConstruction(DataInputStream.class, (mock, context) -> {
            when(mock.readUTF()).thenReturn("SUB");
            when(mock.readInt()).thenReturn(3, 4);
        })) {
            Interpreter underTest = new Interpreter(null);
            Integer result = underTest.getNext();

            assertTrue(result == -1, "value is:" + result);
        }
    }

    /**
     * Parasoft Jtest UTA: Test for getNext()
     *
     * @see examples.mock.Interpreter#getNext()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testGetNext2() throws Throwable
    {
        try (MockedConstruction<DataInputStream> mocked = mockConstruction(DataInputStream.class, (mock, context) -> {
            when(mock.readUTF()).thenReturn("UNKNOWN");
            when(mock.readInt()).thenReturn(0, 0);
        })) {
            Interpreter underTest = new Interpreter(null);
            Integer result = underTest.getNext();
            assertNull(result);
        }

    }
}
