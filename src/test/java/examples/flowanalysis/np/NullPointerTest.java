package examples.flowanalysis.np;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;
/**
 * Parasoft Jtest UTA: Test class for NullPointer
 *
 * @see examples.flowanalysis.np.NullPointer
 * @author yoneta
 */
public class NullPointerTest
{

    /**
     * Parasoft Jtest UTA: Test for getLineLength()
     *
     * @see examples.flowanalysis.np.NullPointer#getLineLength()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testGetLineLength() throws Throwable
    {
        NullPointer underTest = new NullPointer();
        Path file = Files.createTempFile("null-pointer", ".txt");
        try {
            Files.write(file, "first line".getBytes(StandardCharsets.UTF_8));
            underTest.sFileName = file.toString();
            int result = underTest.getLineLength();
            org.junit.Assert.assertEquals(10, result);
        } finally {
            Files.deleteIfExists(file);
        }

    }

    /**
     * Parasoft Jtest UTA: Test for getLineLength()
     *
     * @see examples.flowanalysis.np.NullPointer#getLineLength()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testGetLineLength2() throws Throwable
    {
        NullPointer underTest = new NullPointer();
        Path file = Files.createTempFile("null-pointer", ".txt");
        try {
            Files.write(file, "second".getBytes(StandardCharsets.UTF_8));
            underTest.sFileName = file.toString();
            int result = underTest.getLineLength();
            org.junit.Assert.assertEquals(6, result);
        } finally {
            Files.deleteIfExists(file);
        }

    }

}
