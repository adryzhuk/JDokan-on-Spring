package FileSystem.systemoperations;

import FileSystem.VirtualFile;
import com.sun.jna.WString;
import dokan.DokanFileInfo;
import dokan.DokanLibrary;
import dokan.callbacks.CommonCalback;
import dokan.callbacks.FindFilesCallback;

import java.io.UnsupportedEncodingException;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public class FindFiles implements Root,FindFilesCallback,CommonCalback {
    @Override
    public int invoke(WString path, DokanLibrary.FillFindDataCallback fillFindData, DokanFileInfo dokanFileInfo) throws UnsupportedEncodingException {
        VirtualFile folder =(VirtualFile) root.getFile(path);

        if (folder == null) {
            return -ERROR_PATH_NOT_FOUND;
        }

        for (VirtualFile file : folder.getFiles()) {
            fillFindData.invoke(file.getWin32FindData(), dokanFileInfo);
        }

        return ERROR_SUCCESS;
    }
}
