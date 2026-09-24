package examples.flowanalysis;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;

public class AlwaysCloseSockets {

    public void connectClient(ServerSocket srvSocket) {
        try {
            Socket sock = srvSocket.accept();
            // ... communicate with client socket ...
        } catch (IOException ioe) {
            System.out.println("Exception occured: " + ioe);
        }
    }

    public void connectClientClose(ServerSocket srvSocket) {
        Socket sock = null;
        try {
            sock = srvSocket.accept();
            // ... communicate with client socket ...
        } catch (IOException ioe) {
            System.out.println("Exception occured: " + ioe);
        } finally {
            if (sock != null) {
                try {
                    sock.close();
                } catch (IOException e) {
                    System.out.println("Exception occured: " + e);
                }
            }
        }
    }
}
