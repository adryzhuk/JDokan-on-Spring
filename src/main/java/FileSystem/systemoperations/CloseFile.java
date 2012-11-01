package FileSystem.systemoperations;

import com.sun.jna.WString;
import dokan.DokanFileInfo;
import dokan.callbacks.CloseFileCallback;
import dokan.callbacks.CommonCalback;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public class CloseFile implements CloseFileCallback,CommonCalback {
    @Override
    public int invoke(WString fileName, DokanFileInfo dokanFileInfo) {
        if (dokanFileInfo.context != 0) {
            dokanFileInfo.context = 0;
            return ERROR_SUCCESS;
        } else {
            return -ERROR_GENERAL_ERROR;
        }
    }
}
