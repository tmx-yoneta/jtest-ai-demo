package examples.demo;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class ResourceLeakDemo2 {

    public void connectClient(ServerSocket srvSocket) {
        Socket sock = null;
        try {
            sock = srvSocket.accept();
        } catch (IOException ioe) {
            System.out.println("Exception occured: " + ioe);
        } finally {
            try {
                sock.close();
            } catch (Exception e) {
            }
        }
    }
}
