package examples.stackmachine;

import java.awt.event.ComponentEvent;

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

    // NOTE(レビューで削除): AI生成時点の testMain は RunnableStackMachine.main(String[]) を
    // そのまま呼び出しており、frame.setVisible(true) でGUIウィンドウの表示を試みる。
    // ヘッドレスなCI環境ではHeadlessExceptionまたはイベントループのハングを招くため削除した。

    // NOTE(レビューで削除): AI生成時点の testWindowClosing は windowClosing(WindowEvent) を
    // 直接呼び出していたが、その実装は System.exit(0) であり、テスト実行用JVMごと
    // プロセスを終了させてしまう（Surefireのフォークプロセスがクラッシュし、
    // mvn test 全体がBUILD FAILUREになることを実機で確認した）。
    // AIは副作用（プロセス終了）を理解せずにテストを生成していたため削除した。
}
