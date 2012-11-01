package FileSystem.systemoperations;

import com.sun.jna.WString;
import dokan.DokanFileInfo;
import dokan.callbacks.CommonCalback;
import dokan.callbacks.DeleteFileCallback;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public class DeleteFile implements Root,DeleteFileCallback,CommonCalback {
    @Override
    public int invoke(WString path, DokanFileInfo dokanFileInfo) {
        return root.fileExist(path) ? ERROR_SUCCESS : -ERROR_FILE_NOT_FOUND;
    }
}
