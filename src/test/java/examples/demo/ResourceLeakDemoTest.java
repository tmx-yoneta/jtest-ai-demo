package examples.demo;

import org.junit.Test;
/**
 * Parasoft Jtest UTA: Test class for ResourceLeakDemo
 *
 * @see examples.demo.ResourceLeakDemo
 * @author yoneta
 */
public class ResourceLeakDemoTest
{

    /**
     * Parasoft Jtest UTA: Test for readFirstByte(String)
     *
     * @see examples.demo.ResourceLeakDemo#readFirstByte(String)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testReadFirstByte() throws Throwable
    {
        // Given
        ResourceLeakDemo underTest = new ResourceLeakDemo();

        // When
        String path = "path"; // UTA: デフォルト値
        underTest.readFirstByte(path);

    }

}
