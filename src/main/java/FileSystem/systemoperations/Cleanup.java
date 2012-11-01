package FileSystem.systemoperations;

import com.sun.jna.WString;
import dokan.DokanFileInfo;
import dokan.callbacks.CleanupCallback;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public class Cleanup implements CleanupCallback {
    @Override
    public int invoke(WString fileName, DokanFileInfo dokanFileInfo) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}