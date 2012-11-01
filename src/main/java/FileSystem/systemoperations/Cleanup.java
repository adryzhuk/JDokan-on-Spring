package FileSystem.systemoperations;

import com.sun.jna.WString;
import dokan.DokanFileInfo;
import dokan.callbacks.CleanupCallback;
import dokan.callbacks.CommonCalback;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public class Cleanup implements CleanupCallback,CommonCalback {
    @Override
    public int invoke(WString fileName, DokanFileInfo dokanFileInfo) {
        if (dokanFileInfo.context != 0) {
            dokanFileInfo.context = 0;
            if (dokanFileInfo.deleteOnClose == 1) {
                if (root.deleteFileByPath(fileName) == null) {
                    return -ERROR_GENERAL_ERROR;
                }
            }
            return ERROR_SUCCESS;
        }
        return -ERROR_GENERAL_ERROR;
    }
}