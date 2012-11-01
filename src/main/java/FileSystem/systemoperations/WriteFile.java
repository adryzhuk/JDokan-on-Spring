package FileSystem.systemoperations;

import FileSystem.VirtualFile;
import com.sun.jna.Pointer;
import com.sun.jna.WString;
import com.sun.jna.ptr.IntByReference;
import dokan.DokanFileInfo;
import dokan.callbacks.CommonCalback;
import dokan.callbacks.WriteFileCallback;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public class WriteFile implements CommonCalback,WriteFileCallback {
    @Override
    public int invoke(WString fileName, Pointer buffer, int numberOfBytesToWrite, IntByReference numberOfBytesWritten, long offset, DokanFileInfo dokanFileInfo) {
        VirtualFile file = (VirtualFile)root.getFile(fileName);
        if (file == null) {
            return -ERROR_FILE_NOT_FOUND;
        }

        if (file.write(buffer, offset, numberOfBytesToWrite, numberOfBytesWritten)) {
            return ERROR_SUCCESS;
        } else {
            return -ERROR_GENERAL_ERROR;
        }
    }
}
