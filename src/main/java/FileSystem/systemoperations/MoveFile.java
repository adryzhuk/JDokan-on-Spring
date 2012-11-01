package FileSystem.systemoperations;

import com.sun.jna.WString;
import dokan.DokanFileInfo;
import dokan.callbacks.CommonCalback;
import dokan.callbacks.MoveFileCallback;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public class MoveFile implements CommonCalback,Root,MoveFileCallback {
    @Override
    public int invoke(WString existingFileName, WString newFileName, boolean replaceExisting, DokanFileInfo dokanFileInfo) {
        if (root.moveFile(existingFileName, newFileName, replaceExisting)) {
            return ERROR_SUCCESS;
        }
        return -ERROR_GENERAL_ERROR;
    }
}
