package examples.flowanalysis;

import org.junit.Test;

import examples.flowanalysis.UseBeforeInConstructorInitialization.RestrictedUser;

import static org.junit.Assert.assertEquals;
/**
 * Parasoft Jtest UTA: Test class for RestrictedUser
 *
 * @see examples.flowanalysis.UseBeforeInConstructorInitialization.RestrictedUser
 * @author yoneta
 */
public class UseBeforeInConstructorInitialization_RestrictedUserTest
{

    /**
     * Parasoft Jtest UTA: Test for checkData()
     *
     * @see examples.flowanalysis.UseBeforeInConstructorInitialization.RestrictedUser#checkData()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testCheckData() throws Throwable
    {
        // Given
        String name = "*"; // UTA: 設定値
        String password = "password"; // UTA: デフォルト値
        RestrictedUser underTest = new RestrictedUser(name, password);
        String nameValue = ""; // UTA: 設定値
        underTest.name = nameValue;
        underTest.minLoginLength = 0; // UTA: 設定値

        // When
        underTest.checkData();

        // Then - UseBeforeInConstructorInitialization.RestrictedUser の this インスタンス のアサーション
        assertEquals("", underTest.name);
        assertEquals("password", underTest.password);
        assertEquals(0, underTest.minLoginLength);

    }

    /**
     * Parasoft Jtest UTA: Test for checkData()
     *
     * @see examples.flowanalysis.UseBeforeInConstructorInitialization.RestrictedUser#checkData()
     * @author yoneta
     */
    @Test(timeout = 5000, expected = IllegalArgumentException.class)
    public void testCheckData2() throws Throwable
    {
        // Given
        String name = "*"; // UTA: 設定値
        String password = "password"; // UTA: デフォルト値
        RestrictedUser underTest = new RestrictedUser(name, password);
        String nameValue = ""; // UTA: 設定値
        underTest.name = nameValue;
        underTest.minLoginLength = 1; // UTA: 設定値

        // When
        underTest.checkData();

    }

    /**
     * Parasoft Jtest UTA: Test for checkData()
     *
     * @see examples.flowanalysis.UseBeforeInConstructorInitialization.RestrictedUser#checkData()
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testCheckData3() throws Throwable
    {
        // Given
        String name = "*"; // UTA: 設定値
        String password = "password"; // UTA: デフォルト値
        RestrictedUser underTest = new RestrictedUser(name, password);
        String nameValue = ""; // UTA: 設定値
        underTest.name = nameValue;
        underTest.minLoginLength = 0; // UTA: 設定値

        // When
        underTest.checkData();

        // Then - UseBeforeInConstructorInitialization.RestrictedUser の this インスタンス のアサーション
        assertEquals("", underTest.name);
        assertEquals("password", underTest.password);
        assertEquals(0, underTest.minLoginLength);

    }

    /**
     * Parasoft Jtest UTA: Test for checkData()
     *
     * @see examples.flowanalysis.UseBeforeInConstructorInitialization.RestrictedUser#checkData()
     * @author yoneta
     */
    @Test(timeout = 5000, expected = IllegalArgumentException.class)
    public void testCheckData4() throws Throwable
    {
        // Given
        String name = "*"; // UTA: 設定値
        String password = "password"; // UTA: デフォルト値
        RestrictedUser underTest = new RestrictedUser(name, password);
        String nameValue = ""; // UTA: 設定値
        underTest.name = nameValue;
        underTest.minLoginLength = 1; // UTA: 設定値

        // When
        underTest.checkData();

    }
}
