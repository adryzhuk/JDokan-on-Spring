package FileSystem.systemoperations;

import dokan.DokanFileInfo;
import dokan.callbacks.CommonCalback;
import dokan.callbacks.UnmountCallback;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public class Unmount implements CommonCalback,Root,UnmountCallback {
    @Override
    public int invoke(DokanFileInfo dokanFileInfo) {
        return ERROR_SUCCESS;
    }
}
