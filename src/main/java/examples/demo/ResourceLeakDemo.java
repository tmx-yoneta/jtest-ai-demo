package examples.demo;

import java.io.FileInputStream;
import java.io.IOException;

public class ResourceLeakDemo {

    public void readFirstByte(String path) {
        FileInputStream in = null;
        try {
            in = new FileInputStream(path);
            in.read();
        } catch (IOException ioe) {
            System.out.println("Exception occured: " + ioe);
        } finally {
            try {
                in.close();
            } catch (Exception e) {
            }
        }
    }
}
