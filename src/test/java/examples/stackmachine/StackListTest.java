package examples.stackmachine;

import java.lang.reflect.Field;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 * Parasoft Jtest UTA: Test class for StackList
 *
 * @see examples.stackmachine.StackList
 * @author yoneta
 */
public class StackListTest
{

    /**
     * Parasoft Jtest UTA: private フィールド _currentStackModel を設定するヘルパー メソッド
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

    /**
     * Parasoft Jtest UTA: Test for updateModel(boolean)
     *
     * @see examples.stackmachine.StackList#updateModel(boolean)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testUpdateModel() throws Throwable
    {
        // Given
        RunnableStackMachine machineGUI = mock(RunnableStackMachine.class);
        StackList underTest = new StackList(machineGUI);
        LifoStackMachine _lifoStackModelValue = mock(LifoStackMachine.class);
        setPrivateField(underTest, StackList.class, "_lifoStackModel", _lifoStackModelValue);

        // When
        boolean lifoModel = true; // UTA: 設定値
        underTest.updateModel(lifoModel);

    }

    /**
     * Parasoft Jtest UTA: Test for updateModel(boolean)
     *
     * @see examples.stackmachine.StackList#updateModel(boolean)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testUpdateModel2() throws Throwable
    {
        // Given
        RunnableStackMachine machineGUI = mock(RunnableStackMachine.class);
        StackList underTest = new StackList(machineGUI);
        FifoStackMachine _fifoStackModelValue = mock(FifoStackMachine.class);
        setPrivateField(underTest, StackList.class, "_fifoStackModel", _fifoStackModelValue);

        // When
        boolean lifoModel = false; // UTA: 設定値
        underTest.updateModel(lifoModel);

    }

}
