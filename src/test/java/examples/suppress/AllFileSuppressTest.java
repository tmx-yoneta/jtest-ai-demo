package examples.suppress;

import org.junit.Test;
/**
 * Parasoft Jtest UTA: Test class for AllFileSuppress
 *
 * @see examples.suppress.AllFileSuppress
 * @author yoneta
 */
public class AllFileSuppressTest
{

    /**
     * Parasoft Jtest UTA: Test for main(String[])
     *
     * @see examples.suppress.AllFileSuppress#main(String[])
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testMain() throws Throwable
    {
        // When
        String[] args = new String[1]; // UTA: デフォルト値
        args[0] = "args[0]"; // UTA: デフォルト値
        AllFileSuppress.main(args);

    }
}
