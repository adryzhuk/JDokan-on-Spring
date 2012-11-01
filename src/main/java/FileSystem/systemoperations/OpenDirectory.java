package FileSystem.systemoperations;

import FileSystem.VirtualFile;
import com.sun.jna.WString;
import dokan.DokanFileInfo;
import dokan.callbacks.CommonCalback;
import dokan.callbacks.OpenDirectoryCallback;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public class OpenDirectory implements CommonCalback,OpenDirectoryCallback{
    @Override
    public int invoke(WString fileName, DokanFileInfo dokanFileInfo) {
        VirtualFile dir =(VirtualFile) root.getFile(fileName);
        if (dir == null) {
            return -ERROR_PATH_NOT_FOUND;
        }

        if (dir.isDirectory()) {
            dokanFileInfo.context = dir.hashCode();
            dokanFileInfo.isDirectory = 1;
            return ERROR_SUCCESS;
        } else {
            return -ERROR_GENERAL_ERROR;
        }

    }
}
