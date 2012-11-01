package FileSystem.systemoperations;

import FileSystem.VirtualFile;
import com.sun.jna.WString;
import dokan.DokanFileInfo;
import dokan.callbacks.CommonCalback;
import dokan.callbacks.CreateDirectoryCallback;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public class CreateDirectory implements CreateDirectoryCallback,CommonCalback {
    @Override
    public int invoke(WString fileName, DokanFileInfo dokanFileInfo) {
        VirtualFile file = (VirtualFile) root.getFile(fileName);
        if (file != null) {
            return -ERROR_ALREADY_EXISTS;
        }

        file = (VirtualFile) root.createFile(fileName, VirtualFile.ATTRIBUTE_DIRECTORY);
        if (file == null) {
            return -ERROR_PATH_NOT_FOUND;
        }

        dokanFileInfo.context = file.hashCode();
        dokanFileInfo.isDirectory = 1;
        return ERROR_SUCCESS;
    }
}
