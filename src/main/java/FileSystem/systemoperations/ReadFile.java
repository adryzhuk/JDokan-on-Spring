package FileSystem.systemoperations;

import FileSystem.VirtualFile;
import com.sun.jna.Pointer;
import com.sun.jna.WString;
import com.sun.jna.ptr.IntByReference;
import dokan.DokanFileInfo;
import dokan.callbacks.CommonCalback;
import dokan.callbacks.ReadFileCallback;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public class ReadFile implements CommonCalback,Root,ReadFileCallback {
    @Override
    public int invoke(WString fileName, Pointer buffer, int bufferLen, IntByReference numberOfBytesRead, long offset, DokanFileInfo dokanFileInfo) {
        VirtualFile file = (VirtualFile) root.getFile(fileName);
        if (file == null) {
            return -ERROR_FILE_NOT_FOUND;
        }

        return file.read(buffer, offset, bufferLen, numberOfBytesRead) ? 1 : 0;
    }
}
