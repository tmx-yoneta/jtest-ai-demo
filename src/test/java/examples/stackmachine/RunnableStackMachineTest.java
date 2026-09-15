package examples.stackmachine;

import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
/**
 * Parasoft Jtest UTA: Test class for RunnableStackMachine
 *
 * @see examples.stackmachine.RunnableStackMachine
 * @author yoneta
 */
public class RunnableStackMachineTest
{

    /**
     * Parasoft Jtest UTA: Test for componentResized(ComponentEvent)
     *
     * @see examples.stackmachine.RunnableStackMachine#componentResized(ComponentEvent)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testComponentResized() throws Throwable
    {
        // Given
        RunnableStackMachine underTest = new RunnableStackMachine();
        StackList _stackListValue = mock(StackList.class);
        underTest._stackList = _stackListValue;

        // When
        ComponentEvent e = mock(ComponentEvent.class);
        underTest.componentResized(e);

        // Then - RunnableStackMachine の this インスタンス のアサーション
        assertNotNull(underTest._stackSizeLabel);
        assertNotNull(underTest._stackList);
        assertNotNull(underTest._pushTextField);
        assertNotNull(underTest._scrollPane);

    }

    /**
     * Parasoft Jtest UTA: Test for main(String[])
     *
     * @see examples.stackmachine.RunnableStackMachine#main(String[])
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testMain() throws Throwable
    {
        // When
        String[] args = new String[1]; // UTA: デフォルト値
        args[0] = "args[0]"; // UTA: デフォルト値
        RunnableStackMachine.main(args);

    }

    /**
     * Parasoft Jtest UTA: Test for windowClosing(WindowEvent)
     *
     * @see examples.stackmachine.RunnableStackMachine#windowClosing(WindowEvent)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testWindowClosing() throws Throwable
    {
        // Given
        RunnableStackMachine underTest = new RunnableStackMachine();

        // When
        WindowEvent e = mock(WindowEvent.class);
        underTest.windowClosing(e);

    }
}
