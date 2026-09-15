package examples.flowanalysis;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 * Parasoft Jtest UTA: Test class for AlwaysCloseSockets
 *
 * @see examples.flowanalysis.AlwaysCloseSockets
 * @author yoneta
 */
public class AlwaysCloseSocketsTest
{

    /**
     * Parasoft Jtest UTA: Test for connectClient(ServerSocket)
     *
     * @see examples.flowanalysis.AlwaysCloseSockets#connectClient(ServerSocket)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testConnectClient() throws Throwable
    {
        // Given
        AlwaysCloseSockets underTest = new AlwaysCloseSockets();

        // When
        ServerSocket srvSocket = mock(ServerSocket.class);
        underTest.connectClient(srvSocket);

    }

    /**
     * Parasoft Jtest UTA: Test for connectClient(ServerSocket)
     *
     * @see examples.flowanalysis.AlwaysCloseSockets#connectClient(ServerSocket)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testConnectClient2() throws Throwable
    {
        // Given
        AlwaysCloseSockets underTest = new AlwaysCloseSockets();

        // When
        ServerSocket srvSocket = mock(ServerSocket.class);
        when(srvSocket.accept()).thenThrow(IOException.class);
        underTest.connectClient(srvSocket);

    }

    /**
     * Parasoft Jtest UTA: Test for connectClientClose(ServerSocket)
     *
     * @see examples.flowanalysis.AlwaysCloseSockets#connectClientClose(ServerSocket)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testConnectClientClose() throws Throwable
    {
        // Given
        AlwaysCloseSockets underTest = new AlwaysCloseSockets();

        // When
        ServerSocket srvSocket = mock(ServerSocket.class);
        underTest.connectClientClose(srvSocket);

    }

    /**
     * Parasoft Jtest UTA: Test for connectClientClose(ServerSocket)
     *
     * @see examples.flowanalysis.AlwaysCloseSockets#connectClientClose(ServerSocket)
     * @author yoneta
     */
    @Test(timeout = 5000)
    public void testConnectClientClose2() throws Throwable
    {
        // Given
        AlwaysCloseSockets underTest = new AlwaysCloseSockets();

        // When
        ServerSocket srvSocket = mock(ServerSocket.class);
        when(srvSocket.accept()).thenThrow(IOException.class);
        underTest.connectClientClose(srvSocket);

    }
}
