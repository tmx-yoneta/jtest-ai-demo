package examples.flowanalysis;

import org.ietf.jgss.GSSContext;
import org.ietf.jgss.GSSManager;

public class AlwaysCloseGSS {

    public void process(byte[] tokens) {
        GSSContext context = null;
        try {
            byte[] inputBuff = new byte[256];
            context = GSSManager.getInstance().createContext(tokens);
            context.initSecContext(inputBuff, 0, 256);
            // ...
        } catch (Exception ioe) {
            System.out.println("Exception occured: " + ioe);
        } finally {
            try {
                if (context != null) {
                    context.dispose();
                }
            } catch (Exception e) {
            }
        }
    }

    public void processClose(byte[] tokens) {
        GSSContext context = null;
        try {
            context = GSSManager.getInstance().createContext(tokens);
            byte[] inputBuff = new byte[256];
            context.initSecContext(inputBuff, 0, 256);
            // ...
        } catch (Exception ioe) {
            System.out.println("Exception occured: " + ioe);
        } finally {
            try {
                if (context != null) {
                    context.dispose();
                }
            } catch (Exception e) {
            }
        }
    }
}
