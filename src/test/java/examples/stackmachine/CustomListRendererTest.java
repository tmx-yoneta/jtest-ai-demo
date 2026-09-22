package examples.stackmachine;

import java.awt.Graphics;

import org.junit.Test;

import static org.mockito.Mockito.mock;
/**
 * Parasoft Jtest UTA: Test class for CustomListRenderer
 *
 * @see examples.stackmachine.CustomListRenderer
 * @author yoneta
 */
public class CustomListRendererTest
{

    /**
     * Parasoft Jtest UTA: Test for paint(Graphics)
     *
     * @see examples.stackmachine.CustomListRenderer#paint(Graphics)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testPaint() throws Throwable
    {
        // Given
        CustomListRenderer underTest = new CustomListRenderer();

        // When
        Graphics g = mock(Graphics.class);
        underTest.paint(g);

    }

}
