package FileSystem.systemoperations;

import com.sun.jna.WString;
import dokan.DokanFileInfo;
import dokan.callbacks.CreateFileCallback;

/**
 * @author: Vyacheslav.Bychkovsk
 */
class CreateFile implements CreateFileCallback {
    @Override
    public int invoke(WString path, int desiredAccess, int shareMode, int creationDesposition, int flagsAndAttributes, DokanFileInfo dokanFileInfo) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}