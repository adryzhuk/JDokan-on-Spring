package FileSystem.systemoperations;

import FileSystem.VirtualFile;
import com.sun.jna.WString;
import com.sun.jna.platform.win32.WinBase;
import dokan.DokanFileInfo;
import dokan.callbacks.CommonCalback;
import dokan.callbacks.SetFileTimeCallback;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public class SetFileTimes implements CommonCalback,SetFileTimeCallback {
    @Override
    public int invoke(WString fileName, WinBase.FILETIME creationTime, WinBase.FILETIME lastAccessTime, WinBase.FILETIME lastWriteTime, DokanFileInfo dokanFileInfo) {
        VirtualFile file = (VirtualFile)root.getFile(fileName);
        if (file == null) {
            return -ERROR_FILE_NOT_FOUND;
        }

        if (timeIsSet(creationTime))
            file.setCreationTime(creationTime.toDate());
        if (timeIsSet(lastAccessTime))
            file.setLastAccessTime(lastAccessTime.toDate());
        if (timeIsSet(lastWriteTime))
            file.setLastWriteTime(lastWriteTime.toDate());

        return ERROR_SUCCESS;
    }
    private boolean timeIsSet(WinBase.FILETIME time) {
        return !(time.dwHighDateTime == 0 && time.dwLowDateTime == 0);
    }
}
