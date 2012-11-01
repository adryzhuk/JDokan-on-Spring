package FileSystem.systemoperations;

import FileSystem.VirtualFile;
import com.sun.jna.WString;
import dokan.DokanFileInfo;
import dokan.callbacks.CommonCalback;
import dokan.callbacks.DeleteDirectoryCallback;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public class DeleteDirectory implements CommonCalback,DeleteDirectoryCallback {
    @Override
    public int invoke(WString path, DokanFileInfo dokanFileInfo) {
        VirtualFile file = (VirtualFile) root.getFile(path);
        if (file == null) {
            return -ERROR_FILE_NOT_FOUND;
        }

        return file.isDirectory() ? ERROR_SUCCESS : -ERROR_FILE_NOT_FOUND;
    }
}
