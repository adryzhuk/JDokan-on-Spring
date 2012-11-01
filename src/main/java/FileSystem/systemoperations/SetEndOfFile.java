package FileSystem.systemoperations;

import FileSystem.VirtualFile;
import com.sun.jna.WString;
import dokan.DokanFileInfo;
import dokan.callbacks.CommonCalback;
import dokan.callbacks.SetEndOfFileCallback;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public class SetEndOfFile implements CommonCalback,Root,SetEndOfFileCallback {
    @Override
    public int invoke(WString fileName, long length, DokanFileInfo dokanFileInfo) {
        VirtualFile file =(VirtualFile) root.getFile(fileName);
        if (file == null) {
            return -ERROR_FILE_NOT_FOUND;
        }

        if (file.setEOF(length)) {
            return ERROR_SUCCESS;
        } else {
            return -ERROR_GENERAL_ERROR;
        }
    }
}
