package examples.stackmachine;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Parasoft Jtest UTA: Test class for CommandLineStackMachine
 *
 * @see examples.stackmachine.CommandLineStackMachine
 * @author yoneta
 */
public class CommandLineStackMachineTest
{

    /**
     * Parasoft Jtest UTA: Test for getStack()
     *
     * @see examples.stackmachine.CommandLineStackMachine#getStack()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testGetStack() throws Throwable
    {
        // When
        String result = CommandLineStackMachine.getStack();

        // Then - メソッド getStack() の結果 のアサーション
        assertEquals("[]", result);

    }

    /**
     * Parasoft Jtest UTA: Test for main(String[])
     *
     * @see examples.stackmachine.CommandLineStackMachine#main(String[])
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testMain() throws Throwable
    {
        // When
        String[] args = new String[1]; // UTA: 設定値
        args[0] = "args[0]"; // UTA: デフォルト値
        CommandLineStackMachine.main(args);

    }

}
