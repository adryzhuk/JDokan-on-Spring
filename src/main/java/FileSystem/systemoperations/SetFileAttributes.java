package FileSystem.systemoperations;

import FileSystem.VirtualFile;
import com.sun.jna.WString;
import dokan.DokanFileInfo;
import dokan.callbacks.CommonCalback;
import dokan.callbacks.SetFileAttributesCallback;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public class SetFileAttributes implements CommonCalback,SetFileAttributesCallback {
    @Override
    public int invoke(WString fileName, int fileAttributes, DokanFileInfo dokanFileInfo) {
        if ((fileAttributes & VirtualFile.MASK) == 0) { // if we actually doesn't want to set attributes of file
            return ERROR_SUCCESS;
        }

        VirtualFile file =(VirtualFile) root.getFile(fileName);
        if (file == null) {
            return -ERROR_FILE_NOT_FOUND;
        }

        file.setFlagsAndAttributes(fileAttributes);
        return ERROR_SUCCESS;
    }
}
